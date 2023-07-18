package SearchText;

class SearchText_Attributes {

	protected String search_for = null;
	protected String search_in = null;
	protected boolean whole_words_only = true;
	protected boolean case_sensitive = false;
	protected boolean regex = false;
	protected boolean hex = false;
	protected boolean not_containing_text = false;

	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//    - get, set, is

	public void setSearchFor( String string ) { search_for = string; }
	public void setSearchIn( String string ) { search_in = string; }
	
	public void setSearchWholeWordsOnly( boolean b ){ whole_words_only = b; }
	public void setSearchCaseSensitive( boolean b ){ case_sensitive = b; }
	public void setSearchRegEx( boolean b ){ regex = b; }
	public void setSearchHex( boolean b ) { hex = b; };
	public void setSearchNotContainingText( boolean b ) { not_containing_text = b; }
	
	public void setSearchEncoding( String encode ) { 
		// ToDo - implement search by encoding (ANSI, ASCII, UTB-8, UTF-16)
	}
	public void setSearchNotContainingText( String extention ) {
		// ToDo - implement special algorithms to different file types (*.docx, *.xlsx, . . .)
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////

} /* End-of File! */
