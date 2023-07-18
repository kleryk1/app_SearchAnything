package SearchFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Utils.Utils_ArrayOperations;
import Utils.Utils_Files;


/** 
 * ToDo - implement case_sensitive filter (the value is set but not used)
 * 
 * @author alint
 *
 */
public class SearchFile extends SearchFile_Attributes {

	private String[] last_result = null;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	Constructors																				//
	
	public SearchFile() {
		super();
	}

	public SearchFile( String search_for, String search_in, boolean regex, boolean include_dirs, boolean case_sensitive ) {
		super();
		setSearchFor( search_for );
		setSearchIn( search_in );
		setSearchRegEx( regex );
		setSearchIncludeDirs( include_dirs );
		setSearchCaseSensitive( case_sensitive );
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - get, set, is
	
	public String[] getSearchResults() {
		String[] ret_val = {};
		
		String[] file_list = Utils_Files.getFileList( search_in, include_dirs );
		for( String f : file_list ) { 
			
			if( regex == false ) {
				ret_val = Utils_ArrayOperations.concatWithArrayCopy( ret_val, getContains( f ) );
			} else {
				ret_val = Utils_ArrayOperations.concatWithArrayCopy( ret_val, getContainsRegex( f ) );
			}
			
		}
		
		last_result = ret_val;
		
		return ret_val;
	}



	public String[] getLastResult() { return last_result; }
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - S T A T I C

	private String[] getContains( String string ) {
		String[] ret_val = {};
		if( string.contains( search_for ) ) { ret_val = new String[]{ string }; }
		return ret_val;
	}
	
	private String[] getContainsRegex( String string ) {
		String[] ret_val = {};
		
//		Pattern pattern = Pattern.compile( "(\\[)(.*?)(\\])" );
		Pattern pattern = Pattern.compile( "([^\\\\s]+(\\\\.(?i)(nfo|png|gif|bmp))$)" );
		
		// ToDo - regex usage must be finished
		
        Matcher matcher = pattern.matcher( string );

        while( matcher.find() )
        {
            ret_val = new String[]{ string };
        }
		
		return ret_val;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

} /* End-of File! */

/*
		String dir = "D:\\Downloads";
		
		SearchFile sf = new SearchFile( "Kane", dir, false );
		
		sf.setSearchFor( "Kane" );
		sf.setSearchIn( dir );
		sf.setSearchRegEx( false );
		
		sf.getSearchResults();
		
		String[] res = sf.getLastResult();
		
		for( String f : res ) { System.out.println( f ); }
 */
