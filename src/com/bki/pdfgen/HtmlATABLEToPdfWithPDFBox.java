package com.bki.pdfgen;



import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HtmlATABLEToPdfWithPDFBox {

	 public static void main(String[] args) {
	        try (PDDocument document = new PDDocument()) {
	            PDPage page = new PDPage();
	            document.addPage(page);
	            PDPageContentStream contentStream = new PDPageContentStream(document, page);

	            // Load your HTML document
	            String html = "<html><body><p>Hello, PDFBox with HTML table content!</p><BR>"
	            		+ "						<Table>"
	            		+ "							<tr>"
	            		+ "	            		<th>Col-1</th><th>Col-2</th>"
	            		+ "						</tr><tr>\r\n"
	            		+ "	            		<td>data 1</td><td>data 2</td>"
	            		+ "						</tr><tr>"
	            		+ "						<td>data 3</td><td>data 4</td>"
	            		+ "						</tr>"
	            		+ "	            		</Table></body></html>";
	            Document doc = Jsoup.parse(html);

	            // Set initial Y position and line height
	            float yPosition = 750;
	            float lineHeight = 15;

	            // Set font and font size
	            contentStream.beginText();
	            contentStream.setFont(PDType1Font.HELVETICA, 12);
	            String text = null;

	            // Parse and draw the text from HTML
	            Elements paragraphs = doc.select("p");
	            for (Element paragraph : paragraphs) {
	                	text = paragraph.text();
	                contentStream.newLineAtOffset(100, yPosition);
	                contentStream.showText(text);
	                System.out.println("p: text:"+text);
	                yPosition -= lineHeight;
	            }
	            contentStream.endText();
	            Elements tables = doc.select("Table");
	            for (Element table : tables) {
	                 text = table.text();
	                 System.out.println("table: text:"+text);
	                contentStream.newLineAtOffset(120, yPosition);
	                contentStream.showText(text);
	                yPosition -= lineHeight;
	            }
	            contentStream.endText();
	            contentStream.close();

	            document.save("C:\\Users\\kedhy\\eclipse-workspace\\HtmlTableToPdf.pdf");
	            System.out.println("PDF created successfully from HTML.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	

}
