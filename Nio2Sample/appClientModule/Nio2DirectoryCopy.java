import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Nio2DirectoryCopy 
{
	public static void print(Path path) {
		DirectoryStream<Path> dir = null;
		try {
			dir = Files.newDirectoryStream(path);
			for( Path file : dir ) {
				System.out.println(file.getFileName());
			}
			System.out.println();
		} catch( IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( dir != null ) {
					dir.close();
				}
			} catch( IOException e ) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path copyFrom = Paths.get("C:/Java/jdk1.8.0_151/sample/nio/file", "WatchDir.java");
		Path copyTo = Paths.get("C:/Java/jdk1.8.0_151/sample/nio/file/", "WatchDir_copy.java");
		
		Path parentPath = copyFrom.getParent();
		try {
			System.out.println("복사 전...");
			print(parentPath);
			Files.copy(copyFrom, copyTo, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println("복사 후...");
			print(parentPath);
			
			Files.delete(copyFrom);
			System.out.println("삭제 후...");
			print(parentPath);
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}

}
