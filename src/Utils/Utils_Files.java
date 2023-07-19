package Utils;

import java.io.File;
import java.io.IOException;

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

	/** Check if the file exists and create if the create command is given. If the create command is set 
	 * this function will create the folder structure of the parent if it does not exist and create a file 
	 * with the same name of the last element from the given path. 
	 * 
	 * @param file_path - the path to the file
	 * @param create - if you want this function to create file at the specified path
	 * 
	 * @return
	 */
	public static boolean checkIfFileExists( String file_path, boolean create ){
		boolean ret_val = true;
		File file = new File(file_path);
		
		/* if the parent directory does not exist means that the rest of the structure does not exist also */ 
		if( (file.getParentFile() != null) && !file.getParentFile().exists() ) {	
			ret_val = false;
		}
		
		/* check if the file does not exist */
		if( !file.exists() ) { ret_val = false; }
			

		/* Create the files if they do not exist */
		if( (ret_val == false) && (create == true) ) {
			/* create the parent directory if not exist */
			if( (file.getParentFile() != null) && !file.getParentFile().exists() ) {	
				file.getParentFile().mkdirs();
			}
			
			/* try to create the file */
			try { file.createNewFile(); } 
			
			/* create the final directory if the file creation failed */
			catch (IOException e) { file.mkdirs(); }
			
			ret_val = true;
		}
		
		return ret_val;
	}
	
	
	public static String getFileExtention( String file ) {
		String ret_val = null;
		if (file.contains(".")) {
			ret_val = file.substring(file.lastIndexOf("."));
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
