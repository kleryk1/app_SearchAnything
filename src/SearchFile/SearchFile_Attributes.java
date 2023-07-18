package SearchFile;

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
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

} /* End-of File! */
