package Utils;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

import IF_Gui.PjPanel;

public class Utils_Components {

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    -	Constructors																				//

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - get, set, is
	
	public static PjPanel getInputField( int x, int y, String label_text, Component comp ) {
		PjPanel ret_val = new PjPanel();
		ret_val.setLocation( x, y );
		ret_val.setSize( 100, 20 );
		
		JLabel label = new JLabel( label_text );
		label.setLocation( 0, 0 );
		ret_val.add( label );
		
		comp.setLocation( 100, 0 );
		ret_val.add( comp );
		
		
		return ret_val;
	}

	
	
	public static PjPanel getFileChooser( int x, int y, int frame_width, String label_text, JTextField comp, JButton choose ) {
		PjPanel ret_val = new PjPanel();
		ret_val.setLocation( x, y );
		ret_val.setSize( 100, 26 );
		
		JLabel label = new JLabel( label_text );
		label.setLocation( 0, 2 );
		ret_val.add( label );
		
		comp.setLocation( 100, 2 );
		ret_val.add( comp );

		choose.setLocation( frame_width-80, 0 );
		choose.addActionListener( new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
			    JFileChooser chooser = new JFileChooser();
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    int returnVal = chooser.showOpenDialog( null );
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	comp.setText( chooser.getSelectedFile().getAbsolutePath() );
			    }
			}
		} );
		ret_val.add( choose );
		
		return ret_val;
	}



	public static Component getCheckBox( int x, int y, JCheckBox comp ) {
		comp.setLocation( x, y ); 
		return comp;
	}

	public static PjPanel getTextSearch(int x, int y, JCheckBox checkbox, JTextField comp ) {
		PjPanel ret_val = new PjPanel();
		ret_val.setLocation( x, y );
		ret_val.setSize( 100, 26 );
		
		checkbox.setLocation( 0, 0 );
		ret_val.add( checkbox );
		
		comp.setLocation( 100, 0 );
		comp.setEditable( false );
		ret_val.add( comp );
		
		return ret_val;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

} /* End-of File! */
