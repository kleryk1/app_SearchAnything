package SearchText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Configuration.Config;
import SearchFile.SearchFile;
import Utils.Utils_ArrayOperations;
import Utils.Utils_Files;

public class SearchText extends SearchText_Attributes {

	private String[] last_result = null;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	Constructors																				//

	public SearchText() {
		super();
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - get, set, is
	
	public boolean isComplete() {
		return ( (search_for != null) && (search_in != null) );
	}

	public String[] getSearchResults() {
		String[] ret_val = {};
		
		if( isComplete() ) {
			
			/* generate a list of all files  */
			String[] files = SearchFile.getFileList( search_in );
			for( String f : files ) { 
				 
				if( isTextFile( Utils_Files.getFileExtention( f ) )  ) {
					if( isTextInFile( f ) ) {
						ret_val = Utils_ArrayOperations.concatWithArrayCopy( ret_val, new String[] { f } );
					}
				} else {
					// ToDo implement non text files
					/* ToDo - ignore binary files */
					/* ToDo - ignore Office files */
					/* ToDo - ignore image files */
				}
				
			}
		}
		
		last_result = ret_val;
		
		return ret_val;
	}

	public String[] getLastResult() { return last_result; }

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - S T A T I C
	
	private boolean isTextFile( String extention ) {
		boolean ret_val = false;
		String[] text_extentions = Config.text_extentions; 
		
		for( String s : text_extentions ) {
			if( s.contains( extention ) && extention.contains( s ) ) {
				ret_val = true; break;
			}
		}
		
		return ret_val;
	}
	
	
	private boolean isTextInFile( String file ) {
		boolean ret_val = false;

		try {
			BufferedReader reader = new BufferedReader(new FileReader( file ));
			String line;

			while ((line = reader.readLine()) != null) {
				if( line.contains( search_for ) ) {
					ret_val = true; break;
				}
			}

			reader.close();
		} catch ( IOException ex ) { ex.printStackTrace(); }
		
		return ret_val;
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
} /* End-of File! */
