package com.tdiprima.code_commenter;

import java.io.BufferedReader;

/**
 * Created by tdiprima on 3/29/17.
 */
public class Cxx {

    /**
     * Read in C++ code, and spit out system outs on every function.
     *
     * @param fname
     * @param search1
     * @param search2
     * @param special1
     * @param special2
     * @param spaces
     */
    public static void doinIt(String fname, String search1, String search2, String special1, String special2, String spaces) {
        String line;

        try {
            java.io.FileReader fileReader
                    = new java.io.FileReader(fname);

            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                String str = line.trim();

                // Print info output for each method in C++
                if (str.endsWith(search1) && str.contains(search2)) {

                    if (!str.startsWith(special1) && !str.startsWith(special2)) {
                        // Print line, then print info
                        System.out.println(line);
                        // Indentation doesn't matter in C, print 4 spaces for good measure.
                        // 8 spaces if there's a namespace.
                        str = str.replace(" {", "");
                        str = str.replace("::", ": ");
                        str = str.replace("void", ":");
                        System.out.println(spaces + "std::cout << \"TypeUtils " + str + "\\n\"  << std::flush;");

                    } else {
                        System.out.println(line);
                    }
                } else {
                    System.out.println(line);
                }

            }

            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
