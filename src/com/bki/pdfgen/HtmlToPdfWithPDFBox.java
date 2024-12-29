package com.bki.pdfgen;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HtmlToPdfWithPDFBox {

	 public static void main(String[] args) {
	        try (PDDocument document = new PDDocument()) {
	            PDPage page = new PDPage();
	            document.addPage(page);
	            PDPageContentStream contentStream = new PDPageContentStream(document, page);

	            // Load your HTML document
	            String html = "<html><body><p>Hello, PDFBox with HTML content!</p></body></html>";
	            Document doc = Jsoup.parse(html);

	            // Set initial Y position and line height
	            float yPosition = 750;
	            float lineHeight = 15;

	            // Set font and font size
	            contentStream.beginText();
	            contentStream.setFont(PDType1Font.HELVETICA, 12);

	            // Parse and draw the text from HTML
	            Elements paragraphs = doc.select("p");
	            for (Element paragraph : paragraphs) {
	                String text = paragraph.text();
	                contentStream.newLineAtOffset(100, yPosition);
	                contentStream.showText(text);
	                yPosition -= lineHeight;
	            }
	            contentStream.endText();
	            contentStream.close();

	            document.save("C:\\Users\\kedhy\\eclipse-workspace\\HtmlToPdf.pdf");
	            System.out.println("PDF created successfully from HTML.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
}
