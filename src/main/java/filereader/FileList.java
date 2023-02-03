/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filereader;

import java.io.File;

/**
 *
 * @author tammydiprima
 */
public class FileList {
	public FileList() {
		// constructor
	}

	public String[] get(String directory) {
		File dir = new File(directory);
		String[] children = dir.list();

		return children;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FileList myList = new FileList();
		String[] files = myList.get("/Users/tammydiprima/Downloads/LCME/All");
		for (int i = 0; i < files.length; i++) {
			// Get filename of file or directory
			String filename = files[i];
			System.out.println(filename);

		}

	}

}
