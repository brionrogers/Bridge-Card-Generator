/*
v4.0

Class creating output PDF.

*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF {

    Document document;
    Deck deck;

    String northSpade;
    String northHeart;
    String northDiamond;
    String northClub;
    String westSpade;
    String westHeart;
    String westDiamond;
    String westClub;
    String southSpade;
    String southHeart;
    String southDiamond;
    String southClub;
    String eastSpade;
    String eastHeart;
    String eastDiamond;
    String eastClub;

    CreatePDF(Deck aDeck) throws DocumentException, IOException, NullPointerException, BadElementException {
        deck = aDeck;

        try {
            createFile();
            JOptionPane.showMessageDialog(null, "Document created! \n"
                                              + "Document can be found at " + System.getProperty("user.dir"));
        } catch (IOException | NullPointerException | DocumentException e) {
            JOptionPane.showMessageDialog(null, "Document cannot be created because it is open in another program.");
        }
    }

    private void setCardValue() {
        northSpade = " ";
        northHeart = " ";
        northDiamond = " ";
        northClub = " ";
        westSpade = " ";
        westHeart = " ";
        westDiamond = " ";
        westClub = " ";
        southSpade = " ";
        southHeart = " ";
        southDiamond = " ";
        southClub = " ";
        eastSpade = " ";
        eastHeart = " ";
        eastDiamond = " ";
        eastClub = " ";
    }

    private void createFile() throws FileNotFoundException, DocumentException {
        document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(deck.deckLabel + ".pdf"));
        document.open();

        for (int i = 0; i < deck.boards.length; i++) {
            if (!deck.boards[i].getLabel().equals("")) {
                setCardValue();
                getCardValue(i);

                //Board Info
                Paragraph preface = new Paragraph("Board "+(i+1)+":  " + deck.boards[i].boardLabel, new Font(FontFamily.COURIER));
                preface.setAlignment(Element.ALIGN_CENTER);
                preface.add(new Paragraph(" "));
                preface.add(new Paragraph("Dealer = " + deck.boards[i].dealer, new Font(FontFamily.COURIER)));
                preface.add(new Paragraph(" "));
                document.add(preface);

                //North Player			
                Paragraph northParagraph = new Paragraph(northSpade, new Font(FontFamily.COURIER));
                northParagraph.setAlignment(Element.ALIGN_LEFT);

                Paragraph northParagraph1 = new Paragraph(northHeart, new Font(FontFamily.COURIER));
                northParagraph1.setAlignment(Element.ALIGN_LEFT);

                Paragraph northParagraph2 = new Paragraph(northDiamond, new Font(FontFamily.COURIER));
                northParagraph2.setAlignment(Element.ALIGN_LEFT);

                Paragraph northParagraph3 = new Paragraph(northClub, new Font(FontFamily.COURIER));
                northParagraph3.setAlignment(Element.ALIGN_LEFT);

                PdfPTable northTable = new PdfPTable(1);
                northTable.getDefaultCell().setBorder(0);
                northTable.addCell(new Paragraph(northSpade, new Font(FontFamily.COURIER)));
                northTable.addCell(new Paragraph(northHeart, new Font(FontFamily.COURIER)));
                northTable.addCell(new Paragraph(northDiamond, new Font(FontFamily.COURIER)));
                northTable.addCell(new Paragraph(northClub, new Font(FontFamily.COURIER)));

                Paragraph combinedNorth = new Paragraph();
                combinedNorth.add(northTable);
                combinedNorth.setIndentationLeft(170);
                document.add(combinedNorth);

                //West and East
                document.add(new Paragraph(" "));

                PdfPTable WE_table = new PdfPTable(2);
                WE_table.getDefaultCell().setBorder(0);
                float[] columnWidths = new float[]{18f, 10f};
                WE_table.setWidths(columnWidths);
                WE_table.addCell(new Phrase(westSpade, new Font(FontFamily.COURIER)));
                WE_table.addCell(new Phrase(eastSpade, new Font(FontFamily.COURIER)));
                WE_table.addCell(new Phrase(westHeart, new Font(FontFamily.COURIER)));
                WE_table.addCell(new Phrase(eastHeart, new Font(FontFamily.COURIER)));
                WE_table.addCell(new Phrase(westDiamond, new Font(FontFamily.COURIER)));
                WE_table.addCell(new Phrase(eastDiamond, new Font(FontFamily.COURIER)));
                WE_table.addCell(new Phrase(westClub, new Font(FontFamily.COURIER)));
                WE_table.addCell(new Phrase(eastClub, new Font(FontFamily.COURIER)));

                Paragraph westEast = new Paragraph();
                westEast.setAlignment(Element.ALIGN_CENTER);
                westEast.setIndentationLeft(40);
                westEast.add(WE_table);
                document.add(westEast);

                //South Player
                document.add(new Paragraph(" "));

                Paragraph southParagraph = new Paragraph(southSpade, new Font(FontFamily.COURIER));
                southParagraph.setAlignment(Element.ALIGN_LEFT);
                Paragraph southParagraph1 = new Paragraph(southHeart, new Font(FontFamily.COURIER));
                southParagraph1.setAlignment(Element.ALIGN_LEFT);
                Paragraph southParagraph2 = new Paragraph(southDiamond, new Font(FontFamily.COURIER));
                southParagraph2.setAlignment(Element.ALIGN_LEFT);
                Paragraph southParagraph3 = new Paragraph(southClub, new Font(FontFamily.COURIER));
                southParagraph3.setAlignment(Element.ALIGN_LEFT);

                PdfPTable southTable = new PdfPTable(1);
                southTable.getDefaultCell().setBorder(0);
                southTable.addCell(new Paragraph(southSpade, new Font(FontFamily.COURIER)));
                southTable.addCell(new Paragraph(southHeart, new Font(FontFamily.COURIER)));
                southTable.addCell(new Paragraph(southDiamond, new Font(FontFamily.COURIER)));
                southTable.addCell(new Paragraph(southClub, new Font(FontFamily.COURIER)));

                Paragraph combinedSouth = new Paragraph();
                combinedSouth.add(southTable);
                combinedSouth.setIndentationLeft(170);

                document.add(combinedSouth);

                Paragraph pNotes = new Paragraph(" ", new Font(FontFamily.COURIER));
                pNotes.add(Chunk.NEWLINE);
                pNotes.add(new Chunk("Notes:\n"));
                notes(pNotes, deck.boards[i].notes);
                document.add(pNotes);

                document.newPage();
            }
        }

        document.close();
    }
    
    private void notes(Paragraph p, String notes)
    {
    	if(notes.contains("	"))
    	{
    	   p.setTabSettings(new TabSettings(58f));
    	   for(int i=0; i<notes.length(); i++)
    	   {
    		   if(notes.charAt(i) == 9)
    		   	   p.add(Chunk.TABBING);
    		   else
    			   p.add(new Chunk(notes.charAt(i)));
    	   }
    	}
    	else
    	p.add(new Chunk(notes));
    }
    
    private void getCardValue(int num) {
        int a = num;

        char x = (char) 8212;

        for (int i = 12; i > -1; i--) {
            String value = String.valueOf(deck.cards[i].value);

            if (deck.cards[i].position[a] == 'N') {
                northSpade += value;
            } else if (deck.cards[i].position[a] == 'W') {
                westSpade += value;
            } else if (deck.cards[i].position[a] == 'S') {
                southSpade += value;
            } else {
                eastSpade += value;
            }
        }

        System.out.println(southSpade);
        
        if (northSpade.equals(" ")) {
            northSpade = northSpade + x;
        }
        if (southSpade.equals(" ")) {
            southSpade = southSpade + x;
        }
        if (eastSpade.equals(" ")) {
            eastSpade = eastSpade + x;
        }
        if (westSpade.equals(" ")) {
            westSpade = westSpade + x;
        }

        
        for (int i = 25; i > 12; i--) {
            String value = String.valueOf(deck.cards[i].value);

            if (deck.cards[i].position[a] == 'N') {
                northHeart += value;
            } else if (deck.cards[i].position[a] == 'W') {
                westHeart += value;
            } else if (deck.cards[i].position[a] == 'S') {
                southHeart += value;
            } else {
                eastHeart += value;
            }
        }
        
                
        if (northHeart.equals(" ")) {
            northHeart = northHeart + x;
        }
        if (southHeart.equals(" ")) {
            southHeart = southHeart + x;
        }
        if (eastHeart.equals(" ")) {
            eastHeart = eastHeart + x;
        }
        if (westHeart.equals(" ")) {
            westHeart = westHeart + x;
        }

        for (int i = 38; i > 25; i--) {
            String value = String.valueOf(deck.cards[i].value);

            if (deck.cards[i].position[a] == 'N') {
                northDiamond += value;
            } else if (deck.cards[i].position[a] == 'W') {
                westDiamond += value;
            } else if (deck.cards[i].position[a] == 'S') {
                southDiamond += value;
            } else {
                eastDiamond += value;
            }
        }

        if (northDiamond.equals(" ")) {
            northDiamond = northDiamond + x;
        }
        if (southDiamond.equals(" ")) {
            southDiamond = southDiamond + x;
        }
        if (eastDiamond.equals(" ")) {
            eastDiamond = eastDiamond + x;
        }
        if (westDiamond.equals(" ")) {
            westDiamond = westDiamond + x;
        }
        
        for (int i = 51; i > 38; i--) {
            String value = String.valueOf(deck.cards[i].value);

            if (deck.cards[i].position[a] == 'N') {
                northClub += value;
            } else if (deck.cards[i].position[a] == 'W') {
                westClub += value;
            } else if (deck.cards[i].position[a] == 'S') {
                southClub += value;
            } else {
                eastClub += value;
            }
        }
        
        if (northClub.equals(" ")) {
            northClub = northClub + x;
        }
        if (southClub.equals(" ")) {
            southClub = southClub + x;
        }
        if (eastClub.equals(" ")) {
            eastClub = eastClub + x;
        }
        if (westClub.equals(" ")) {
            westClub = westClub + x;
        }
    }
}
