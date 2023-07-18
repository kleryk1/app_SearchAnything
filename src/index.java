import Utils.Utils_Directory;

public class index {

	public static void main(String[] args) {
		
		
		String dir = "D:\\Downloads";
		
		String[] dirs = Utils_Directory.getDirList( dir );
		
		for( String d : dirs ) {
			System.out.println( d );
		}
		
	}
	
}
