package bear;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public abstract class Program {

    public String doIO(String fileWithPath) throws Exception {

        String contents = readIt(fileWithPath);
        writeIt(contents, fileWithPath);

        return contents;
    }

    public abstract String readIt(String fileWithPath) throws Exception;

    public abstract String getExt();

    public void writeIt(String contents, String fileOUT) throws Exception {

        Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileOUT), "utf-8"));

        writer.write(contents);

        writer.close();
    }
}
