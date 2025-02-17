package com.tdiprima.code_crawler;


import java.io.*;
import java.util.ArrayList;

import static com.tdiprima.code_crawler.RewriteCodeConsoleOut.findFiles;

/**
 * Scans files in a specified directory, searches for lines containing "script" or "link"
 * tags, prints them to the console, and provides methods to read and write file contents.
 * 
 * @author tdiprima
 */
public class ContentFilter {

    public static void main(String[] args) {
        try {
            // String contents = readIt("");
            // writeIt(contents, "Han.csv");
            String home = System.getProperty("user.home");
            processFiles(home + "/workspace/filtering");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void processFiles(String topLevelDir) {
        try {
            ArrayList<String> filesWithPath = findFiles(topLevelDir);

            for (int i = 0; i < filesWithPath.size(); i++) {
                readIt(filesWithPath.get(i));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static String readIt(String fileWithPath) throws Exception {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWithPath))
        ) {
            // StringBuffer sb = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("<script") || line.contains("<link")) {
                    // sb.append(line);
                    System.out.println(line.trim());
                }
            }
        }
        // return sb.toString();
        return "";
    }

    public static void writeIt(String contents, String fileOUT) throws Exception {

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOUT), "utf-8"))) {
            writer.write(contents);
        }
    }
}
