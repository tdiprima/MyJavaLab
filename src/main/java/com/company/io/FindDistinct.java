package com.company.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FindDistinct {

    static FileReader fileReader;
    static BufferedReader bufferedReader;

    public static void main(String[] args) {
        // The name of the file to open.
        String fileName = System.getProperty("user.home") + "/job213/manifest.list";
//        findDupe(fileName);
        process(fileName, "");

    }

    /**
     * Find the duplicated line in a large file Java
     *
     * @param file
     */
    public static void findDupe(String file) {

        try {
            BufferedReader list = new BufferedReader(new FileReader(file));
            String line;

            boolean hasDuplicate = false;
            Set<String> lines = new HashSet<String>();
            while ((line = list.readLine()) != null)// && !hasDuplicate )
            {
                line = line.trim();

                // Ignore blank lines
                if (line.length() > 0) {
                    if (lines.contains(line)) {
                        hasDuplicate = true;
                        System.out.println(line);
                    }
                    lines.add(line);

                }
            }

            if (hasDuplicate) {
                System.out.print("NOT UNIQUE");
            } else {
                System.out.print("UNIQUE");
            }
            list.close();
        } catch (IOException e) {
        }
    }

    public static void process(String fileName, String search) {

        String line;
        int count = 0;

        try {
            fileReader = new java.io.FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            if (search.isEmpty()) {

                Set<String> stringSet = new HashSet<String>();

                // We do a distinct on the entire file
                System.out.println("Scanning file...");

                while ((line = bufferedReader.readLine()) != null) {
                    line = line.trim();
                    // Ignore blank lines
                    if (line.length() > 0) {
                        stringSet.add(line);
                        count++;
                    }

                }
                System.out.println("*** Total " + count + " lines ***\n");
                printResults(stringSet, "Distinct");

            } else {
                // We have a search string
                Set<String> stringSet = new HashSet<String>();
                System.out.println("Scanning for " + search + "...");
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.contains(search) || line.contains("<link")) {
                        stringSet.add(line.trim());
                    }
                    count++;
                }
                System.out.println("*** " + count + " lines ***\n");
                printResults(stringSet, "Distinct");

            }

            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * @param inputStr
     * @return
     */
    private static String findJsFun(String inputStr) {
        int pos = 0;
        String ret = "";

        String find = "= function";
        if (inputStr.contains(find)) {
            // FIND something.prototype.whatever = function()
            if (inputStr.contains(".prototype.")) {
                find = ".prototype.";
                pos = inputStr.indexOf(find) + find.length();
                ret = inputStr.substring(pos);

                // FIND NEXT
                find = "= function";
                if (ret.contains(find)) {
                    pos = ret.indexOf(find);
                    ret = ret.substring(0, pos);

                }

            } else if (inputStr.contains(".on")) {
                // IGNORE
                //this.rectbutton.on('click', function () {
                //pos = inputStr.indexOf(find);
                //ret = inputStr.substring(0, pos);

            } else {
                //var cancelAnnotation = function () {
                pos = inputStr.indexOf(find);
                ret = inputStr.substring(0, pos);
                ret = ret.replace("var ", "");
            }

        } else {
            // FIND whatever: function
            find = ": function";
            if (inputStr.contains(find)) {
                pos = inputStr.indexOf(find);
                ret = inputStr.substring(0, pos);

                if (ret.contains("on")) {
                    ret = "";
                } else {
                    if (ret.contains("\"")) {
                        ret = ret.replaceAll("\"", "");
                    }

                    if (ret.contains("'")) {
                        ret = ret.replaceAll("'", "");
                    }

                }

            } else {
                // jQuery, addEvent, addButton, bind, etc.
                //ret = inputStr.trim();
            }
        }

        ret = ret.trim();
        return ret;

    }

    /**
     * Distinct or Repeated
     *
     * @param stringSet
     * @param str
     */
    public static void printResults(Set<String> stringSet, String str) {
        Iterator it = stringSet.iterator();
        int count = 0;
        while (it.hasNext()) {
            count++;
            System.out.println(it.next());
        }
        System.out.println("*** " + str + ": " + count + " lines ***");
    }

}
