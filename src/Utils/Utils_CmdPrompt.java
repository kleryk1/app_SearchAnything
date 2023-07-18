package Utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Utils_CmdPrompt {

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	Constructors																				//

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - get, set, is
	
	public static void openFolder( String dir_path ) throws IOException {
		if( Utils_Directory.isDirectory( dir_path ) ) {
			Desktop.getDesktop().open( new File( dir_path ) );
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////

} /* End-of File! */

/*
 		String dir = "D:\\Downloads";
		
		try {
			Utils_CmdPrompt.openFolder( dir );
		} catch ( IOException ex ) { ex.printStackTrace(); }
 */
