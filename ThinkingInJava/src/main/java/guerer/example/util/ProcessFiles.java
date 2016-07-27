package guerer.example.util;

import java.io.File;
import java.io.IOException;

public class ProcessFiles {

	public interface Strategy {
		void process(File file);
	}

	private Strategy strategy;
	private String ext;

	public ProcessFiles(Strategy strategy, String ext) {
		this.strategy = strategy;
		this.ext = ext;
	}

	public void start(String[] args) {
		try {
			if (args.length == 0) {
				processDirectoryTree(new File("."));
			} else {
				for (String file : args) {
					File root = new File(file);
					if (root.isDirectory()) {
						processDirectoryTree(root);
					} else {
						if (!file.endsWith("." + ext)) {
							file += "." + ext;
						}
						strategy.process(new File(file).getCanonicalFile());
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void processDirectoryTree(File root) throws IOException {
		for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
			strategy.process(file.getCanonicalFile());
		}
	}

	public static void main(String[] args) {
		new ProcessFiles(new ProcessFiles.Strategy() {
			public void process(File file) {
				Print.print(file);
			}
		}, "java").start(args);
	}

}
