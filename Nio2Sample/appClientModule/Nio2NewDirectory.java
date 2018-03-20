import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class Nio2NewDirectory 
{
	public static void main(String[] args) {
		Path newDir = FileSystems.getDefault().getPath("C:/Java/eclipse-workspace/Nio2Sample/assets");
		
		createNewDirectory4Win(newDir);
	}
	
	public static void createNewDirectory4Win(Path newDir) {
		try {
			// 디렉토리 생성
			Files.createDirectory(newDir);
		} catch( IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createNewDirectory4Linux(Path newDir) {
		// 디렉토리 권한 설정
		Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-x---");
		// 파일 속성
		FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
		
		try {
			// 디렉토리 생성
			Files.createDirectory(newDir, attr);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteDirectory(Path delDir) {
		try {
			// 디렉토리 삭제
			Files.delete(delDir);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
