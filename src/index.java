
import SearchFile.SearchFile;

public class index {

	public static void main( String[] args ) {
		
		String dir = "D:\\Downloads";
		
		SearchFile sf = new SearchFile( "Kane", dir, false );
		
		sf.setSearchFor( "Kane" );
		sf.setSearchIn( dir );
		sf.setSearchRegEx( false );
		
		String[] res = sf.getSearchResults();
		
		for( String f : res ) { System.out.println( f ); }
		
	}
	
}
