package IF_Arg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import SearchFile.SearchFile;
import SearchText.SearchText;
import Utils.Utils_Files;

/**
 * if no arguments or if arg "-gui" start GUI 
 * 
 * @author alint
 *
 */
public class PjArguments {

	private static final String FS_PREFIX = "-a_";
	public static String[][] arguments = {
											{ "-gui", "Start the graphical user interface!" },
											
											{ "-fs", "File search!" },
											{ "-ts", "Text search!" },

											{ FS_PREFIX+"sf ", "search_for!" },
											{ FS_PREFIX+"si ", "search_in!" },
											{ FS_PREFIX+"rx ", "regex!" },
											{ FS_PREFIX+"id ", "include_dirs!" },
											{ FS_PREFIX+"cs ", "case_sensitive!" },
											
											{ "> ", "Out file!" }
										 };
	
	private boolean is_gui_enabled = false;
	private ArrayList<String> command_list = new ArrayList<String>();
	
	private File out_file = null;
	private BufferedWriter bw = null;
	
	private SearchFile fs = null;
	private SearchText ts = null;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	Constructors																				//
	
	public PjArguments( String[] args ) throws IOException {
		
		/* if there are no arguments GUI can be started */
		if( args.length == 0 ) { is_gui_enabled = true; }
		
		/* remove the gui request if exists */
		for( String arg : args ) {
			if( isArgumentValid( arg ) ) {
				
//				System.out.println( "ARG: " + arg );
				
				if( arg.contains( arguments[0][0] ) && arguments[0][0].contains( arg ) ) { is_gui_enabled = true; }
				else if( arg.contains( arguments[1][0] ) && arguments[1][0].contains( arg ) ) { fs = new SearchFile(); }
				else if( arg.contains( arguments[2][0] ) && arguments[2][0].contains( arg ) ) { ts = new SearchText(); }
				else {
					command_list.add( arg );
				}
			}
		}
		
		for( String arg : command_list ) {
			if( isSearchAttribures( arg ) ) {
				setSearchAttribures( arg );
			}else{
				setOutputLocation( arg );
			}
		}
		
		/* initialize output file if required */
		if( out_file != null ) {
			FileOutputStream fos = new FileOutputStream(out_file);
			bw = new BufferedWriter( new OutputStreamWriter(fos) );
		}
				
		if( (fs != null) && fs.isComplete() ) { setResponse( fs.getSearchResults() ); }
		if( (ts != null) && ts.isComplete() ) { setResponse( ts.getSearchResults() ); }
		
//		System.out.println( this );
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - get, set, is
	
	public boolean isStartGui() { return is_gui_enabled; }

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - S T A T I C
	
	/**
	 * 
	 * @param arg
	 * @return
	 */
	private boolean isArgumentValid( String arg ) {
		boolean ret_val = false;
		
		for( String[] s : arguments ) {
			if( arg.contains(s[0]) ) {
				ret_val = true;
				break;
			}
		}
		
		if( ret_val == false ) { System.out.println( "Warning: Argument \"" + arg + "\" does not exist!" ); }
		
		return ret_val;
	}
	
	/**
	 * 
	 * @param arg
	 * @return
	 */
	private boolean isSearchAttribures( String arg ) {
		boolean ret_val = false;
		
		for( String[] s : arguments ) {
			if( s[0].contains( FS_PREFIX ) ) {
				if( arg.contains( s[0] ) ) {
					ret_val = true;
					break;
				}
			}
		}
		
		return ret_val;
	}
	
	/**
	 * 
	 * @param arg
	 */
	private void setSearchAttribures( String arg ) {
		String[] values = arg.split( " " );
		
		// ToDo validate values and data

		if( fs != null ) {
			
			if( arg.contains( arguments[3][0] ) ) { /* System.out.println( "-a_sf " ); */ fs.setSearchFor( values[1] ); }
			if( arg.contains( arguments[4][0] ) ) { /* System.out.println( "-a_si " ); */ fs.setSearchIn( values[1] ); }
			if( arg.contains( arguments[5][0] ) ) { /* System.out.println( "-a_rx " ); */ fs.setSearchRegEx( Boolean.parseBoolean( values[1] ) ); }
			if( arg.contains( arguments[6][0] ) ) { /* System.out.println( "-a_id " ); */ fs.setSearchIncludeDirs( Boolean.parseBoolean( values[1] ) ); }
			if( arg.contains( arguments[7][0] ) ) { /* System.out.println( "-a_cs " ); */ fs.setSearchCaseSensitive( Boolean.parseBoolean( values[1] ) ); }
			
		}
		
	}
	
	/**
	 * 
	 * @param arg
	 */
	private void setOutputLocation( String arg ) {
		String[] values = arg.split( " " );
		
		if( arg.contains( "> " ) && Utils_Files.checkIfFileExists( values[1], true ) ) {
			out_file = new File( values[1] );
		} else {
			System.out.println( "Warning: Argument \"" + arg + "\" exists but is not implemented!" );
		}
		
	}
	
	/**
	 * 
	 * @param res
	 * @throws IOException 
	 */
	private void setResponse( String[] results ) throws IOException {
		
		for( String line : results ) {
			System.out.println( line );
			if( (out_file != null) && (bw != null) ) {
				bw.write( line );
				bw.newLine();
			}
		}
		
		bw.close();
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override public String toString() {
		String ret_val = super.toString() + " - ";
		
		ret_val += "Arguments!\n";
		
		if( fs != null ) { ret_val += "\n\t" + fs.toString(); }
		if( ts != null ) { ret_val += "\n\t" + ts.toString(); }
		ret_val += "\n";
		ret_val += "\t  out file: " + out_file + "\n";
		ret_val += "\t gui start: " + is_gui_enabled + "\n";
		
		return ret_val;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

} /* End-of File! */
