package IF_Gui.TABS;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import IF_Gui.PjPanel;
import SearchFile.SearchFile;
import SearchText.SearchText;
import Utils.Utils_Components;

public class TAB_Search extends PjPanel implements TAB_Interface{
	
	private static final String name = "Search";
	
	private ArrayList<PjPanel> panel_resize_list = new ArrayList<PjPanel>();
	
	private JTextField search_for = new JTextField();
	private JTextField search_in = new JTextField();
	private JButton choose = new JButton( ">>" );
	
	private JCheckBox regex = new JCheckBox( "RegEx" );
	private JCheckBox include_dirs = new JCheckBox( "Include dirs" );
	private JCheckBox case_sensitive = new JCheckBox( "Case sensitive" );
	
	private JCheckBox enable_text_search = new JCheckBox( "Find text: " );
	private JTextField text_search_for = new JTextField();
	
	private SearchFile fs = new SearchFile();
	private SearchText ts = new SearchText();
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	Constructors																				//
	
	public TAB_Search( int frame_width ) {
		super( name );
		int x = 5, y = 5;
		
		/* add search for input field */
		panel_resize_list.add( Utils_Components.getInputField( x, y, "Search for:", search_for ) );                  		x+=0; y+=23;
		
		/* add file search for input field */
		panel_resize_list.add( Utils_Components.getFileChooser( x, y, frame_width, "Search in:", search_in, choose ) );		x+=100; y+=23;

		add( Utils_Components.getCheckBox( x, y, regex, fs.actSetRegex( regex ), fs.isRegex() ) );										x+=60; y+=0;
		add( Utils_Components.getCheckBox( x, y, include_dirs, fs.actSetIncludeDirs( include_dirs ), fs.isSetIncludeDirs() ) );			x+=100; y+=0;
		add( Utils_Components.getCheckBox( x, y, case_sensitive, fs.actSetCaseSensitive( case_sensitive ), fs.isSetCaseSensitive() ) );	x=0; y+=20;

		/* FixMe - line is not displayed */
		JSeparator line = new JSeparator( SwingConstants.HORIZONTAL );
		line.setLocation( x, y );                                                                                           x=5; y+=23;
		add( line );
		
		enable_text_search.addActionListener( setTextSearch() );
		
		panel_resize_list.add( Utils_Components.getTextSearch( x, y, enable_text_search, text_search_for ) );
		
		
		
		// ToDo - continue here with adding the checkboxes
//		protected boolean regex = false;
//		protected boolean include_dirs = true;
//		protected boolean case_sensitive = false;
		
		/* update component size in relation to frame width */
		setComponentSize( frame_width );
		
		
		/* add all panels to frame */
		for( PjPanel panel : panel_resize_list ) { add( panel ); }
		
	}
	

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - get, set, is

	public Icon getIcon() {
		// ToDo implement Icon
		return null;
	}

	public String getComment() { return "Search files or text!"; }

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - S T A T I C
	
	private void setComponentSize( int frame_width ) {
		int correction = 130;
		search_for.setPreferredSize( new Dimension( frame_width-correction, 20 ) );
		search_in.setPreferredSize( new Dimension( frame_width-correction-50, 20 ) );
		choose.setLocation( frame_width-50, 0 );
		
		text_search_for.setPreferredSize( new Dimension( frame_width-correction, 20 ) );
		
		/* add all panels to frame */
		for( PjPanel panel : panel_resize_list ) {
			panel.setSize( frame_width, panel.getSize().height );
			//panel.setBackground( Color.red );
		}
		
	}
	
	
	private ActionListener setTextSearch() {
		ActionListener ret_val = new ActionListener() {
			@Override public void actionPerformed( ActionEvent evt ) {
				// ToDo - enable text components
				text_search_for.setEditable( enable_text_search.isSelected() );
				include_dirs.setEnabled( !enable_text_search.isSelected() );
				
				if( enable_text_search.isSelected() ) {
					include_dirs.setEnabled( false );
					fs.setSearchIncludeDirs( false );
				}else{
					fs.setSearchIncludeDirs( include_dirs.isSelected() );
				}

			}
		};
		return ret_val;
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 */
	private static final long serialVersionUID = -6056934750869313449L;

} /* End-of File! */
