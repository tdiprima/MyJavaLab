package com.tdiprima.code_crawler;

import com.tdiprima.code_commenter.Cxx;
import com.tdiprima.code_commenter.Js;
import com.tdiprima.code_commenter.Program;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RewriteCodeConsoleOut {

    /**
     * Main method
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        
        // TODO:
        // A) If Python, is tab 2 or 4?
        // B) Pass correct program-type to processFiles
        // C) If JS, make sure you didn't mess with it.
        String topLevelDir = System.getProperty("user.home") + "/something/";
        boolean warn = false;

        if (warn) {
            String mainDir = topLevelDir.substring(topLevelDir.lastIndexOf("/"));
            System.out.println("ABOUT TO OVERWRITE...");
            System.out.println(topLevelDir);
            System.out.println("BACK UP DIRECTORY FIRST!!!");
            System.out.println("cp -rp \"" + topLevelDir + "\" \"$HOME" + mainDir + "_BAK\"");
            System.exit(1);
        }

        // Process files for JavaScript
        processFiles(topLevelDir, new Js());
        // processFiles(topLevelDir, new Java());
        // processFiles(topLevelDir, new Py());
    }

    /**
     * Process files.
     *
     * @param topLevelDir The directory containing files
     * @param pgm         The program type handler
     */
    public static void processFiles(String topLevelDir, Program pgm) {
        String ext = pgm.getExt();

        try {
            ArrayList<String> filesWithPath = findFiles(topLevelDir);

            for (String fileWithPath : filesWithPath) {
                if (fileWithPath.endsWith(ext)) {
                    System.out.println("file: " + fileWithPath + "\n");
                    // Processing file
                    pgm.doinIt(fileWithPath);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Process C++ specific files.
     */
    public static void doCxx() {
        Cxx myCxx = new Cxx();
        
        String str1 = ") {"; // Ensuring proper formatting
        String str2 = "::";
        String special1 = "//";
        String special2 = "for (";
        String spaces = "    "; // Indentation
        
        String fname = System.getProperty("user.home") + "/github/SlicerPathology/QuickTCGA/Logic/NucleusSeg_Yi/TypeUtils.h";
        myCxx.doinIt(fname, str1, str2, special1, special2, spaces);
    }

    /**
     * Walk through directory tree, find files, add names to list.
     *
     * @param topLevelDir The root directory
     * @return List of file paths
     * @throws Exception If an error occurs during file processing
     */
    public static ArrayList<String> findFiles(String topLevelDir) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();

        Files.walk(Paths.get(topLevelDir)).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                arrayList.add(filePath.toString());
            }
        });
        
        return arrayList;
    }
}
