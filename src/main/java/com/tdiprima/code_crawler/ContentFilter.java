package com.tdiprima.code_crawler;

import com.tdiprima.code_commenter.Program;

import java.io.*;
import java.util.ArrayList;

import static com.tdiprima.code_crawler.RewriteCodeConsoleOut.findFiles;

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

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWithPath));
        // StringBuffer sb = new StringBuffer();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains("<script") || line.contains("<link")) {
                // sb.append(line);
                System.out.println(line.trim());
            }
        }

        bufferedReader.close();
        // return sb.toString();
        return "";
    }

    public static void writeIt(String contents, String fileOUT) throws Exception {

        Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileOUT), "utf-8"));

        writer.write(contents);

        writer.close();
    }
}
