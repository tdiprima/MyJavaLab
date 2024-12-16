/**
 * Created by tdiprima on 6/1/16.
 */
package com.company.io;

import java.io.*;
import java.util.*;

public class FileReader2 {

    public static void main(String[] args) {
//        String files[] = {"heatmap.out"};
//        for (int i = 0; i < files.length; i++) {
//            de_duplicate(files[i]);
//        }
        template(System.getProperty("user.home") + "/restained/folders.list");
    }

    public static void de_duplicate(String fileName) {

        System.out.println(fileName);

        Set<String> stringSet = new HashSet<String>();

        try {
            FileReader fileReader
                    = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName + ".out"), "utf-8"));

            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                stringSet.add(line);
            }

            Iterator it = stringSet.iterator();
            while (it.hasNext()) {
                writer.write(it.next() + "\n");
            }

            bufferedReader.close();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }

    }

    public static void template(String fileName) {

        System.out.println("START");

        Set<String> stringSet = new HashSet<String>();

        try {
            FileReader fileReader
                    = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                stringSet.add(line);

//                if (line.contains("0,NONE,NONE,NONE")) {
//                    System.out.println(line);
//                }
//                if (!line.startsWith("#")) {
//                    stringSet.add(line);
//                }
            }

            Iterator it = stringSet.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }

            /*
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("PAAD_188.csv"), "utf-8"));
            writer.write("path,studyid,clinicaltrialsubjectid,imageid\n");
            StringBuffer sb;
             */

 /*
            System.out.println("CollectionName,studyid,clinicaltrialsubjectid,imageid,filename,type");
            while ((line = bufferedReader.readLine()) != null) {
                map_loader(line);
            }
             */
            // writer.close();
            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }

    }

    public static void symlink(String line) {
        String[] arrOfStr = line.split("/");
        int last = arrOfStr.length;
        String x = arrOfStr[last - 1];
        x = x.substring(0, x.indexOf(".")) + ".svs";
        System.out.println("ln -s " + line.trim() + " " + System.getProperty("user.home") + "/temp/" + x);
    }

    // FIND IN PathDB httplinks.csv, CREATE manifest.csv
    public static void two_files() {
        // IMPORTANT NOTE!
        // REMOVE CSV HEADER FIRST!
        // path,studyid,subjectid,imageid,"Image URL"
        String homeDirectory = System.getProperty("user.home");
        String fileName = homeDirectory + "/myList.list";
        String fileName1 = homeDirectory + "/seervtrbcpilot.csv";
        String line;
        String line1;

        System.out.println("studyid,clinicaltrialsubjectid,imageid,filename");

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean found;

            while ((line = bufferedReader.readLine()) != null) {
                found = false;
                FileReader fileReader1 = new FileReader(fileName1);
                String imageid = line.replace(".json", "");
                BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
                while ((line1 = bufferedReader1.readLine()) != null) {
                    String[] row = line1.split(",");
                    String temp = row[0];
                    String path = temp.substring(temp.indexOf("/") + 1).replace(".svs", "");

                    if (path.contains(imageid.replace("thresh", "VTRBCT"))) {
                        System.out.println(row[1] + "," + row[2] + "," + row[3] + "," + line.trim());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.err.println(">>>>" + line);
                }
                bufferedReader1.close();

            }
            bufferedReader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }

    }

    public static void compare_two_files() {
        String homeDirectory = System.getProperty("user.home");
        String fileName = homeDirectory + "/thresh1.list";
        String fileName1 = homeDirectory + "/seervtrbcpilot.csv";
        String line;
        String line1;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean found = false;

            while ((line = bufferedReader.readLine()) != null) {
                found = false;
                FileReader fileReader1 = new FileReader(fileName1);
                BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
                while ((line1 = bufferedReader1.readLine()) != null) {
                    String x = line.replace(".json", "");
                    String y = line1.replace(".svs", "");
                    if (x.equalsIgnoreCase(y)) {
                        System.out.println(x);
                        found = true;
                    }
                }
                if (!found) {
                    System.err.println(">>>>" + line);
                }
                bufferedReader1.close();

            }
            bufferedReader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }

    }

    public static void file_moved(String line) {
        line = line.replace("/data/pathdb/files/wsi/paad/", "");
        line = line.replace("/data/pathdb/files/wsi/new_images/paad/", "");
        String x = line.substring(0, line.indexOf(".")) + "*.svs";
        System.out.println("find /data -name \"" + x + "\"");
    }

    public static void meaningful_rename(String line) {
        String x = line.substring(0, line.indexOf(".")) + "-incep-mix-prob.csv";
        System.out.println("mv \"" + line.replace("svs", "csv") + "\" \"" + x + "\"");
    }

    public static void OY(String line) {

        String[] thing = line.split(",");

        String path = thing[0];
        String repl = "/data/quip_distro/images/";
        path = path.replace(repl, "");

        String studyid = thing[1];

        String x = path.replace("paad/", "");
        String clinicaltrialsubjectid = x.substring(0, 12);
        String imageid = x.substring(13, 23);

        System.out.println(path + "," + studyid + "," + clinicaltrialsubjectid + "," + imageid);

    }

    public static void re_dir(String line) {
        String repl = "/data/quip_distro/images/";
        String[] thing = line.split(",");
        String studyid = thing[1];
//        String clinicaltrialsubjectid = thing[2];
//        String imageid = thing[3].substring(thing[3].indexOf("-") + 1);

        String path = thing[0];
        path = path.replace(repl, "");
//        path = path.replace("/data/pathdb/files/wsi/paad/", repl);
//        path = path.replace("/data/pathdb/files/wsi/new_images/paad/", repl);

        String x = path.replace("tcga_data/paad/", "");
//        System.out.println(x);
        String clinicaltrialsubjectid = x.substring(0, 12);
        String imageid = x.substring(13, 23);

        System.out.println(path + "," + studyid + "," + clinicaltrialsubjectid + "," + imageid);

    }

    public static void map_loader(String filename) {
        //System.out.println("studyid,clinicaltrialsubjectid,imageid,filename");
        String clinicaltrialsubjectid = filename.substring(0, 12);
        String imageid = filename.substring(13, 23);
        System.out.println("TCGA:paad," + clinicaltrialsubjectid + "," + imageid + "," + filename);

    }

    public static void map_pdac(String filename) {
        //System.out.println("CollectionName,studyid,clinicaltrialsubjectid,imageid,filename,type");
        //if (filename.contains("til")) {
        //path,studyid,clinicaltrialsubjectid,imageid
        //String x = filename.trim().replace(".json", "").replace("_til", "");
        String x = filename.trim().replace(".json", "");
        System.out.println(filename + "," + x + "," + x + "," + x);
        //}

    }

    public static void map_brca(String filename) {
        //System.out.println("CollectionName,studyid,clinicaltrialsubjectid,imageid,filename");
        String x = filename.trim();

        //System.out.println("TCGA-PAAD,TCGA-PAAD," + x.substring(0, 12) + "," + x.substring(8, 23) + ",/data/pathdb/files/2019-07/" + filename.substring(0, filename.indexOf(".")) + "-incep-mix-prob.csv");
        if (x.length() == 20) {
            System.out.println("TCGA BRCA DEMO,TCGA-BRCA,TCGA-" + x.replace(".json", "").substring(0, 4) + "," + x.replace(".json", "") + "," + filename);
        } else {
            System.out.println("TCGA BRCA DEMO,TCGA-BRCA," + x.substring(0, 12) + "," + x.substring(8, 23) + "," + filename);
        }

    }

    /**
     * Read file and store text as array
     * https://github.com/IBeRamen/APCS/blob/master/Module06/HeatIndex.java
     */
    public static List<String> ReadTemps() {

        String fileName = "KeyWestTemp.txt";
        String line;

        List<String> temps = new ArrayList<String>();

        try {
            FileReader fileReader
                    = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                line = line.trim();
                temps.add(line);
            }

            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return temps;
    }

    public static void countFuncInFiles(String line) {
        System.out.println("echo '" + line + "\t'; ack -ch " + line);
    }

    public static void everyOther(int count, String line) {

        System.out.print(line);

        if (count % 2 == 0) {
            System.out.println();
        }

    }

    public static String putNewlineAtEnd(String line) {
        String ret = line.trim() + "\n";
        System.out.println(ret);
        return ret;
    }

    public static void stringParseExample() {
        String line = "bla bla blah";
        String[] fields = line.split("\t");
        for (int i = 0; i < fields.length; i++) {
            System.out.println(i + ": " + fields[i]);
        }
    }

    public static void parseErrorsFromConsole() {
        String fileName = System.getProperty("user.home") + "/Desktop/biglogfile.log";

        String line;

        try {
            FileReader fileReader
                    = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean flag = false;

            while ((line = bufferedReader.readLine()) != null) {

                if (line.toLowerCase().contains("error")) {
                    flag = true;
                    System.out.println(line);
                }

                if (line.startsWith("request.url") && !line.contains("favicon") && flag) {
                    line = line.substring("request.url: ".length());
                    System.out.println("http://quip1.uhmc.sunysb.edu:4000" + line + "\n");
                    flag = false;
                }

            }

            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Ha. Remove the first n chars from each line of history file.
     */
    public static void rewriteHistory() {

        // TODO: history > history-file.sh
        String s = System.getProperty("user.home") + "/Desktop/han_data04A.list";
        int len = 4;

        try {
            FileReader fr = new FileReader(s);
            BufferedReader br = new BufferedReader(fr);
            String l;
            while ((l = br.readLine()) != null) {
                try {
                    int len1 = l.trim().length();
                    if (len1 > 0) {
                        String x = (l.trim().substring(len)).trim();
                        if (x.contains("/")) {
                            System.out.println(x.substring(x.indexOf("/")));
                        }

                    }
                } catch (StringIndexOutOfBoundsException iii) {
                    System.out.println("here:" + l);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // System.out.println("\nTHE END\n");
        }

    }
}
