package bear;

import com.company.helper.Program;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String topLevelDir = "/Users/tdiprima/trabajo/myOpenSeadragon/openseadragon-2.4.2/src/";

        // boolean warn = true;
        boolean warn = false;
        if (warn) {
            String mainDir = topLevelDir.substring(topLevelDir.lastIndexOf("/"));
            System.out.println("ABOUT TO OVERWRITE...");
            System.out.println(topLevelDir);
            System.out.println("BACK UP DIRECTORY FIRST!!!");
            System.out.println("cp -rp \"" + topLevelDir + "\" \"$HOME" + mainDir + "_BAK\"");
            System.exit(1);

        }
        // processFiles(topLevelDir, new Js());

        String filename = "/Users/tdiprima/trabajo/filtering/js/openseadragon-filtering.js";
        oneFile(filename, new Js());
    }

    public static void processFiles(String topLevelDir, Program pgm) {
        String ext = pgm.getExt();

        try {
            ArrayList<String> filesWithPath = findFiles(topLevelDir);

            for (int i = 0; i < filesWithPath.size(); i++) {
                String fileWithPath = filesWithPath.get(i);
                if (fileWithPath.endsWith(ext)) {
                    System.out.println("file: " + fileWithPath + "\n");
                    /* doIO reads & writes */
                    pgm.doIO(fileWithPath);
                    // String contents = pgm.doIO(fileWithPath);
                    // pgm.writeIt(contents, fileWithPath + ".1");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void oneFile(String fileWithPath, Program pgm) {
        String ext = pgm.getExt();
        try {
            if (fileWithPath.endsWith(ext)) {
                System.out.println("file: " + fileWithPath + "\n");
                pgm.doIO(fileWithPath);
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    /**
     * Walk through directory tree, find files, add names to list.
     */
    public static ArrayList<String> findFiles(String topLevelDir) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();

        Files.walk(Paths.get(topLevelDir)).forEach(filePath -> {

            if (Files.isRegularFile(filePath)) {
                String f;
                f = String.valueOf(filePath);
                arrayList.add(f);

            }
        });

        return arrayList;

    }
}
