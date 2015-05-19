/*
 v4.0

 Class producing image output.

 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BridgePrintImage {
	/*public static void main(String[] args) 
	{
		
		Deck deck1 = new Deck("Broadmore Deck");
		for(int q = 0; q < 9; q++)
		{
			deck1.boards[q].setDealer("North");
		}
		for(int q = 9; q < 18; q++)
		{
			deck1.boards[q].setDealer("East");
		}
		for(int q = 18; q < 27; q++)
		{
			deck1.boards[q].setDealer("South");
		}
		for(int q = 27; q < 36; q++)
		{
			deck1.boards[q].setDealer("West");
		}
		//*********************
                for(int z = 0; z < 52; z++){
                    for(int q = 0; q < 36; q++)
                    {
                            if(q%4 == 1) deck1.cards[z].setPosition(q, 'N');
                            else if(q%4 == 2) deck1.cards[z].setPosition(q, 'S');
                            else if(q%4 == 3) deck1.cards[z].setPosition(q, 'E');
                            else deck1.cards[z].setPosition(q, 'W');
                    }
                }
               
		printCard(deck1);
	}*/

    public static void printCard(Deck deck1) {
        int currentBoard = 0;
        
        //Variables to determine size of deck label box
        int deckLabelHeight = 75;
        int deckLabelWidth = 587;
        
        //Variables to determine size of boxes containing the board number and dealer.
        int widthOfCardBoxes = 143;
        int heightOfCardBoxes = 87;
        int initialHeightOfCardBoxes=120;
        
        
        String OS = System.getProperty("os.name".toLowerCase());
        String currentDir = "";
        File theDir, deckDir;

        //What to do if a user's OS is a Windows OS
        if (OS.charAt(0) == 'W' || OS.charAt(0) == 'w') {
            currentDir = System.getProperty("user.dir");

            //Create a directory to hold the output. Check to see if it exists.
            theDir = new File(currentDir + "\\Images");

            // if the directory does not exist, create it
            if (!theDir.exists()) {
                System.out.println("Creating output directory.");
                boolean result = false;

                try {
                    theDir.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    //handle it
                }
                if (result) {
                    System.out.println("Output directory created");
                }
            }

            //Create a directory to hold the output. Check to see if it exists.
            deckDir = new File(currentDir + "\\Images\\".concat(deck1.getDeckLabel().replaceAll("\\s+", "").concat("\\")));

            // if the directory does not exist, create it
            if (!deckDir.exists()) {
                System.out.println("Creating deck directory.");
                boolean result = false;

                try {
                    deckDir.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    //handle it
                }
                if (result) {
                    System.out.println("Deck directory created");
                }
            }
            
            int jokerNumber = 0;
            for(int n = 0; n < 2; n++)
            {
            // Createing "Joker" image with deck label
            BufferedImage bimage0 = new BufferedImage(747, 1122, BufferedImage.TYPE_BYTE_INDEXED);

            Graphics2D g2d0 = bimage0.createGraphics();

            g2d0.setColor(Color.white);
            g2d0.fill(new Rectangle2D.Double(0, 0, 747, 1120));
            g2d0.drawImage(bimage0, null, 0, 0);

            Font font0 = new Font("Time News Roman", Font.BOLD, 30);
            g2d0.setFont(font0);

            FontMetrics metrics0 = g2d0.getFontMetrics(font0);

            int hgt0 = metrics0.getHeight();

            int adv0 = metrics0.stringWidth(deck1.getDeckLabel());

            Dimension size0 = new Dimension(adv0 + 2, hgt0 + 2);

            g2d0.setColor(Color.LIGHT_GRAY);
            g2d0.fill(new Rectangle2D.Double(70, 70, bimage0.getWidth() - 140, bimage0.getHeight() - 140));
            g2d0.drawImage(bimage0, null, 0, 0);

            g2d0.setColor(Color.black);
            g2d0.drawString(deck1.getDeckLabel(), (int) ((bimage0.getWidth() / 2) - (size0.getWidth() / 2)), (int) ((bimage0.getHeight() / 2) - (size0.getHeight() / 2)));

            
            String fileName0 = "-"+Integer.toString(jokerNumber)+"-Joker Image";
            fileName0 = deck1.getDeckLabel().concat(fileName0).concat(".jpg");
            jokerNumber++;
            try {
                ImageIO.write(bimage0, "JPEG", new File((currentDir + "\\Images\\".concat(deck1.getDeckLabel().replaceAll("\\s+", "").concat("\\")) + fileName0)));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g2d0.dispose();
            }
            //Go through 52 cards and create an image for every card.
            //For each card, go through the 36 boards to create a single image for that card
            //Save the image using the name of the card. 
            for (int j = 0; j < 52; j++) {
                //Set x and y offset to mark where the squares being drawn should begin.
                int x = 80;
                int y = 205;

                //Defines the height on the card at which the player headers should be
                int y_PlayerCoord = 113;

                //Used to figure out middle of the player header for accurate positioning
                int init_PlayerIconOffset = 37;

                //Create BufferedImage that will be the outputted image
                BufferedImage bimage = new BufferedImage(747, 1122, BufferedImage.TYPE_BYTE_INDEXED);

                //Create Graphics2D object to display the BufferedImage
                Graphics2D g2d = bimage.createGraphics();

                //The background of the card must ALWAYS be drawn first. Whatever the lowest
                //layer of the image is must always be drawn first and the highest level
                //be drawn last.
                //Draw white background of card
                g2d.setColor(Color.white);
                g2d.fill(new Rectangle2D.Double(0, 0, 747, 1120));
                g2d.drawImage(bimage, null, 0, 0);

                //Create Deck Label based on FontMetrics
                //FontMetrics measure how wide a String is based on a supplied font
                //This is the first step to getting the Deck Label to word wrap if
                //a user supplies a sufficiently large Deck Label. What this code block
                //does is produce a box to hold the deck label whose size is derived
                //from the number of characters in a string and its' font.
                //Create new font and set the font of the Graphics2D object
                Font font = new Font("Time News Roman", Font.BOLD, 28);
                g2d.setFont(font);

                //Get metrics from font
                //Font metrics obtained
                FontMetrics metrics = g2d.getFontMetrics(font);
                //Determine the height of a line of text created using this font
                int hgt = metrics.getHeight();
                //Determine the width of a line of supplied text and make it available to the FontMetrics instance
                int adv = metrics.stringWidth(deck1.getDeckLabel());

                //Create dimensions for the deck label box accounting for some padding.
                Dimension size = new Dimension(adv + 2, hgt + 2);

                //Color deckLabelColor = new Color(252,252,135);
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.fill(new Rectangle2D.Double(80, deckLabelHeight, deckLabelWidth, 35));
                g2d.drawImage(bimage, null, 0, 0);

                g2d.setColor(Color.black);
                g2d.drawString(deck1.getDeckLabel(), (int) ((bimage.getWidth() / 2) - (size.getWidth() / 2)), 103);

                //Now that the deck label and background color of the card
                //has been set, we need we draw boxes for each player. We start by drawing
                //the player headers and then filling the box in with the appropriate labels.
                //Create new font and set the font of the Graphics2D object
                Font boxFont = new Font("Time News Roman", Font.BOLD, 64);
                g2d.setFont(boxFont);

                //Get metrics from font
                //Font metrics obtained
                metrics = g2d.getFontMetrics(boxFont);
                //Determine the height of a line of text created using this font
                hgt = metrics.getHeight();
                //Determine the width of a line of supplied text and make it available to the FontMetrics instance
                adv = metrics.stringWidth(deck1.getDeckLabel());

                //Draw N
                Color playerLabelColor = new Color(219, 219, 219);
                g2d.setColor(playerLabelColor);
                g2d.fill(new Rectangle2D.Double(x, y_PlayerCoord, widthOfCardBoxes, heightOfCardBoxes));
                g2d.drawImage(bimage, null, 0, 0);
                g2d.setColor(Color.black);
                g2d.drawString("N", (x + (widthOfCardBoxes / 2) - (metrics.stringWidth("N") / 2)), y_PlayerCoord + (75));

                //Draw E
                g2d.setColor(playerLabelColor);
                g2d.fill(new Rectangle2D.Double(x += 148, y_PlayerCoord, widthOfCardBoxes, heightOfCardBoxes));
                g2d.drawImage(bimage, null, 0, 0);
                Color eastLabelColor = new Color(63, 128, 55);
                g2d.setColor(eastLabelColor);
                g2d.drawString("E", (x + (widthOfCardBoxes / 2) - (metrics.stringWidth("E") / 2)), y_PlayerCoord + (75));

                //Draw S
                g2d.setColor(playerLabelColor);
                g2d.fill(new Rectangle2D.Double(x += 148, y_PlayerCoord, widthOfCardBoxes, heightOfCardBoxes));
                g2d.drawImage(bimage, null, 0, 0);
                g2d.setColor(Color.red);
                g2d.drawString("S", (x + (widthOfCardBoxes / 2) - (metrics.stringWidth("S") / 2)), y_PlayerCoord + (75));

                //Draw W
                g2d.setColor(playerLabelColor);
                g2d.fill(new Rectangle2D.Double(x += 148, y_PlayerCoord, widthOfCardBoxes, heightOfCardBoxes));
                g2d.drawImage(bimage, null, 0, 0);
                g2d.setColor(Color.blue);
                g2d.drawString("W", (x + (widthOfCardBoxes / 2) - (metrics.stringWidth("W") / 2)), y_PlayerCoord + (75));

                //With the player labels drawn, we need to print the location of each card.
                //To accomplish this, we'll iterate 52 times, once per card, and figure out
                //what player possessed that card for every board in the deck and
                //the identity of the dealer for that board.
                //Create a card object to work with
                Card card = deck1.cards[j];
                System.out.println(deck1.cards[j].getValue() + " " + deck1.cards[j].getSuit());

                //Create new font and set the font of the Graphics2D object
                boxFont = new Font("Time News Roman", Font.BOLD, 42);
                g2d.setFont(boxFont);

                //Get metrics from font
                //Font metrics obtained
                metrics = g2d.getFontMetrics(boxFont);
                //Determine the height of a line of text created using this font
                hgt = metrics.getHeight();
                //Determine the width of a line of supplied text and make it available to the FontMetrics instance
                adv = metrics.stringWidth(deck1.getDeckLabel());

                currentBoard = 0;
                int k = 0;
                for (int n = 0; n < 9; n++) {

                    //X Offset
                    x = 80;

                    //Need to concatenate a string that will be printed on every box.
                    String dealer = "";

                    if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("North")) {
                        dealer = "N";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("South")) {
                        dealer = "S";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("East")) {
                        dealer = "E";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("West")) {
                        dealer = "W";
                    } else {
                        System.out.println("Something went terribly wrong");
                    }

                    String s = new StringBuilder(Integer.toString(k += 1)).append("-").append("D" + dealer).toString();
                    //System.out.println(s);

                    //Lets chose the color of the box
                    if (deck1.cards[j].position[currentBoard] == 'N') {
                        g2d.setColor(Color.black);
                    } else if (deck1.cards[j].position[currentBoard] == 'E') {
                        playerLabelColor = new Color(63, 128, 55);
                        g2d.setColor(playerLabelColor);

                    } else if (deck1.cards[j].position[currentBoard] == 'S') {
                        g2d.setColor(Color.red);

                    } else if (deck1.cards[j].position[currentBoard] == 'W') {
                        g2d.setColor(Color.blue);

                    }

                    //Create box and fill
                    g2d.fill(new Rectangle2D.Double(x, y, widthOfCardBoxes, heightOfCardBoxes));
                    g2d.drawImage(bimage, null, 0, 0);
                    //Lets draw the label for the square in the first column
                    g2d.setColor(Color.white);
                    //Determine the width of a line of supplied text and make it available to the FontMetrics instance
                    adv = metrics.stringWidth(s);
                    //Determine the height of a line of text created using this font
                    hgt = metrics.getHeight();
                    g2d.drawString(s, x + ((widthOfCardBoxes - adv) / 2), y + (metrics.getHeight()));

                    currentBoard++;

                    //Need to concatenate a string that will be printed on every box.
                    dealer = "";

                    if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("North")) {
                        dealer = "N";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("South")) {
                        dealer = "S";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("East")) {
                        dealer = "E";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("West")) {
                        dealer = "W";
                    } else {
                        System.out.println("Something went terribly wrong");
                    }

                    s = new StringBuilder(Integer.toString(k += 1)).append("-").append("D" + dealer).toString();
                    //System.out.println(s);

                    //Lets chose the color of the box
                    if (deck1.cards[j].position[currentBoard] == 'N') {
                        g2d.setColor(Color.black);
                    } else if (deck1.cards[j].position[currentBoard] == 'E') {
                        playerLabelColor = new Color(63, 128, 55);
                        g2d.setColor(playerLabelColor);

                    } else if (deck1.cards[j].position[currentBoard] == 'S') {
                        g2d.setColor(Color.red);

                    } else if (deck1.cards[j].position[currentBoard] == 'W') {
                        g2d.setColor(Color.blue);

                    }

                    //Create box and fill
                    g2d.fill(new Rectangle2D.Double(x += 148, y, widthOfCardBoxes, heightOfCardBoxes));
                    g2d.drawImage(bimage, null, 0, 0);
                    //Lets draw the label for the square in the second column
                    g2d.setColor(Color.white);
                    //Determine the width of a line of supplied text and make it available to the FontMetrics instance
                    adv = metrics.stringWidth(s);
                    //Determine the height of a line of text created using this font
                    hgt = metrics.getHeight();
                    g2d.drawString(s, x + ((widthOfCardBoxes - adv) / 2), y + (metrics.getHeight()));

                    currentBoard++;

                    //Need to concatenate a string that will be printed on every box.
                    dealer = "";

                    if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("North")) {
                        dealer = "N";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("South")) {
                        dealer = "S";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("East")) {
                        dealer = "E";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("West")) {
                        dealer = "W";
                    } else {
                        System.out.println("Something went terribly wrong");
                    }

                    s = new StringBuilder(Integer.toString(k += 1)).append("-").append("D" + dealer).toString();
                    //System.out.println(s);

                    //Lets chose the color of the box
                    if (deck1.cards[j].position[currentBoard] == 'N') {
                        g2d.setColor(Color.black);
                    } else if (deck1.cards[j].position[currentBoard] == 'E') {
                        playerLabelColor = new Color(63, 128, 55);
                        g2d.setColor(playerLabelColor);

                    } else if (deck1.cards[j].position[currentBoard] == 'S') {
                        g2d.setColor(Color.red);

                    } else if (deck1.cards[j].position[currentBoard] == 'W') {
                        g2d.setColor(Color.blue);

                    }

                    //Create box and fill
                    g2d.fill(new Rectangle2D.Double(x += 148, y, widthOfCardBoxes, heightOfCardBoxes));
                    g2d.drawImage(bimage, null, 0, 0);
                    //Lets draw the label for the square in the third column
                    g2d.setColor(Color.white);
                    //Determine the width of a line of supplied text and make it available to the FontMetrics instance
                    adv = metrics.stringWidth(s);
                    //Determine the height of a line of text created using this font
                    hgt = metrics.getHeight();
                    g2d.drawString(s, x + ((widthOfCardBoxes - adv) / 2), y + (metrics.getHeight()));

                    currentBoard++;

                    //Need to concatenate a string that will be printed on every box.
                    dealer = "";

                    if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("North")) {
                        dealer = "N";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("South")) {
                        dealer = "S";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("East")) {
                        dealer = "E";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("West")) {
                        dealer = "W";
                    } else {
                        System.out.println("Something went terribly wrong");
                    }

                    s = new StringBuilder(Integer.toString(k += 1)).append("-").append("D" + dealer).toString();
                    //System.out.println(s);

                    //Lets chose the color of the box
                    if (deck1.cards[j].position[currentBoard] == 'N') {
                        g2d.setColor(Color.black);
                    } else if (deck1.cards[j].position[currentBoard] == 'E') {
                        playerLabelColor = new Color(63, 128, 55);
                        g2d.setColor(playerLabelColor);

                    } else if (deck1.cards[j].position[currentBoard] == 'S') {
                        g2d.setColor(Color.red);

                    } else if (deck1.cards[j].position[currentBoard] == 'W') {
                        g2d.setColor(Color.blue);

                    }

                    //Create box and fill
                    g2d.fill(new Rectangle2D.Double(x += 148, y, widthOfCardBoxes, heightOfCardBoxes));
                    g2d.drawImage(bimage, null, 0, 0);
                    //Lets draw the label for the square in the fourth column
                    g2d.setColor(Color.white);
                    //Determine the width of a line of supplied text and make it available to the FontMetrics instance
                    adv = metrics.stringWidth(s);
                    //Determine the height of a line of text created using this font
                    hgt = metrics.getHeight();
                    g2d.drawString(s, x + ((widthOfCardBoxes - adv) / 2), y + (metrics.getHeight()));

                    currentBoard++;
                    y += 95;

                }
                //Create the filename for the image being created
                String fileName = new StringBuilder("-" + (j + 1) + "-").append(card.value).append(card.suit).toString();

                fileName = deck1.getDeckLabel().concat(fileName).concat(".jpg");

                //Write image to a file
                try {
                    //Concatenate new file extension after iteration
                    ImageIO.write(bimage, "JPEG", new File((currentDir + "\\Images\\".concat(deck1.getDeckLabel().replaceAll("\\s+", "").concat("\\")) + fileName)));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                g2d.dispose();
            }
        }
        
        // What to do if the user's OS is a Mac OS
        else if(OS.charAt(0) == 'M' || OS.charAt(0) == 'm'){
            currentDir = System.getProperty("user.dir");

            //Create a directory to hold the output. Check to see if it exists.
            theDir = new File(currentDir + "/Images");

            // if the directory does not exist, create it
            if (!theDir.exists()) {
                System.out.println("Creating output directory.");
                boolean result = false;

                try {
                    theDir.mkdirs();
                    result = true;
                } catch (SecurityException se) {
                    //handle it
                }
                if (result) {
                    System.out.println("Output directory created");
                }
            }

            //Create a directory to hold the output. Check to see if it exists.
            deckDir = new File(currentDir + "/Images/".concat(deck1.getDeckLabel().replaceAll("\\s+", "").concat("/")));

            // if the directory does not exist, create it
            if (!deckDir.exists()) {
                System.out.println("Creating deck directory.");
                boolean result = false;

                try {
                    deckDir.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    //handle it
                }
                if (result) {
                    System.out.println("Deck directory created");
                }
            }

            // Createing "Joker" image with deck label
            BufferedImage bimage0 = new BufferedImage(747, 1122, BufferedImage.TYPE_BYTE_INDEXED);

            Graphics2D g2d0 = bimage0.createGraphics();

            g2d0.setColor(Color.white);
            g2d0.fill(new Rectangle2D.Double(0, 0, 747, 1120));
            g2d0.drawImage(bimage0, null, 0, 0);

            Font font0 = new Font("Time News Roman", Font.BOLD, 64);
            g2d0.setFont(font0);

            FontMetrics metrics0 = g2d0.getFontMetrics(font0);

            int hgt0 = metrics0.getHeight();

            int adv0 = metrics0.stringWidth(deck1.getDeckLabel());

            Dimension size0 = new Dimension(adv0 + 2, hgt0 + 2);

            g2d0.setColor(Color.LIGHT_GRAY);
            g2d0.fill(new Rectangle2D.Double(5, 5, bimage0.getWidth() - 10, bimage0.getHeight() - 10));
            g2d0.drawImage(bimage0, null, 0, 0);

            g2d0.setColor(Color.black);
            g2d0.drawString(deck1.getDeckLabel(), (int) ((bimage0.getWidth() / 2) - (size0.getWidth() / 2)), (int) ((bimage0.getHeight() / 2) - (size0.getHeight() / 2)));

            String fileName0 = "-0-Joker Image";
            fileName0 = deck1.getDeckLabel().concat(fileName0).concat(".jpg");

            try {
                ImageIO.write(bimage0, "JPEG", new File((currentDir + "/Images/".concat(deck1.getDeckLabel().replaceAll("\\s+", "").concat("/")) + fileName0)));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g2d0.dispose();

            //Go through 52 cards and create an image for every card.
            //For each card, go through the 36 boards to create a single image for that card
            //Save the image using the name of the card. 
            for (int j = 0; j < 52; j++) {
                //Set x and y offset to mark where the squares being drawn should begin.
                int x = 5;
                int y = 154;

                //Defines the height on the card at which the player headers should be
                int y_PlayerCoord = 45;

                //Used to figure out middle of the player header for accurate positioning
                int init_PlayerIconOffset = 37;

                //Create BufferedImage that will be the outputted image
                BufferedImage bimage = new BufferedImage(747, 1122, BufferedImage.TYPE_BYTE_INDEXED);

                //Create Graphics2D object to display the BufferedImage
                Graphics2D g2d = bimage.createGraphics();

                //The background of the card must ALWAYS be drawn first. Whatever the lowest
                //layer of the image is must always be drawn first and the highest level
                //be drawn last.
                //Draw white background of card
                g2d.setColor(Color.white);
                g2d.fill(new Rectangle2D.Double(0, 0, 747, 1120));
                g2d.drawImage(bimage, null, 0, 0);

                //Create Deck Label based on FontMetrics
                //FontMetrics measure how wide a String is based on a supplied font
                //This is the first step to getting the Deck Label to word wrap if
                //a user supplies a sufficiently large Deck Label. What this code block
                //does is produce a box to hold the deck label whose size is derived
                //from the number of characters in a string and its' font.
                //Create new font and set the font of the Graphics2D object
                Font font = new Font("Time News Roman", Font.BOLD, 28);
                g2d.setFont(font);

                //Get metrics from font
                //Font metrics obtained
                FontMetrics metrics = g2d.getFontMetrics(font);
                //Determine the height of a line of text created using this font
                int hgt = metrics.getHeight();
                //Determine the width of a line of supplied text and make it available to the FontMetrics instance
                int adv = metrics.stringWidth(deck1.getDeckLabel());

                //Create dimensions for the deck label box accounting for some padding.
                Dimension size = new Dimension(adv + 2, hgt + 2);

                //Color deckLabelColor = new Color(252,252,135);
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.fill(new Rectangle2D.Double(5, 5, bimage.getWidth() - 10, 35));
                g2d.drawImage(bimage, null, 0, 0);

                g2d.setColor(Color.black);
                g2d.drawString(deck1.getDeckLabel(), (int) ((bimage.getWidth() / 2) - (size.getWidth() / 2)), 32);

                //Now that the deck label and background color of the card
                //has been set, we need we draw boxes for each player. We start by drawing
                //the player headers and then filling the box in with the appropriate labels.
                //Create new font and set the font of the Graphics2D object
                Font boxFont = new Font("Time News Roman", Font.BOLD, 64);
                g2d.setFont(boxFont);

                //Get metrics from font
                //Font metrics obtained
                metrics = g2d.getFontMetrics(boxFont);
                //Determine the height of a line of text created using this font
                hgt = metrics.getHeight();
                //Determine the width of a line of supplied text and make it available to the FontMetrics instance
                adv = metrics.stringWidth(deck1.getDeckLabel());

                //Draw N
                Color playerLabelColor = new Color(252, 252, 135);
                g2d.setColor(playerLabelColor);
                g2d.fill(new Rectangle2D.Double(x, y_PlayerCoord, 180, heightOfCardBoxes));
                g2d.drawImage(bimage, null, 0, 0);
                g2d.setColor(Color.black);
                g2d.drawString("N", (x + (180 / 2) - (metrics.stringWidth("N") / 2)), y_PlayerCoord + (75));

                //Draw E
                g2d.setColor(playerLabelColor);
                g2d.fill(new Rectangle2D.Double(x += 185, y_PlayerCoord, 180, heightOfCardBoxes));
                g2d.drawImage(bimage, null, 0, 0);
                Color eastLabelColor = new Color(63, 128, 55);
                g2d.setColor(eastLabelColor);
                g2d.drawString("E", (x + (180 / 2) - (metrics.stringWidth("E") / 2)), y_PlayerCoord + (75));

                //Draw S
                g2d.setColor(playerLabelColor);
                g2d.fill(new Rectangle2D.Double(x += 185, y_PlayerCoord, 180, heightOfCardBoxes));
                g2d.drawImage(bimage, null, 0, 0);
                g2d.setColor(Color.red);
                g2d.drawString("S", (x + (180 / 2) - (metrics.stringWidth("S") / 2)), y_PlayerCoord + (75));

                //Draw W
                g2d.setColor(playerLabelColor);
                g2d.fill(new Rectangle2D.Double(x += 185, y_PlayerCoord, 180, heightOfCardBoxes));
                g2d.drawImage(bimage, null, 0, 0);
                g2d.setColor(Color.blue);
                g2d.drawString("W", (x + (180 / 2) - (metrics.stringWidth("W") / 2)), y_PlayerCoord + (75));

                //With the player labels drawn, we need to print the location of each card.
                //To accomplish this, we'll iterate 52 times, once per card, and figure out
                //what player possessed that card for every board in the deck and
                //the identity of the dealer for that board.
                //Create a card object to work with
                Card card = deck1.cards[j];
                System.out.println(deck1.cards[j].getValue() + " " + deck1.cards[j].getSuit());

                //Create new font and set the font of the Graphics2D object
                boxFont = new Font("Time News Roman", Font.BOLD, 48);
                g2d.setFont(boxFont);

                //Get metrics from font
                //Font metrics obtained
                metrics = g2d.getFontMetrics(boxFont);
                //Determine the height of a line of text created using this font
                hgt = metrics.getHeight();
                //Determine the width of a line of supplied text and make it available to the FontMetrics instance
                adv = metrics.stringWidth(deck1.getDeckLabel());

                currentBoard = 0;
                int k = 0;
                for (int n = 0; n < 9; n++) {

                    //X Offset
                    x = 5;

                    //Need to concatenate a string that will be printed on every box.
                    String dealer = "";

                    if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("North")) {
                        dealer = "N";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("South")) {
                        dealer = "S";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("East")) {
                        dealer = "E";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("West")) {
                        dealer = "W";
                    } else {
                        System.out.println("Something went terribly wrong");
                    }

                    String s = new StringBuilder(Integer.toString(k += 1)).append("-").append("D" + dealer).toString();
                    //System.out.println(s);

                    //Lets chose the color of the box
                    if (deck1.cards[j].position[currentBoard] == 'N') {
                        g2d.setColor(Color.black);
                    } else if (deck1.cards[j].position[currentBoard] == 'E') {
                        playerLabelColor = new Color(63, 128, 55);
                        g2d.setColor(playerLabelColor);

                    } else if (deck1.cards[j].position[currentBoard] == 'S') {
                        g2d.setColor(Color.red);

                    } else if (deck1.cards[j].position[currentBoard] == 'W') {
                        g2d.setColor(Color.blue);

                    }

                    //Create box and fill
                    g2d.fill(new Rectangle2D.Double(x, y, 180, heightOfCardBoxes));
                    g2d.drawImage(bimage, null, 0, 0);
                    //Lets draw the label for the square in the first column
                    g2d.setColor(Color.white);
                    //Determine the width of a line of supplied text and make it available to the FontMetrics instance
                    adv = metrics.stringWidth(s);
                    //Determine the height of a line of text created using this font
                    hgt = metrics.getHeight();
                    g2d.drawString(s, x + ((180 - adv) / 2), y + (metrics.getHeight()));

                    currentBoard++;

                    //Need to concatenate a string that will be printed on every box.
                    dealer = "";

                    if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("North")) {
                        dealer = "N";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("South")) {
                        dealer = "S";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("East")) {
                        dealer = "E";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("West")) {
                        dealer = "W";
                    } else {
                        System.out.println("Something went terribly wrong");
                    }

                    s = new StringBuilder(Integer.toString(k += 1)).append("-").append("D" + dealer).toString();
                    //System.out.println(s);

                    //Lets chose the color of the box
                    if (deck1.cards[j].position[currentBoard] == 'N') {
                        g2d.setColor(Color.black);
                    } else if (deck1.cards[j].position[currentBoard] == 'E') {
                        playerLabelColor = new Color(63, 128, 55);
                        g2d.setColor(playerLabelColor);

                    } else if (deck1.cards[j].position[currentBoard] == 'S') {
                        g2d.setColor(Color.red);

                    } else if (deck1.cards[j].position[currentBoard] == 'W') {
                        g2d.setColor(Color.blue);

                    }

                    //Create box and fill
                    g2d.fill(new Rectangle2D.Double(x += 185, y, 180, heightOfCardBoxes));
                    g2d.drawImage(bimage, null, 0, 0);
                    //Lets draw the label for the square in the second column
                    g2d.setColor(Color.white);
                    //Determine the width of a line of supplied text and make it available to the FontMetrics instance
                    adv = metrics.stringWidth(s);
                    //Determine the height of a line of text created using this font
                    hgt = metrics.getHeight();
                    g2d.drawString(s, x + ((180 - adv) / 2), y + (metrics.getHeight()));

                    currentBoard++;

                    //Need to concatenate a string that will be printed on every box.
                    dealer = "";

                    if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("North")) {
                        dealer = "N";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("South")) {
                        dealer = "S";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("East")) {
                        dealer = "E";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("West")) {
                        dealer = "W";
                    } else {
                        System.out.println("Something went terribly wrong");
                    }

                    s = new StringBuilder(Integer.toString(k += 1)).append("-").append("D" + dealer).toString();
                    //System.out.println(s);

                    //Lets chose the color of the box
                    if (deck1.cards[j].position[currentBoard] == 'N') {
                        g2d.setColor(Color.black);
                    } else if (deck1.cards[j].position[currentBoard] == 'E') {
                        playerLabelColor = new Color(63, 128, 55);
                        g2d.setColor(playerLabelColor);

                    } else if (deck1.cards[j].position[currentBoard] == 'S') {
                        g2d.setColor(Color.red);

                    } else if (deck1.cards[j].position[currentBoard] == 'W') {
                        g2d.setColor(Color.blue);

                    }

                    //Create box and fill
                    g2d.fill(new Rectangle2D.Double(x += 185, y, 180, heightOfCardBoxes));
                    g2d.drawImage(bimage, null, 0, 0);
                    //Lets draw the label for the square in the third column
                    g2d.setColor(Color.white);
                    //Determine the width of a line of supplied text and make it available to the FontMetrics instance
                    adv = metrics.stringWidth(s);
                    //Determine the height of a line of text created using this font
                    hgt = metrics.getHeight();
                    g2d.drawString(s, x + ((180 - adv) / 2), y + (metrics.getHeight()));

                    currentBoard++;

                    //Need to concatenate a string that will be printed on every box.
                    dealer = "";

                    if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("North")) {
                        dealer = "N";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("South")) {
                        dealer = "S";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("East")) {
                        dealer = "E";
                    } else if (deck1.boards[currentBoard].getDealer().equalsIgnoreCase("West")) {
                        dealer = "W";
                    } else {
                        System.out.println("Something went terribly wrong");
                    }

                    s = new StringBuilder(Integer.toString(k += 1)).append("-").append("D" + dealer).toString();
                    //System.out.println(s);

                    //Lets chose the color of the box
                    if (deck1.cards[j].position[currentBoard] == 'N') {
                        g2d.setColor(Color.black);
                    } else if (deck1.cards[j].position[currentBoard] == 'E') {
                        playerLabelColor = new Color(63, 128, 55);
                        g2d.setColor(playerLabelColor);

                    } else if (deck1.cards[j].position[currentBoard] == 'S') {
                        g2d.setColor(Color.red);

                    } else if (deck1.cards[j].position[currentBoard] == 'W') {
                        g2d.setColor(Color.blue);

                    }

                    //Create box and fill
                    g2d.fill(new Rectangle2D.Double(x += 185, y, 180, heightOfCardBoxes));
                    g2d.drawImage(bimage, null, 0, 0);
                    //Lets draw the label for the square in the fourth column
                    g2d.setColor(Color.white);
                    //Determine the width of a line of supplied text and make it available to the FontMetrics instance
                    adv = metrics.stringWidth(s);
                    //Determine the height of a line of text created using this font
                    hgt = metrics.getHeight();
                    g2d.drawString(s, x + ((180 - adv) / 2), y + (metrics.getHeight()));

                    currentBoard++;
                    y += 107;

                }
                //Create the filename for the image being created
                String fileName = new StringBuilder("-" + (j + 1) + "-").append(card.value).append(card.suit).toString();

                fileName = deck1.getDeckLabel().concat(fileName).concat(".jpg");
                
                
                //Write image to a file
                try {
                    //Concatenate new file extension after iteration
                    ImageIO.write(bimage, "JPEG", new File((currentDir + "/Images/".concat(deck1.getDeckLabel().replaceAll("\\s+", "").concat("/")) + fileName)));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                g2d.dispose();
            }            
        }
    }
}
