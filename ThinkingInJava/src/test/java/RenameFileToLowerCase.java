import guerer.example.util.Print;
import guerer.example.util.ProcessFiles;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class RenameFileToLowerCase {

	private static String[] files = new String[] { 
		"Root Path", 
		};

	public static void main(String[] args) {
		final List<String> correctfiles = Arrays.asList(new String[] {
				"file1.html",
				"file2.html",
		});
		new ProcessFiles(new ProcessFiles.Strategy() {
			public void process(File file) {
				String fileName = file.getName().toLowerCase();
				fileName = fileName.replaceFirst("^gbs_", "GBS_");
				file.renameTo(new File(file.getParent() + "\\"
						+ fileName));
//				Print.print(new File(file.getParent() + "\\"
//						+ fileName));
				if(!correctfiles.contains(fileName)) {
					Print.print(fileName);
				}
			}
		}, "\\w*").start(files);
	}
}
