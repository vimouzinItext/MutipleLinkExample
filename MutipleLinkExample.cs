using iText.Kernel.Colors;
using iText.Kernel.Pdf;
using iText.Kernel.Pdf.Action;
using iText.Layout;
using iText.Layout.Element;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace ConsoleApp1
{
    class MutipleLinkExample{
        public static void Main(String[]args)
        {
            CreatePdf();
        }
        public static void CreatePdf()
        {
            // path to output pdf
            String outFileName = Directory.GetCurrentDirectory()+ "\\output.pdf";
            
            // create Pdfdocument with pdfwriter
            PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outFileName));
            //add to doc
            Document doc = new Document(pdfDocument);
            //create link
            PdfAction action = PdfAction.CreateURI("http://itextpdf.com");
            //create div with height 2000 will expand to three pdf pages
            Div div = new Div()
                    .SetHeight(2000)
                    .SetBackgroundColor(ColorConstants.RED);
            //add link to pdf
            div.SetAction(action);
            //add div to document
            doc.Add(div);
            //close document
            doc.Close();
        }
    }
}
