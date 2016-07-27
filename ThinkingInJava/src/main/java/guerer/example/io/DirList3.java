package guerer.example.io;

import guerer.example.util.Print;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3 {

	public static void main(final String[] args) {
		File file = new File(".");
		String fileNames[];
		if (args.length == 0) {
			fileNames = file.list();
		} else {
			fileNames = file.list(new FilenameFilter() {
				private Pattern pattern = Pattern.compile(args[0]);

				public boolean accept(File file, String arg1) {
					return pattern.matcher(arg1).matches();
				}
			});
		}
		Arrays.sort(fileNames, String.CASE_INSENSITIVE_ORDER);
		for (String fileName : fileNames) {
			Print.print(fileName);
		}
	}

}
