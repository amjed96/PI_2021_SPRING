package com.pi.demo.services;


import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.pi.demo.model.Announcement;
@Service
public class PDFExporterService 
{
	 private List<Announcement> announcement;
     
	   
	 
	    public PDFExporterService(List<Announcement> announcement) {
		super();
		this.announcement = announcement;
	}

		private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(6);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("Email", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("first_name", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Last_name", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("title", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("description", font));
	        table.addCell(cell);  
	        cell.setPhrase(new Phrase("type", font));
	        table.addCell(cell); 
	    }
	     
	    private void writeTableData(PdfPTable table) {
	        for (Announcement a : announcement) {
	           // table.addCell(String.valueOf(a.getCustomer().getEmail()));
	            table.addCell(String.valueOf(a.getCustomer().getFirstName()));
	            //table.addCell(String.valueOf(a.getCustomer().getLastName()));
	            table.addCell(String.valueOf(a.getTitle()));
	            table.addCell(String.valueOf(a.getDescription()));
	            table.addCell(String.valueOf(a.getType()));
	       
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("List of customers ", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(6);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f,1.5f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }

}
