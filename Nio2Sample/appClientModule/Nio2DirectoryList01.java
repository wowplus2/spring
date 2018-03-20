import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Nio2DirectoryList01 
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = Paths.get("C:/Java/jdk1.8.0_151/sample/nio/file");
		
		System.out.println(path.getParent() + "\\" + path.getFileName() + " 폴더내용 리스트");
		System.out.println("=====================================");
		
		DirectoryStream<Path> dir = null;
		try {
			//dir = Files.newDirectoryStream(path);
			dir = Files.newDirectoryStream(path, "*.{java, exe}");
			for( Path file : dir ) {
				System.out.println(file.getFileName());
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( dir != null ) {
					dir.close();
				}
			} catch( IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("=====================================");		
	}

}
