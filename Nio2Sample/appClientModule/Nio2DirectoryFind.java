import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Nio2DirectoryFind 
{
	public static class Nio2DirectoryFinder extends SimpleFileVisitor<Path>
	{
		private final PathMatcher matcher;
		private int numMatches = 0;
		
		public Nio2DirectoryFinder(String pattern) {
			// TODO Auto-generated constructor stub
			matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
		}
		
		// Compare the glob pattern against the file or directory name.
		public void nio2find(Path file) {
			Path name = file.getFileName();
			
			if( name != null && matcher.matches(name) ) {
				numMatches++;
				System.out.println(file);
			}
		}
		
		// Prints the total number of matches to standard out.
		public void nio2done() {
			System.out.println("Matched: " + numMatches);
		}

		

		// Invoke the pattern matching method on each file.
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			// TODO Auto-generated method stub
			nio2find(file);
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			// TODO Auto-generated method stub
			System.out.println(exc);
			return FileVisitResult.CONTINUE;
		}
		
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			// TODO Auto-generated method stub
			nio2find(dir);
			return FileVisitResult.CONTINUE;
		}	
	}
	
	public static void usage() {
		System.err.println("java Nio2DirectoryFind <path>" + " -name \"<glob_pattern>\"");
		System.exit(-1);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if( args.length < 3 || !args[1].equals("-name") ) {
			usage();
		}
		
		Path startingDir = Paths.get(args[0]);
		String pattern = args[2];
		
		Nio2DirectoryFinder finder = new Nio2DirectoryFinder(pattern);
		Files.walkFileTree(startingDir, finder);
		finder.nio2done();
	}

}
