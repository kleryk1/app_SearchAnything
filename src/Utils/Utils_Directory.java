package Utils;

import java.io.File;
import java.util.Arrays;

public class Utils_Directory {

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	Constructors																				//
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - get, set, is
	
	public static String[] getDirList( String dir ) {
		String[] ret_val = null;
		
		File f = new File( dir );
		
		if( f.isDirectory() ) { // ToDo - test if isDirectory() identifies correctly 
			
			ret_val = concatWithArrayCopy( new String[]{ f.getAbsolutePath() }, getDirList( f ) );
			
		}
		
		
		return ret_val;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - S T A T I C
	
	private static String[] getDirList( File dir ) {
		String[] ret_val = {};

		for( File f : dir.listFiles() ) {
			if( f.isDirectory() ) {
				ret_val = concatWithArrayCopy( ret_val, new String[]{ f.getAbsolutePath() } );
				ret_val = concatWithArrayCopy( ret_val, getDirList( f ) );
			}
		}
		
		return ret_val;
	}


	private static String[] concatWithArrayCopy( String[] main, String[] add ) {
		String[] ret_val = Arrays.copyOf( main, main.length + add.length );
	    System.arraycopy( add , 0, ret_val, main.length, add.length );
	    return ret_val;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

} /* End-of File! */
