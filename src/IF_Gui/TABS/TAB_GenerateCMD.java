package IF_Gui.TABS;

import java.awt.Color;

import javax.swing.Icon;

import IF_Gui.PjPanel;

public class TAB_GenerateCMD extends PjPanel implements TAB_Interface {

	private static final String name = "Generate Command";
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	Constructors																				//
	
	public TAB_GenerateCMD( int parrent_width ) {
		super( name );
		setBackground( Color.blue );
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - get, set, is
	
	public Icon getIcon() {
		// ToDo implement Icon
		return null;
	}
	
	public String getComment() { return "Generate command line string!"; }

//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4335543772830167442L;

} /* End-of File! */
