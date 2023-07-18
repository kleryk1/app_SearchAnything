package Utils;

import java.io.File;
import java.util.Arrays;

public class Utils_Directory {

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	Constructors																				//
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - get, set, is
	
	public static boolean isDirectory( String dir ) {
		File f = new File( dir );
		
		// ToDo - test if isDirectory() identifies correctly
		
		return f.isDirectory();
	}
	
	public static String[] getDirList( String dir ) {
		String[] ret_val = null;
		File f = new File( dir );
		
		if( isDirectory( dir ) ) {
			ret_val = concatWithArrayCopy( new String[]{ f.getAbsolutePath() }, getDirList( f ) );
		}
		
		return ret_val;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - S T A T I C
	
	private static String[] getDirList( File dir ) {
		String[] ret_val = {};

		for( File f : dir.listFiles() ) {
			if( isDirectory( f.getAbsolutePath() ) ) {
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

/*
 		String dir = "D:\\Downloads";
		
		if( Utils_Directory.isDirectory( dir ) ) {
			System.out.println( "YES \"" + dir + "\" is a directory." );
		}
		
		String[] dirs = Utils_Directory.getDirList( dir );
		for( String d : dirs ) { System.out.println( d ); }
		
 */
