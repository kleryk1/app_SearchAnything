package IF_Gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import IF_Gui.TABS.TAB_Interface;

public class PjFrame extends JFrame {

	/** Content panel replacement */
	protected JTabbedPane main_panel = new JTabbedPane();
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	Constructors																				//
	
	public PjFrame( String app_name ) {
		super();
	
		setLocation( 100, 100 );
		setSize( 850, 200 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setTitle( app_name );
		
		main_panel.setBackground( new Color( 0, 0, 0, 0 ) );
		setContentPane( main_panel );
		
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	add components																				//

	protected Component addTab( String name, Icon icon, TAB_Interface comp, String comment) {
		main_panel.addTab( name, icon, (PjPanel)comp, comment );
		return this;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

} /* End-of File! */
