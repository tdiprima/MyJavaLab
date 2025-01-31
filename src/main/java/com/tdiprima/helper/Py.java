/**
 * Read in code, and spit it back out with print outs for every function definition.
 * So we can learn what's going on here.
 *
 * TODO: Need to figure out, and indicate, class definitions.
 * TODO: Is indent 2 or 4.
 *
 */
package com.tdiprima.helper;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by tdiprima on 3/29/17.
 */
public class Py extends Program {

    private static final String DEF = "def";

    @Override
    public String readIt(String fileWithPath) throws Exception {
        FileReader fileReader
                = new FileReader(fileWithPath);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuffer sb = new StringBuffer();
        String fileName = fileWithPath.substring(fileWithPath.lastIndexOf("/") + 1);
        String thingToLookFor = (" " + DEF + " ");
        String special = (DEF + " ");
        int indent; // TODO: 2 or 4
        indent = 2;
//        indent = 4;
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            // Print info output for each method in Python
            if (line.contains(thingToLookFor)) {

                String str = line.trim();
                // ...unless line starts with #
                if (!str.startsWith("#")) {

                    // Print line, then print info
                    //writer.write(line + "\n");
                    sb.append(line + "\n");

                    int pos = line.indexOf(special);

                    String s = new String();
                    for (int i = 0; i < pos + indent; i++) {
                        s += " ";
                    }
                    str = str.replace("def ", "");
                    str = str.replace(":", "");
                    str = str.replace("\"", "");
                    s += "print \"\\n" + fileName + ": " + str + "\"" + "\n";
                    //writer.write(s);
                    sb.append(s);

                } else {
                    //writer.write(line + "\n");
                    sb.append(line + "\n");
                }

            } else {
                //writer.write(line + "\n");
                sb.append(line + "\n");
            }

        }

        bufferedReader.close();
        return sb.toString();
    }

    @Override
    public String getExt() {
        return ".py";
    }

}
