package com.company.helper;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by tdiprima on 7/10/17.
 */
public class Js extends Program {

    @Override
    public String readIt(String fileWithPath) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWithPath));

        StringBuffer sb = new StringBuffer();

        String line;
        while ((line = bufferedReader.readLine()) != null) {

            //if (line.contains("= function (") || line.contains(": function (")) {
            if (line.contains("function") && line.endsWith("{")) {

                String str = line.trim();
                if (!str.startsWith("//")) {
                    sb.append(line);
                    sb.append("\n");

                    str = str.replace("'", "");
                    str = str.replace("'\"", "");
                    //str = str.replace("annotools.prototype.", "");
                    //str = str.replace("AnnotationStore.prototype.", "");

                    // TODO
                    sb.append("console.log('");
                    sb.append(str);
                    sb.append("');");
                    sb.append("\n");

                    // TODO
//                    sb.append("debugger");
//                    sb.append("\n");

                } else {
                    sb.append(line + "\n");
                }

            } else {
                sb.append(line + "\n");
            }

        }

        bufferedReader.close();
        return sb.toString();
    }

    @Override
    public String getExt() {
        return ".js";
    }
}
