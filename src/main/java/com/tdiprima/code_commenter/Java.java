package com.tdiprima.code_commenter;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by tdiprima on 2/9/18.
 */
public class Java extends Program {

    /*
    @Override
    public String readIt(String fileWithPath) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWithPath));

        String line;
        while ((line = bufferedReader.readLine()) != null) {

            if ((line.contains("\\\\") || line.contains("\\"))) {

                System.out.println(line.trim());
            }

        }

        bufferedReader.close();
        return "".toString();
    }
     */

 /*
    @Override
    public String readIt(String fileWithPath) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWithPath));

        StringBuffer sb = new StringBuffer();

        String line;
        while ((line = bufferedReader.readLine()) != null) {

            if ((line.contains("public") || line.contains("private")) && line.endsWith("{")) {

                String str = line.trim();
                if (!str.startsWith("//")) {
                    sb.append(line);
                    sb.append("\n");

                    str = str.replace("'", "");
                    str = str.replace("'\"", "");

                    sb.append("System.out.println(\"");
                    sb.append(str);
                    sb.append("\");");
                    sb.append("\n");

                } else {
                    sb.append(line + "\n");
                }

            } else {
                sb.append(line + "\n");
            }

        }

        bufferedReader.close();
        return sb.toString();
    }*/
    @Override
    public String readIt(String fileWithPath) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWithPath));

        StringBuffer sb = new StringBuffer();

        String line;
        while ((line = bufferedReader.readLine()) != null) {

            if ((line.contains("public") || line.contains("private")) && line.endsWith("{")) {
                String str = line.trim();

                if (!str.startsWith("//")) {
                    sb.append(line);
                    sb.append("\n");

                    str = str.replace("'", "");
                    str = str.replace("'\"", "");

                    sb.append("System.out.println(\"");
                    sb.append(str);
                    sb.append("\");");
                    sb.append("\n");

                } else {
                    sb.append(line + "\n");
                }

            } else {

                if ((line.contains("\\\\") || line.contains("\\"))) {

                    System.out.println(line.trim());

                    sb.append("//TODO: FILE SYSTEM\n");
                    sb.append("//" + line + "\n");
                    sb.append(line + "\n");
                } else {
                    sb.append(line + "\n");
                }

            }

        }

        bufferedReader.close();
        return sb.toString();
    }

    @Override
    public String getExt() {
        return ".java";
    }
}
