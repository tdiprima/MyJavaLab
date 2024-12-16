package com.company.code_crawler;import java.nio.file.Files;import java.nio.file.Paths;import java.util.ArrayList;import com.company.helper.*;public class RewriteCodeConsoleOut {    /**     * Main ~     *     * @param args     */    public static void main(String[] args) {        /**         * TODO: A) If Python, is tab 2 or 4? B) Pass correct program-type to         * processFiles C) If JS, make sure u didn't f with it.         */        String topLevelDir = System.getProperty("user.home") + "/something/";        boolean warn = false;        if (warn) {            String mainDir = topLevelDir.substring(topLevelDir.lastIndexOf("/"));            System.out.println("ABOUT TO OVERWRITE...");            System.out.println(topLevelDir);            System.out.println("BACK UP DIRECTORY FIRST!!!");            System.out.println("cp -rp \"" + topLevelDir + "\" \"$HOME" + mainDir + "_BAK\"");            System.exit(1);        }        // TODO:        processFiles(topLevelDir, new Js());//        processFiles(topLevelDir, new Java());//        processFiles(topLevelDir, new Py());    }    /**     * Process files.     *     * @param topLevelDir     */    public static void processFiles(String topLevelDir, Program pgm) {        String ext = pgm.getExt();        try {            ArrayList<String> filesWithPath = findFiles(topLevelDir);            for (int i = 0; i < filesWithPath.size(); i++) {                String fileWithPath = filesWithPath.get(i);                if (fileWithPath.endsWith(ext)) {                    System.out.println("file: " + fileWithPath + "\n");                    /* doinIt reads & writes */                    pgm.doinIt(fileWithPath);                    //String contents = pgm.doinIt(fileWithPath);                    //pgm.writeIt(contents, fileWithPath + ".1");                }            }        } catch (Exception ex) {            ex.printStackTrace();        }    }    /**     * C++     */    public static void doCxx() {        Cxx myCxx = new Cxx();        String str1 = ") {"; // As long as it's formatted properly!        String str2 = "::";        String special1 = "//";        String special2 = "for (";        String spaces = "    "; // indent        String fname = System.getProperty("user.home") + "/github/SlicerPathology/QuickTCGA/Logic/NucleusSeg_Yi/TypeUtils.h";        myCxx.doinIt(fname, str1, str2, special1, special2, spaces);    }    /**     * Walk through directory tree, find files, add names to list.     */    public static ArrayList<String> findFiles(String topLevelDir) throws Exception {        ArrayList<String> arrayList = new ArrayList<>();        Files.walk(Paths.get(topLevelDir)).forEach(filePath -> {            if (Files.isRegularFile(filePath)) {                String f;                f = String.valueOf(filePath);                arrayList.add(f);            }        });        return arrayList;    }}