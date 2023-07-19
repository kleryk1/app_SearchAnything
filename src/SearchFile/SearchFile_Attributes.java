package SearchFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

class SearchFile_Attributes {

	protected String search_for = null;
	protected String search_in = null;
	protected boolean regex = false;
	protected boolean include_dirs = true;
	protected boolean case_sensitive = false;

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - get, set, is
	
	public void setSearchFor( String string ) { search_for = string; }
	public void setSearchIn(String string) { search_in = string; }
	public void setSearchRegEx( boolean b ) { regex = b; }
	public void setSearchIncludeDirs( boolean b ) { include_dirs = b; }
	public void setSearchCaseSensitive( boolean b ) { case_sensitive = b;}
	
	public boolean isRegex() { return regex; }
	public boolean isSetIncludeDirs() { return include_dirs; }
	public boolean isSetCaseSensitive() { return case_sensitive; }
	
	public ActionListener actSetRegex( JCheckBox checkbox ) {
		ActionListener ret_val = new ActionListener() {
			@Override public void actionPerformed( ActionEvent evt ) {
				regex = checkbox.isSelected();
			}
		};
		return ret_val;
	}
	
	public ActionListener actSetIncludeDirs( JCheckBox checkbox ) {
		ActionListener ret_val = new ActionListener() {
			@Override public void actionPerformed( ActionEvent evt ) {
				include_dirs = checkbox.isSelected();
			}
		};
		return ret_val;
	}

	public ActionListener actSetCaseSensitive( JCheckBox checkbox ) {
		ActionListener ret_val = new ActionListener() {
			@Override public void actionPerformed( ActionEvent evt ) {
				case_sensitive = checkbox.isSelected();
			}
		};
		return ret_val;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

} /* End-of File! */
