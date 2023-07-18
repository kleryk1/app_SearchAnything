
import java.io.IOException;

import IF_Arg.PjArguments;
import IF_Gui.PjFrame;

public class index extends PjFrame{

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	Constructors																				//
	
	public index() {
		super();
		
		
		
		
		setVisible( true );
	}
	
	public static void main( String[] args ) {
		
		String dir = "D:\\Downloads";
		
		//args = new String[] { "-gui" };
		//args = new String[] { "-gui", "-fs", "> out_file.txt", "-a_rx true", "-a_sf Command", "-a_si "+dir, "-a_rx false", "-a_id true", "-a_cs true" };
		args = new String[] { "-gui", "-fs", "-a_rx true", "-a_sf Command", "-a_si "+dir, "-a_rx false", "-a_id true", "-a_cs true" };
//		args = new String[] { "-gui", "-fs", "> out_file.txt", "-a_rx true", "-a_sf Command", "-a_si "+dir, "-a_rx false", "-a_id false", "-a_cs false" };
		
		PjArguments arguments;
		try { arguments = new PjArguments( args );
			if( arguments.isStartGui() ) {
				
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
