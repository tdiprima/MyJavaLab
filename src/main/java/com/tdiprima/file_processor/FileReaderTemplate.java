package com.tdiprima.file_processor;

import java.io.*;
import java.util.*;

/**
 * Reads a file and looks for specific content
 *
 * @author tdiprima
 */
public class FileReaderTemplate {

    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<String>();
        try {
            FileReader fileReader = new FileReader(System.getProperty("user.home") + "/Downloads/ZOOM.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (line.contains("world.js")) {
                    System.out.println(line);
                }
//                stringSet.add(line);
            }

//            Iterator it = stringSet.iterator();
//            while (it.hasNext()) {
//                System.out.println(it.next());
//            }
            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }
}
