package Utils;

import java.io.File;

public class Utils_Files {

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	Constructors																				//

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - get, set, is
	
	public static boolean isFile( String file ) {
		File f = new File( file );
		
		// ToDo - test if isDirectory() identifies correctly
		
		return !f.isDirectory();
	}
	
	public static String[] getFileList( String dir, boolean include_dirs ) {
		String[] ret_val = {};
		
		/* get a list of all directories */
		String[] dir_list = Utils_Directory.getDirList( dir );
		for( String d : dir_list ) { 
			
			if( include_dirs ) {
				ret_val = Utils_ArrayOperations.concatWithArrayCopy( ret_val, new String[]{ d } );
			}
			
			ret_val = Utils_ArrayOperations.concatWithArrayCopy( ret_val, getFileList( new File( d ) ) );
			
		}
		
		return ret_val;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - S T A T I C
	
	private static String[] getFileList( File dir ) {
		String[] ret_val = {};

		for( File f : dir.listFiles() ) {
			if( isFile( f.getAbsolutePath() ) ) {
				ret_val = Utils_ArrayOperations.concatWithArrayCopy( ret_val, new String[]{ f.getAbsolutePath() } );
			}
		}
		
		return ret_val;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////

} /* End-of File! */
