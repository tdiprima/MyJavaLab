package com.tdiprima.obscura;

public class Obscura {
    
}

//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import org.apache.jena.query.Dataset;
//import org.apache.jena.query.ResultSet;
//import org.dcm4che3.tool.dicomimageio.DicomImageReaderSpi;
//
//public class Obscura {
//    public static void main(String[] args) {
//        try {
//            // Example: Read a DICOM image
//            BufferedImage dicomImg = DCM.readDicomImage(new File("input.dcm"));
//            System.out.println("DICOM Image read successfully.");
//
//            // Example: Convert grayscale to RGB
//            BufferedImage neoImg = NeoTools.convertGrayscaleToRGB(dicomImg);
//            System.out.println("Converted to RGB.");
//
//            // Example: Draw an outlined box
//            NeoTools.drawOutlinedBox(neoImg, 10, 20, 30, 40);
//            ImageIO.write(neoImg, "PNG", new File("output.png"));
//            System.out.println("Outlined box drawn and saved as output.png.");
//
//            // Example: Load RDF dataset
//            Dataset dataset = obscura.loadDataset("data.ttl.gz");
//            System.out.println("RDF dataset loaded successfully.");
//
//            // Example: Execute SPARQL query
//            String queryString = "SELECT * WHERE { ?s ?p ?o } LIMIT 10";
//            ResultSet resultSet = obscura.executeQuery(dataset, queryString);
//            System.out.println("SPARQL query executed successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
