package com.tdiprima.code_crawler;

import java.io.*;

/**
 * Reads files, searches for specific patterns, and filters lines based on predefined rules.
 * It is useful for extracting function definitions, tracking certain keywords, or debugging 
 * code changes in JavaScript and C++ projects.
 * 
 * @author tdiprima, 3/30/17
 */
public class CodeCrawler {

    static FileReader fileReader;
    static BufferedReader bufferedReader;

    public static void main(String[] args) {

        String homeDirectory = System.getProperty("user.home");
        //String fileName = homeDirectory + "/github/Quip/caMicroscope/js/annotationtoolslymph/osdAnnotationTools_Lymph.js";
        String fileName = homeDirectory + "/github/Quip/caMicroscope/js/annotationtools/osdAnnotationTools copy.js";
        //String fileName = homeDirectory + "/github/Quip/caMicroscope/js/annotationtools_sc/osdAnnotationTools_sc.js";
        simpleProcess(fileName);

        //String[] arr = {"nucleidata", "convertlabeltocvmat"};
        //read(fileName, arr);
        //read(fileName, "wipesegmentation", true);
        //findGoodWords(fileName);
    }

    /**
     * @param fileName
     */
    public static void simpleProcess(String fileName) {
        String line;

        try {
            fileReader = new FileReader(fileName);

            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String tmp = line.trim();
                //String tmp = line.substring(line.indexOf(" ")).trim();
                int pos = tmp.indexOf("annotools.prototype");
                if (pos != -1) {
                    System.out.println(tmp.substring(pos));
                }

            }

            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param fileName
     * @param arr
     */
    public static void read(String fileName, String[] arr) {
        String line;

        try {
            FileReader fileReader = new FileReader(fileName);

            bufferedReader = new BufferedReader(fileReader);
            String tmpLine;
            int count = 0;

            while ((line = bufferedReader.readLine()) != null) {
                count++;

                //tmpLine = line.trim().toLowerCase();
                tmpLine = line.trim();

                for (int i = 0; i < arr.length; i++) {
                    if (tmpLine.contains(arr[i])) {
                        System.out.println(line.trim());
                        //System.out.println("ln " + count + ": " + line.trim());
                        break;
                    }
                }

            }

            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Abstract, can use for anything.
     */
    public static void read(String fileName, String search, boolean print) {

        String line;

        try {
            fileReader = new FileReader(fileName);

            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                String tmpLine = line.trim().toLowerCase();
                //String tmpLine = line.trim();

                if (tmpLine.contains(search) && print) {
                    // Print it if you find it.
                    // System.out.println(line.substring(line.indexOf(search)));
                    System.out.println(line);
                } else {
                    // Did we find it?
                    if (tmpLine.contains(search)) {
                        // Are we printing it?
                        if (print) {
                            System.out.println(line);
                        }

                    } else {
                        // Line does not contain search term.
                        // !print = Print it if you don't find it.
                        if (!print) {
                            System.out.println(line);
                        }

                    }

                }

            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
        }
    }

    /**
     * Specialized for C++ TODO: REMEMBER - LOWERCASE
     */
    public static void findGoodWords(String fileName) {

        // C++ Header Source
        //String[] goodWords = {"ifndef", "define", "endif", "include", "namespace", "template", "bwareaopen2", "imhmin", "watershed2", "continue"};
        // C++ Source Code.
        //String[] goodWords = {"include", "namespace", "bwareaopen2", "imhmin", "watershed2", "//"};
        String[] goodWords = {"imreconstruct(", "bwlabel2(", "bwareaopen2(", "imhmin(", "watershed2(", "localminima(", "localmaxima(", "propagate("};

        String[] badWords = {"gpu", "logger", "omp"};

        try {
            FileReader fileReader = new FileReader(fileName);

            bufferedReader = new BufferedReader(fileReader);

            String line;
            boolean keepGoing;
            while ((line = bufferedReader.readLine()) != null) {
                String tmpLine = line.trim().toLowerCase();
                keepGoing = true;

                for (int i = 0; i < badWords.length; i++) {
                    if (tmpLine.contains(badWords[i])) {
                        keepGoing = false;
                        break;
                    }
                }

                if (keepGoing) {
                    for (int i = 0; i < goodWords.length; i++) {
                        if (tmpLine.contains(goodWords[i])) {
                            System.out.println(line);
                        }
                    }
                }

            }

            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Reads a file line by line and searches for a specific term based on the
     * specified operation. Depending on the operation and the print flag, it
     * either prints lines that match the criteria or skips lines that do not
     * match.
     *
     * @param fileName The name (or path) of the file to be read.
     * @param search The search term to look for in each line of the file.
     * @param operation The operation to perform when searching: 
     * - "startsWith": Check if the line starts with the search term. 
     * - "endsWith": Check if the line ends with the search term. 
     * - "contains": Check if the line contains the search term (default).
     * @param print If true, prints lines that match the search criteria. If
     * false, skips lines that match the search criteria and prints others.
     *
     * Behavior: 
     * - Lines are compared case-insensitively. 
     * - If an operation is not explicitly matched, it defaults to printing the 
     * line if it contains the search term. 
     * - Handles file reading errors gracefully and prints relevant error messages.
     *
     * Example: Given a file with lines: "Hello World" "Java Programming" "hello java"
     *
     * Calling read("file.txt", "hello", "startsWith", true) will print: "Hello World" "hello java"
     *
     * Calling read("file.txt", "java", "endsWith", false) will print: "Hello World"
     *
     * Error Handling: 
     * - If the file is not found, prints an error message and exits gracefully. 
     * - If there is an error reading the file, prints an error message and exits gracefully.
     */
    public static void read(String fileName, String search, String operation, boolean print) {
        String line;

        try {
            // Initialize FileReader and BufferedReader
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String tmpLine = line.trim().toLowerCase();

                // Check if the line contains the search term
                if (tmpLine.contains(search.toLowerCase())) {
                    if (print) {
                        // TODO: Print based on operation type
                        if (operation.equalsIgnoreCase("startsWith") && tmpLine.startsWith(search.toLowerCase())) {
                            System.out.println(line);
                        } else if (operation.equalsIgnoreCase("endsWith") && tmpLine.endsWith(search.toLowerCase())) {
                            System.out.println(line);
                        } else if (operation.equalsIgnoreCase("contains")) {
                            System.out.println(line);
                        } else {
                            // If no specific operation, just print
                            // System.out.println(line);
                        }
                    } else {
                        // TODO: When 'print' is false, skip the lines containing the search term
                        if (!operation.equalsIgnoreCase("startsWith") && !tmpLine.startsWith(search.toLowerCase())) {
                            System.out.println(line);
                        } else if (!operation.equalsIgnoreCase("endsWith") && !tmpLine.endsWith(search.toLowerCase())) {
                            System.out.println(line);
                        }
                    }
                } else {
                    // Line does not contain the search term
                    // System.out.println(line);
                }
            }

            // Close the reader
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }
}
