package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TreeOutput {
	public static void main(String[] args) {
		File input = new File("C:\\Dokumenty");
		try {
			printTree(0, input);
		} catch (IOException e) {
			System.out.println("No such a directory:" + input);
			e.printStackTrace();
		}
	}

	static void printTree(int level, File file) throws IOException {
		for (int i = 0; i < level; i++)
			System.out.print(" ");
		System.out.println(file.getName());

		if (file.isDirectory()) {
			File[] files = file.listFiles();
			File[] sortedFiles = fileSorter(files);
			for (int i = 0; i < sortedFiles.length; i++)
				printTree(level + 5, sortedFiles[i]);
		}
	}

	static File[] fileSorter(File[] filesArray) {
		List<File> fileList = new ArrayList<File>();

		for (File item : filesArray) {
			if (item.isFile()) {
				fileList.add(item);
			}
		}

		for (File item : filesArray) {
			if (item.isDirectory()) {
				fileList.add(item);
			}
		}

		return fileList.toArray(new File[] {});
	}
}