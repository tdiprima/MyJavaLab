/*
 * File Maker -- Start
 */
package com.tdiprima.lcme;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author tammydiprima
 */
public class Main {

//    private static String dir = System.getProperty("user.home") + "/Downloads/LCME/";
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        // Find files in directory
//        FileList myList = new FileList();
//        String[] files = myList.get(dir + "All/");
//
//        //String[] groups = { "ED", "ER", "FA", "IS", "MS" };
//        String[] groups = {"ER"};
//        SortFiles mySort = new SortFiles();
//
//        for (int i = 0; i < groups.length; i++) {
//            // Sort files in list
//            ArrayList myArray = new ArrayList(mySort.get(files, groups[i]));
//
//            // Print Excel
//            print(myArray, groups[i]);
//
//        }
//    }
//
//    public static void print(ArrayList myArray, String group) {
//
//        // Get content, print content
//        PrintFile out = null;
//        StringBuffer line = new StringBuffer();
//
//        try {
//            out = new PrintFile(dir + group + "-Color-Snapshot.txt");
//            out.println("\t1ary Group\t2ary Group\t3ary Group");
//            out.println("Data or Question");
//
//            ReadDoc myRead = new ReadDoc();
//            String filesname = dir + "All/";
//
//            for (int j = 0; j < myArray.size(); j++) {
//                // get file content
//                String output = myRead.getOnlyWhatINeed(filesname
//                        + myArray.get(j), group);
//                System.out.println(output);
//                line.append(output);
//            }
//        } catch (IOException e) {
//            // catch block
//            e.printStackTrace();
//        }
//
//        out.println(line.toString());
//        line.delete(0, line.length());
//        out.close();
//
//    }

}
