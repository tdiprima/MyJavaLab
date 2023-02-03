package com.company.code_crawler;

import java.io.*;

/**
 * Created by tdiprima on 3/30/17.
 */
public class CodeCrawler {

    static FileReader fileReader;
    static BufferedReader bufferedReader;

    public static void main(String[] args) {

        //String fileName = "/Users/tdiprima/github/Quip/caMicroscope/js/annotationtoolslymph/osdAnnotationTools_Lymph.js";
        String fileName = "/Users/tdiprima/github/Quip/caMicroscope/js/annotationtools/osdAnnotationTools copy.js";
        //String fileName = "/Users/tdiprima/github/Quip/caMicroscope/js/annotationtools_sc/osdAnnotationTools_sc.js";
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
                if (pos != -1)
                {
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
                        if (print)
                            System.out.println(line);

                    } else {
                        // Line does not contain search term.
                        // !print = Print it if you don't find it.
                        if (!print)
                            System.out.println(line);

                    }

                }

            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }

    /**
     * Specialized for C++
     * TODO: REMEMBER - LOWERCASE
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
                        if (tmpLine.contains(goodWords[i]))
                            System.out.println(line);
                    }
                }

            }

            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Crap, I think I messed up, man...

     public static void read(String fileName, String search, String operation, boolean print) {

     String line;

     try {
     FileReader fileReader =
     new FileReader(fileName);

     bufferedReader = new BufferedReader(fileReader);

     while ((line = bufferedReader.readLine()) != null) {

     String tmpLine = line.trim().toLowerCase();

     // Got it?  Good.
     if (tmpLine.contains(search)) {
     // Do we want to print the line if we find it, or print it if we *don't* find it?
     if (print) {
     // Cool. Where in the line do we expect to find it?
     if (operation.equalsIgnoreCase("startsWith"))
     System.out.println(line);

     else if (operation.equalsIgnoreCase("endsWith"))
     System.out.println(line);

     else
     System.out.println(line);


     } else {
     if (!operation.equalsIgnoreCase("startsWith"))
     System.out.println(line);

     else if (!operation.equalsIgnoreCase("endsWith"))
     System.out.println(line);

     }

     } else {
     // Line does not contain the search term
     System.out.println(line);

     }

     }

     bufferedReader.close();
     } catch (FileNotFoundException ex) {
     System.out.println(
     "Unable to open file '" +
     fileName + "'");
     } catch (IOException ex) {
     System.out.println(
     "Error reading file '"
     + fileName + "'");
     }
     }
     */


}
