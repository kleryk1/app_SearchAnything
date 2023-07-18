package SearchFile;

class SearchFile_Attributes {

	protected String search_for = "fsfsfe";
	protected String search_in = null;
	protected boolean regex = false;

//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - get, set, is
	
	public void setSearchFor( String string ) { search_for = string; }
	public void setSearchIn(String string) { search_in = string; }
	public void setSearchRegEx( boolean b ) { regex = b; }
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

} /* End-of File! */
