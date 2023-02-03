/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filereader;

import java.io.*;

/**
 *
 * @author tammydiprima
 */
public class PrintFile extends PrintStream {
  public PrintFile(String filename)
    throws IOException {
    super(
      new BufferedOutputStream(
        new FileOutputStream(filename)));
  }
  public PrintFile(File file)
    throws IOException {
    this(file.getPath());
  }
}