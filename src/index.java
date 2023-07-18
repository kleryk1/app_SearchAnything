
import SearchFile.SearchFile;

public class index {

	public static void main( String[] args ) {
		
		String dir = "D:\\Downloads";
		
		SearchFile sf = new SearchFile();
		
		sf.setSearchFor( "Command" );
		sf.setSearchIn( dir );
		sf.setSearchRegEx( false );
		sf.setSearchIncludeDirs( true );
		sf.setSearchCaseSensitive( true );
		
		sf.getSearchResults();
		
		String[] res = sf.getLastResult();
		
		for( String f : res ) { System.out.println( f ); }
		
	}
	
}
