/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filereader;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author tammydiprima
 */
public class SortFiles {
	public SortFiles() {
	}

	public ArrayList get(String[] files, String section) {
		// create an ArrayList object
		ArrayList arrayList = new ArrayList();

		for (int i = 0; i < files.length; i++) {
			// Get filename of file or directory
			String filename = files[i];
			String data = new String("Data-" + section);
			String question = new String("Question-" + section);

			if (section.equalsIgnoreCase("IS")
					&& filename.contains("Data-Background-Info")) {
				arrayList.add(filename);
			} else if (section.equalsIgnoreCase("ED")
					&& filename.contains("Courses-and-Clerkships")) {
				arrayList.add(filename);
			} else
			if (filename.contains(data) || filename.contains(question)) {
				arrayList.add(filename);
			}

		}

		// To sort an ArrayList object, use Collection.sort method. This is a
		// static method. It sorts an ArrayList object's elements into ascending
		// order.
		Collections.sort(arrayList);

		return arrayList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Find files in directory
		FileList myList = new FileList();
		String[] files = myList.get("/Users/tammydiprima/Downloads/LCME/All");

		// Sort files
		SortFiles mySort = new SortFiles();
		ArrayList myArray = new ArrayList(mySort.get(files, "IS"));
		// display elements of ArrayList
		for (int i = 0; i < myArray.size(); i++)
			System.out.println(myArray.get(i));

	}

}
