package guerer.example.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class Directory {

	public static File[] local(File dir, final String regex) {
		return dir.listFiles(new FilenameFilter() {
			Pattern pattern = Pattern.compile(regex);

			public boolean accept(File dir, String name) {
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}

	public static File[] local(String dirPath, String regex) {
		return local(new File(dirPath), regex);
	}

	public static class TreeInfo implements Iterable<File> {
		public List<File> files = new ArrayList<File>();
		public List<File> dirs = new ArrayList<File>();

		public Iterator<File> iterator() {
			return files.iterator();
		}

		public void addAll(TreeInfo infos) {
			files.addAll(infos.files);
			dirs.addAll(infos.dirs);
		}

		@Override
		public String toString() {
			return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: "
					+ PPrint.pformat(files);
		}
	}

	public static TreeInfo walk(String start, String regex) { // Begin recursion
		return recurseDirs(new File(start), regex);
	}

	public static TreeInfo walk(File start, String regex) { // Overloaded
		return recurseDirs(start, regex);
	}

	public static TreeInfo walk(File start) { // Everything
		return recurseDirs(start, ".*");
	}

	public static TreeInfo walk(String start) {
		return recurseDirs(new File(start), ".*");
	}

	static TreeInfo recurseDirs(File startDir, final String regex) {
		TreeInfo result = new TreeInfo();

		for (File file : startDir.listFiles()) {
			if (file.isDirectory()) {
				result.dirs.add(file);
				result.addAll(recurseDirs(file, regex));
			} else {
				if (file.getName().matches(regex)) {
					result.files.add(file);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println(walk("."));
		} else {
			for (String arg : args) {
				System.out.println(walk(arg));
			}
		}
	}

}
