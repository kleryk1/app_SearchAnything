
import java.io.IOException;

import IF_Arg.PjArguments;
import IF_Gui.PjFrame;
import IF_Gui.TABS.TAB_GenerateCMD;
import IF_Gui.TABS.TAB_Search;
import SearchText.SearchText;

public class index extends PjFrame{

	private static TAB_Search search = null;
	private static TAB_GenerateCMD generate = null;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	Constructors																				//
	
	public index() {
		super( "Search anything!" );
		
		search = new TAB_Search( getSize().width );
		generate = new TAB_GenerateCMD( getSize().width );
		
		addTab( search.getName(), search.getIcon(), search, search.getComment() );
		addTab( generate.getName(), generate.getIcon(), generate, generate.getComment() );
		
		setContentPane( main_panel );
		setVisible( true );
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - M A I N
	
	public static void main( String[] args ) {
		
		
		String dir = "X:\\SandBoxes\\Defiant_SandBox\\JavaLibrariesGit\\app_SearchAnything";
		
		SearchText st = new SearchText();
		
		st.setSearchFor( "Command" );
		st.setSearchIn( dir );
		
		st.setSearchWholeWordsOnly( false );
		st.setSearchCaseSensitive( false );
		st.setSearchRegEx( false );
		st.setSearchHex( false );
		st.setSearchNotContainingText( false );
		
		st.getSearchResults();
		
		String[] res = st.getLastResult();
		for( String f : res ) { System.out.println( f ); }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		args = new String[] { "-gui" };
		//args = new String[] { "-gui", "-fs", "> out_file.txt", "-a_rx true", "-a_sf Command", "-a_si "+dir, "-a_rx false", "-a_id true", "-a_cs true" };
		//args = new String[] { "-gui", "-fs", "-a_rx true", "-a_sf Command", "-a_si "+dir, "-a_rx false", "-a_id true", "-a_cs true" };
		//args = new String[] { "-gui", "-fs", "> out_file.txt", "-a_rx true", "-a_sf Command", "-a_si "+dir, "-a_rx false", "-a_id false", "-a_cs false" };
		
		/* Argument handling */
		PjArguments arguments;
		try { arguments = new PjArguments( args );
			if( arguments.isStartGui() ) {
				
				/* start GUI */
				new index();
				
			}
		} catch ( IOException ex ) { ex.printStackTrace(); }
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 */
	private static final long serialVersionUID = -2421075421460468515L;
	
} /* End-of File! */
