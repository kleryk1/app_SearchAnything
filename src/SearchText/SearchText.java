package SearchText;

import SearchFile.SearchFile;

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
				System.out.println( f ); 
				
				// 	ToDo - continue here with opening all files and checking their content against the search_for
				
			}
		}
		
		last_result = ret_val;
		
		return ret_val;
	}

	public String[] getLastResult() { return last_result; }
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
} /* End-of File! */
