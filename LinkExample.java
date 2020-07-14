package LinkExample;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Div;

import java.io.FileNotFoundException;

public class LinkExample {

    public static void main(String[] args) throws FileNotFoundException {
        createPdf();
    }

    public static void createPdf() throws FileNotFoundException {
        //get ouput path for pdf file
        String outFileName = System.getProperty("user.dir")+"\\output.pdf";
        // create Pdfdocument with pdfwriter
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outFileName));
        //add to doc
        Document doc = new Document(pdfDocument);
        //create link
        PdfAction action = PdfAction.createURI("http://itextpdf.com");
        //create div with height 2000 will expand to three pdf pages
        Div div = new Div()
                .setHeight(2000)
                .setBackgroundColor(ColorConstants.RED);
        //add link to pdf
        div.setAction(action);
        //add div to document
        doc.add(div);
        //close document
        doc.close();
    }
}
