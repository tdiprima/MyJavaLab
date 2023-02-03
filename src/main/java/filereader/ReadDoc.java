/*
 * Apache POI - the Java API for Microsoft Documents
 * https://www.apache.org/dyn/closer.lua/poi/release/bin/poi-bin-5.2.3-20220909.tgz
 */

package filereader;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.util.StringTokenizer;


/**
 *
 * @author tammydiprima
 */
public class ReadDoc {

	public ReadDoc() {
	}

	public String getOnlyWhatINeed(String filesname, String group) {
		POIFSFileSystem fs = null;
		StringBuffer outString = new StringBuffer();
		String a = "(type answer here)";
		String a1 = "(do not answer";
		String a2 = "(attach digital copy here)"; // (insert digital copy of document here)
		try {
			fs = new POIFSFileSystem(new FileInputStream(filesname));
			HWPFDocument doc = new HWPFDocument(fs);
			WordExtractor we = new WordExtractor(doc);

			String allText = new String(we.getText());

			boolean putGroupID = (group.equalsIgnoreCase("MS") ||
					              group.equalsIgnoreCase("ED"));
			String groupID = filesname.substring(filesname.indexOf('.') - 3,
					                             filesname.indexOf('.'));

			StringTokenizer st = new StringTokenizer(allText, "\n");
			while (st.hasMoreTokens()) {
				String line = st.nextToken();

				if ((line.indexOf(group + "-") != -1 && line.indexOf("Group") == -1)
						|| line.indexOf("Key Quantitative") != -1) {
					outString.append(line);
					if (putGroupID) {
						outString.append("\t");
						outString.append(groupID);
					}
					outString.append("\n");

				} else if (line.indexOf(a) != -1) {
					outString.append("\t");
					outString.append(a);
					if (putGroupID) {
						outString.append("\t");
						outString.append(groupID);
					}
					outString.append("\n");

				} else if (line.indexOf(a1) != -1) {
					outString.append("\t");
					outString.append(a1);
					outString.append("\t\t");
					outString.append(groupID);
					outString.append("\n");
				} else if (line.indexOf(a2) != -1) {
					outString.append("\t");
					outString.append(a2);
					if (putGroupID) {
						outString.append("\t");
						outString.append(groupID);
					}
					outString.append("\n");

				} else {

					String[] alpha = { "a.", "b.", "c.", "d.", "e.", "f.",
							"g.", "h.", "j.", "k.", "l.", "m.", "n.", "o.",
							"p.", "q.", "r.", "s.", "t.", "u.", "w.", "y.",
							"z.", "viii.", "vii.", "vi.", "iv.", "ix.", "iii.",
							"ii.", "x.", "i.", "v." };

					for (int i = 0; i < alpha.length; i++) {
						if (line.indexOf(alpha[i] + "\t") != -1) {
							outString.append("   ");
							if (alpha[i].equalsIgnoreCase("viii.")
									|| alpha[i].equalsIgnoreCase("vii.")
									|| alpha[i].equalsIgnoreCase("vi.")
									|| alpha[i].equalsIgnoreCase("iv.")
									|| alpha[i].equalsIgnoreCase("ix.")
									|| alpha[i].equalsIgnoreCase("iii.")
									|| alpha[i].equalsIgnoreCase("ii.")

							) {
								outString.append("   ");
							}
							int pos = line.indexOf('\t') + 1;
							outString.append(line.substring(0, pos - 1));
							outString.append(" ");
							outString.append(line.substring(pos));
							outString.append("\n");
						}

					}

				}
			}

		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return outString.toString();
	}

	public static void main(String[] args) {
	}

}
