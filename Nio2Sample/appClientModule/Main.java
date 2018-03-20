import java.io.File;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File[] roots = File.listRoots();
		
		for( File root : roots) {
			System.out.println(root);
		}
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}