/*
 v6.0

 This class builds the GUI and handles all user input.
 Also holds the main method.

 */
import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainScreen extends javax.swing.JFrame {

    public String deckTitle, boardNum, boardTitle, dealer, notes;
    public int boardCount = 0;
    static ArrayList<Deck> decks = new ArrayList<>();

    private static String northSpades = "";
    private static String northHearts = "";
    private static String northDiamonds = "";
    private static String northClubs = "";
    private static String southSpades = "";
    private static String southHearts = "";
    private static String southDiamonds = "";
    private static String southClubs = "";
    private static String eastSpades = "";
    private static String eastHearts = "";
    private static String eastDiamonds = "";
    private static String eastClubs = "";
    private static String westSpades = "";
    private static String westHearts = "";
    private static String westDiamonds = "";
    private static String westClubs = "";

    /**
     * The Variable names used for the text fields and labels are shorthand. In
     * any of these variables, the one or two letter code corresponds to the
     * following.
     *
     * ns = North Spades nh = North Hearts nd = North Diamonds nc = North Clubs
     * es = East Spades eh = East Hearts ed = East Diamonds ec = East Clubs ss =
     * South Spades sh = South Hearts sd = South Diamonds sc = South Clubs ws =
     * West Spades wh = West Hearts wd = West Diamonds wc = West Clubs bn =
     * Board Number bt = Board Titles d = Dealer
     *
     */
    //Constructor for MainScreen
    public MainScreen() {
        initComponents();
        this.setVisible(true);
    }

    //Simple method to clear a text field.
    private void clear(JTextField field) {
        field.setText("");
    }

    //A single method to clear all text fields.
    public void clearFields() {
        clear(nsField);
        clear(nhField);
        clear(ndField);
        clear(ncField);
        clear(esField);
        clear(ehField);
        clear(edField);
        clear(ecField);
        clear(ssField);
        clear(shField);
        clear(sdField);
        clear(scField);
        clear(wsField);
        clear(whField);
        clear(wdField);
        clear(wcField);
        clear(bnField);
        btField.setText("");
        NotesText.setText("");
    }

    public void setEditableTrue() {
        bnField.setEditable(true);
        btField.setEditable(true);
        nsField.setEditable(true);
        nhField.setEditable(true);
        ndField.setEditable(true);
        ncField.setEditable(true);
        esField.setEditable(true);
        ehField.setEditable(true);
        edField.setEditable(true);
        ecField.setEditable(true);
        ssField.setEditable(true);
        shField.setEditable(true);
        sdField.setEditable(true);
        scField.setEditable(true);
        wsField.setEditable(true);
        whField.setEditable(true);
        wdField.setEditable(true);
        wcField.setEditable(true);
        NotesText.setEditable(true);
    }

    //A simple method to clear all variables
    public void initializeString() {
        northSpades = null;
        northHearts = null;
        northDiamonds = null;
        northClubs = null;
        southSpades = null;
        southHearts = null;
        southDiamonds = null;
        southClubs = null;
        eastSpades = null;
        eastHearts = null;
        eastDiamonds = null;
        eastClubs = null;
        westSpades = null;
        westHearts = null;
        westDiamonds = null;
        westClubs = null;
    }

    //A method that clears empty elements from a String array
    public String[] cleanArray(String[] v) {
        int r, w;
        final int n = r = w = v.length;
        while (r > 0) {
            final String s = v[--r];
            if (!s.equals("")) {
                v[--w] = s;
            }
        }

        return Arrays.copyOfRange(v, w, n);
    }

    //A method that sorts the hands in decending order from Ace - Two
    public String[] sort(String[] a) {
        String[] temp = new String[a.length];
        int current = 0;
        boolean found = false;

        for (int i = 0; i < a.length; i++) {
            if (a[i].charAt(0) == 'A') {
                found = true;
            }
            if (found) {
                found = false;
                temp[current] = a[i];
                current++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].charAt(0) == 'K') {
                found = true;
            }
            if (found) {
                found = false;
                temp[current] = a[i];
                current++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].charAt(0) == 'Q') {
                found = true;
            }
            if (found) {
                found = false;
                temp[current] = a[i];
                current++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].charAt(0) == 'J') {
                found = true;
            }
            if (found) {
                found = false;
                temp[current] = a[i];
                current++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].charAt(0) == 'T') {
                found = true;
            }
            if (found) {
                found = false;
                temp[current] = a[i];
                current++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].charAt(0) == '9') {
                found = true;
            }
            if (found) {
                found = false;
                temp[current] = a[i];
                current++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].charAt(0) == '8') {
                found = true;
            }
            if (found) {
                found = false;
                temp[current] = a[i];
                current++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].charAt(0) == '7') {
                found = true;
            }
            if (found) {
                found = false;
                temp[current] = a[i];
                current++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].charAt(0) == '6') {
                found = true;
            }
            if (found) {
                found = false;
                temp[current] = a[i];
                current++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].charAt(0) == '5') {
                found = true;
            }
            if (found) {
                found = false;
                temp[current] = a[i];
                current++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].charAt(0) == '4') {
                found = true;
            }
            if (found) {
                found = false;
                temp[current] = a[i];
                current++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].charAt(0) == '3') {
                found = true;
            }
            if (found) {
                found = false;
                temp[current] = a[i];
                current++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].charAt(0) == '2') {
                found = true;
            }
            if (found) {
                found = false;
                temp[current] = a[i];
                current++;
            }
        }

        return temp;
    }

    //Creates a new deck from user inputted label. Prepares program for data acception.
    public void newDeckButton() {
        String deckLabel = JOptionPane.showInputDialog("Enter Deck Label (Must be between 1 and 30 characters): ");

        if (deckLabel != null) {
            if (deckLabel.length() < 1 || deckLabel.length() > 30) {
                JOptionPane.showMessageDialog(null, "Deck Label must be between 1 and 30 characters!");
                newDeckButton();
            } else if (deckLabel.contains("\\") || deckLabel.contains("/") || deckLabel.contains(":") || deckLabel.contains("*") || deckLabel.contains("?") || deckLabel.contains("\"")
                    || deckLabel.contains("<") || deckLabel.contains(">") || deckLabel.contains("|")) {
                JOptionPane.showMessageDialog(null, "Deck Label cannot contain special characters ( \\ / : * ? \" < > | )");
                newDeckButton();
            } else {
                boolean match = false;

                for (int i = 0; i < decks.size(); i++) {
                    if (deckLabel.equals(decks.get(i).getDeckLabel())) {
                        match = true;
                    }
                }

                if (match) {
                    JOptionPane.showMessageDialog(null, "Deck with that label already exists!");
                    newDeckButton();
                } else {
                    createNewDeck(deckLabel);

                    boardCount = 0;

                    dtField.setText(deckLabel);
                    bcField.setText("Board Count: \n" + (boardCount++) + " / 36");

                    clearFields();

                    String[] temp = new String[decks.size()];

                    for (int i = 0; i < decks.size(); i++) {
                        temp[i] = decks.get(i).getDeckLabel();
                    }

                    initializeString();

                    OpenDeckMenu.setModel(new javax.swing.DefaultComboBoxModel(temp));
                    DeleteDeckMenu.setModel(new javax.swing.DefaultComboBoxModel(temp));

                    if (!OpenDeckMenu.getSelectedItem().toString().equals(dtField.getText())) {
                        bnField.setEditable(false);
                        btField.setEditable(false);
                        dField.setEditable(false);
                        nsField.setEditable(false);
                        nhField.setEditable(false);
                        ndField.setEditable(false);
                        ncField.setEditable(false);
                        esField.setEditable(false);
                        ehField.setEditable(false);
                        edField.setEditable(false);
                        ecField.setEditable(false);
                        ssField.setEditable(false);
                        shField.setEditable(false);
                        sdField.setEditable(false);
                        scField.setEditable(false);
                        wsField.setEditable(false);
                        whField.setEditable(false);
                        wdField.setEditable(false);
                        wcField.setEditable(false);
                    }
                }
            }
        }
    }

    //Creates images and PDF from user inputted deck/boards
    public void createOutput() {
        if (decks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Must create a Deck!");
        } else {
            String[] temp = new String[decks.size()];

            for (int i = 0; i < decks.size(); i++) {
                temp[i] = decks.get(i).getDeckLabel();
            }

            String printDeck = (String) JOptionPane.showInputDialog(Panel1, "Select Deck: ", "Print", JOptionPane.PLAIN_MESSAGE, null, temp, temp[0]);

            if (printDeck != null) {
                int num = 0;

                for (int i = 0; i < decks.size(); i++) {
                    if (printDeck.equals(decks.get(i).getDeckLabel())) {
                        num = i;
                    }
                }

                if (decks.get(num).getBoardCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Deck must contain at least one board!");
                } else {
                    if (decks.get(num).getBoardCount() != 36) {
                        JOptionPane.showMessageDialog(null, "Cannot build images from deck with less than 36 boards!");
                    } else {
                        BridgePrintImage.printCard(decks.get(num));
                        if (System.getProperty("os.name").charAt(0) == 'W' || System.getProperty("os.name").charAt(0) == 'w') {
                            JOptionPane.showMessageDialog(null, "Images created! \n"
                                    + "Images can be found at " + System.getProperty("user.dir") + "\\Images");
                        } else if (System.getProperty("os.name").charAt(0) == 'M' || System.getProperty("os.name").charAt(0) == 'm') {
                            JOptionPane.showMessageDialog(null, "Images created! \n"
                                    + "Images can be found at " + System.getProperty("user.dir") + "/Images");
                        } else {
                            JOptionPane.showMessageDialog(null, "OS Not Supported");
                        }
                    }
                    try {
                        new CreatePDF(decks.get(num));
                    } catch (DocumentException | IOException | NullPointerException ex) {
                        Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    //Method to create actual Deck Object to store
    public void createNewDeck(String label) {
        Deck deck = new Deck(label);
        decks.add(deck);
    }

    //Takes all user data and stores it accordingly
    public void save(String deckTitle, int boardNum, String boardTitle, String dealer, ArrayList<String> handList, String notes) {
        for (int i = 0; i < decks.size(); i++) {
            if (deckTitle.compareTo(decks.get(i).deckLabel) == 0) {
                decks.get(i).addBoard(boardNum, boardTitle, dealer, handList, notes);
            }
        }
    }

    //Writes all deck objects to Files for permanent storage
    public void saveDeckObject(Deck deck1) throws IOException {
        //If OS is Windows
        if (System.getProperty("os.name").charAt(0) == 'W' || System.getProperty("os.name").charAt(0) == 'w') {
            String currentDir = System.getProperty("user.dir");

            //Create a directory to hold the object files. Check to see if it exists.
            File theDir = new File(currentDir + "\\Deck Files");

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

            ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(theDir + "\\" + deck1.getDeckLabel()));
            in.writeObject(deck1);
        } //If OS is Mac
        else if (System.getProperty("os.name").charAt(0) == 'M' || System.getProperty("os.name").charAt(0) == 'm') {
            String currentDir = System.getProperty("user.dir");
            //Create a directory to hold the object files. Check to see if it exists.
            File theDir = new File(currentDir + "/Deck Files");

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

            ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(theDir + "/" + deck1.getDeckLabel()));
            in.writeObject(deck1);
        }
    }

    //Reads all deck objects from Files to reload previously entered decks.
    public static void loadDeckObjects() throws IOException, ClassNotFoundException {

        //If OS is Windows
        if (System.getProperty("os.name").charAt(0) == 'W' || System.getProperty("os.name").charAt(0) == 'w') {

            String currentDir = System.getProperty("user.dir");

            //Create a directory to hold the object files. Check to see if it exists.
            File theDir = new File(currentDir + "\\Deck Files");

            if (theDir.exists()) {
                ArrayList<File> objects = new ArrayList<>(Arrays.asList(theDir.listFiles()));

                Deck[] deckList = new Deck[objects.size()];

                for (int i = 0; i < objects.size(); i++) {
                    ObjectInputStream object = new ObjectInputStream(new FileInputStream(objects.get(i)));
                    Deck d = (Deck) object.readObject();

                    deckList[i] = d;
                }

                String[] deckNames = new String[deckList.length];

                for (int i = 0; i < deckNames.length; i++) {
                    deckNames[i] = deckList[i].getDeckLabel();
                }

                decks.addAll(Arrays.asList(deckList));

                OpenDeckMenu.setModel(new javax.swing.DefaultComboBoxModel(deckNames));
                DeleteDeckMenu.setModel(new javax.swing.DefaultComboBoxModel(deckNames));
            }
        } //If OS is Mac
        else if (System.getProperty("os.name").charAt(0) == 'M' || System.getProperty("os.name").charAt(0) == 'm') {

            String currentDir = System.getProperty("user.dir");

            //Create a directory to hold the object files. Check to see if it exists.
            File theDir = new File(currentDir + "/Deck Files");

            if (theDir.exists()) {
                ArrayList<File> objects = new ArrayList<>(Arrays.asList(theDir.listFiles()));

                Deck[] deckList = new Deck[objects.size()];

                for (int i = 0; i < objects.size(); i++) {
                    if (!objects.get(i).toString().contains(".DS_Store")) {
                        ObjectInputStream object = new ObjectInputStream(new FileInputStream(objects.get(i)));
                        Deck d = (Deck) object.readObject();
                        deckList[i] = d;
                    }
                }

                ArrayList<Deck> deckTemp = new ArrayList<>();

                for (int i = 0; i < deckList.length; i++) {
                    if (deckList[i] != null) {
                        deckTemp.add(deckList[i]);
                    }
                }

                deckList = new Deck[deckTemp.size()];

                for (int i = 0; i < deckList.length; i++) {
                    deckList[i] = deckTemp.get(i);
                }

                String[] deckNames = new String[deckList.length];

                for (int i = 0; i < deckNames.length; i++) {
                    deckNames[i] = deckList[i].getDeckLabel();
                }

                decks.addAll(Arrays.asList(deckList));

                OpenDeckMenu.setModel(new javax.swing.DefaultComboBoxModel(deckNames));
                DeleteDeckMenu.setModel(new javax.swing.DefaultComboBoxModel(deckNames));
            }
        }
    }

    //Populates all text fields with previously entered data
    public void loadBoard(String deckTitle, int boardNum) {
        Deck deck = null;

        for (int i = 0; i < decks.size(); i++) {
            if (deckTitle.compareTo(decks.get(i).deckLabel) == 0) {
                deck = decks.get(i);
            }
        }

        boardTitle = deck.boards[boardNum - 1].getLabel();
        dealer = deck.boards[boardNum - 1].getDealer();
        notes = deck.boards[boardNum - 1].getNotes();
        ArrayList<String> hands = deck.boards[boardNum - 1].getHands();

        String northHand = hands.get(0);
        String southHand = hands.get(1);
        String eastHand = hands.get(2);
        String westHand = hands.get(3);

        String[] northArray = northHand.split(", ");
        String[] southArray = southHand.split(", ");
        String[] eastArray = eastHand.split(", ");
        String[] westArray = westHand.split(", ");

        northArray = sort(northArray);
        southArray = sort(southArray);
        eastArray = sort(eastArray);
        westArray = sort(westArray);

        northSpades = northHearts = northDiamonds = northClubs = southSpades = southHearts = southDiamonds = southClubs = null;
        eastSpades = eastHearts = eastDiamonds = eastClubs = westSpades = westHearts = westDiamonds = westClubs = null;

        for (int i = 0; i < northArray.length; i++) {
            String[] temp = northArray[i].split("-");
            switch (temp[1]) {
                case "S":
                    northSpades = northSpades + ", " + temp[0];
                    break;
                case "H":
                    northHearts = northHearts + ", " + temp[0];
                    break;
                case "D":
                    northDiamonds = northDiamonds + ", " + temp[0];
                    break;
                case "C":
                    northClubs = northClubs + ", " + temp[0];
                    break;
                default:
                    System.out.println("Load Error");
                    break;
            }
        }

        for (int i = 0; i < southArray.length; i++) {
            String[] temp = southArray[i].split("-");
            switch (temp[1]) {
                case "S":
                    southSpades = southSpades + ", " + temp[0];
                    break;
                case "H":
                    southHearts = southHearts + ", " + temp[0];
                    break;
                case "D":
                    southDiamonds = southDiamonds + ", " + temp[0];
                    break;
                case "C":
                    southClubs = southClubs + ", " + temp[0];
                    break;
                default:
                    System.out.println("Load Error");
                    break;
            }
        }

        for (int i = 0; i < eastArray.length; i++) {
            String[] temp = eastArray[i].split("-");
            switch (temp[1]) {
                case "S":
                    eastSpades = eastSpades + ", " + temp[0];
                    break;
                case "H":
                    eastHearts = eastHearts + ", " + temp[0];
                    break;
                case "D":
                    eastDiamonds = eastDiamonds + ", " + temp[0];
                    break;
                case "C":
                    eastClubs = eastClubs + ", " + temp[0];
                    break;
                default:
                    System.out.println("Load Error");
                    break;
            }
        }

        for (int i = 0; i < westArray.length; i++) {
            String[] temp = westArray[i].split("-");
            switch (temp[1]) {
                case "S":
                    westSpades = westSpades + ", " + temp[0];
                    break;
                case "H":
                    westHearts = westHearts + ", " + temp[0];
                    break;
                case "D":
                    westDiamonds = westDiamonds + ", " + temp[0];
                    break;
                case "C":
                    westClubs = westClubs + ", " + temp[0];
                    break;
                default:
                    System.out.println("Load Error");
                    break;
            }
        }

        if (northSpades != null) {
            northSpades = northSpades.substring(6);
        }
        if (northHearts != null) {
            northHearts = northHearts.substring(6);
        }
        if (northDiamonds != null) {
            northDiamonds = northDiamonds.substring(6);
        }
        if (northClubs != null) {
            northClubs = northClubs.substring(6);
        }

        if (southSpades != null) {
            southSpades = southSpades.substring(6);
        }
        if (southHearts != null) {
            southHearts = southHearts.substring(6);
        }
        if (southDiamonds != null) {
            southDiamonds = southDiamonds.substring(6);
        }
        if (southClubs != null) {
            southClubs = southClubs.substring(6);
        }

        if (eastSpades != null) {
            eastSpades = eastSpades.substring(6);
        }
        if (eastHearts != null) {
            eastHearts = eastHearts.substring(6);
        }
        if (eastDiamonds != null) {
            eastDiamonds = eastDiamonds.substring(6);
        }
        if (eastClubs != null) {
            eastClubs = eastClubs.substring(6);
        }
        if (westSpades != null) {
            westSpades = westSpades.substring(6);
        }
        if (westHearts != null) {
            westHearts = westHearts.substring(6);
        }
        if (westDiamonds != null) {
            westDiamonds = westDiamonds.substring(6);
        }
        if (westClubs != null) {
            westClubs = westClubs.substring(6);
        }

        btField.setText(boardTitle);
        bnField.setText(Integer.toString(boardNum));
        NotesText.setText(notes);
        
        if (dealer.equalsIgnoreCase("North")) {
            dField.setSelectedIndex(1);
        } else if (dealer.equalsIgnoreCase("South")) {
            dField.setSelectedIndex(2);
        } else if (dealer.equalsIgnoreCase("East")) {
            dField.setSelectedIndex(3);
        } else if (dealer.equalsIgnoreCase("West")) {
            dField.setSelectedIndex(4);
        } else {
            dField.setSelectedIndex(0);
        }
        
        setText(northSpades, nsField);
        setText(northHearts, nhField);
        setText(northDiamonds, ndField);
        setText(northClubs, ncField);
        setText(southSpades, ssField);
        setText(southHearts, shField);
        setText(southDiamonds, sdField);
        setText(southClubs, scField);
        setText(eastSpades, esField);
        setText(eastHearts, ehField);
        setText(eastDiamonds, edField);
        setText(eastClubs, ecField);
        setText(westSpades, wsField);
        setText(westHearts, whField);
        setText(westDiamonds, wdField);
        setText(westClubs, wcField);

    }

    public void setText(String s, JTextField t) {
        if (s == null) {
            t.setText(s);
        } else {
            t.setText(s.replaceAll(", ", ""));
        }
    }

    //Removes a board from the deck
    public void deleteBoard(String deckTitle, int boardNum) {
        Deck deck = null;

        for (int i = 0; i < decks.size(); i++) {
            if (deckTitle.compareTo(decks.get(i).deckLabel) == 0) {
                deck = decks.get(i);
            }
        }

        deck.removeBoard(boardNum);
    }

    //Checks for legal format for all user input
    public void formatCheck() {
        String deck = dtField.getText();
        boardNum = bnField.getText();
        
        if(btField.getText().isEmpty()){
            boardTitle = "Board " + boardNum;
        }
        else{
            boardTitle = btField.getText();
        }

        if (dField.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Must select a dealer!");
        } else {
            dealer = (String) dField.getSelectedItem();
        }

        northSpades = nsField.getText().toUpperCase().replaceAll("\\s", "");
        northHearts = nhField.getText().toUpperCase().replaceAll("\\s", "");
        northDiamonds = ndField.getText().toUpperCase().replaceAll("\\s", "");
        northClubs = ncField.getText().toUpperCase().replaceAll("\\s", "");
        southSpades = ssField.getText().toUpperCase().replaceAll("\\s", "");
        southHearts = shField.getText().toUpperCase().replaceAll("\\s", "");
        southDiamonds = sdField.getText().toUpperCase().replaceAll("\\s", "");
        southClubs = scField.getText().toUpperCase().replaceAll("\\s", "");
        eastSpades = esField.getText().toUpperCase().replaceAll("\\s", "");
        eastHearts = ehField.getText().toUpperCase().replaceAll("\\s", "");
        eastDiamonds = edField.getText().toUpperCase().replaceAll("\\s", "");
        eastClubs = ecField.getText().toUpperCase().replaceAll("\\s", "");
        westSpades = wsField.getText().toUpperCase().replaceAll("\\s", "");
        westHearts = whField.getText().toUpperCase().replaceAll("\\s", "");
        westDiamonds = wdField.getText().toUpperCase().replaceAll("\\s", "");
        westClubs = wcField.getText().toUpperCase().replaceAll("\\s", "");

        northSpades = northSpades.replaceAll(".(?=.)", "$0, ");
        northHearts = northHearts.replaceAll(".(?=.)", "$0, ");
        northDiamonds = northDiamonds.replaceAll(".(?=.)", "$0, ");
        northClubs = northClubs.replaceAll(".(?=.)", "$0, ");
        southSpades = southSpades.replaceAll(".(?=.)", "$0, ");
        southHearts = southHearts.replaceAll(".(?=.)", "$0, ");
        southDiamonds = southDiamonds.replaceAll(".(?=.)", "$0, ");
        southClubs = southClubs.replaceAll(".(?=.)", "$0, ");
        eastSpades = eastSpades.replaceAll(".(?=.)", "$0, ");
        eastHearts = eastHearts.replaceAll(".(?=.)", "$0, ");
        eastDiamonds = eastDiamonds.replaceAll(".(?=.)", "$0, ");
        eastClubs = eastClubs.replaceAll(".(?=.)", "$0, ");
        westSpades = westSpades.replaceAll(".(?=.)", "$0, ");
        westHearts = westHearts.replaceAll(".(?=.)", "$0, ");
        westDiamonds = westDiamonds.replaceAll(".(?=.)", "$0, ");
        westClubs = westClubs.replaceAll(".(?=.)", "$0, ");

        ArrayList<String> handList = new ArrayList<>();
        handList.add(northSpades);
        handList.add(northHearts);
        handList.add(northDiamonds);
        handList.add(northClubs);
        handList.add(southSpades);
        handList.add(southHearts);
        handList.add(southDiamonds);
        handList.add(southClubs);
        handList.add(eastSpades);
        handList.add(eastHearts);
        handList.add(eastDiamonds);
        handList.add(eastClubs);
        handList.add(westSpades);
        handList.add(westHearts);
        handList.add(westDiamonds);
        handList.add(westClubs);

        try {
            int bNum = Integer.parseInt(boardNum);

            if (bNum < 1 || bNum > 36) {
                throw new BoardNumberException();
            }

            if (dealer.equalsIgnoreCase("north")) {
                dealer = "North";
            } else if (dealer.equalsIgnoreCase("south")) {
                dealer = "South";
            } else if (dealer.equalsIgnoreCase("east")) {
                dealer = "East";
            } else if (dealer.equalsIgnoreCase("west")) {
                dealer = "West";
            } else {
                System.out.println("Something broke");
            }

            for (int i = 0; i < handList.size(); i++) {
                String handPart = handList.get(i);
                String[] temp = handPart.split(", ");

                for (int j = 0; j < temp.length; j++) {
                    if (!temp[j].isEmpty()) {
                        if (!temp[j].equals("2") && !temp[j].equals("3") && !temp[j].equals("4") && !temp[j].equals("5")
                                && !temp[j].equals("6") && !temp[j].equals("7") && !temp[j].equals("8") && !temp[j].equals("9")
                                && !temp[j].equals("T") && !temp[j].equals("J") && !temp[j].equals("Q") && !temp[j].equals("K")
                                && !temp[j].equals("A")) {
                            throw new HandException(temp[j].charAt(0));
                        }
                    }
                }
            }

            
            ArrayList<String> list = new ArrayList<>();
            
            list.add(northSpades + ", " + northHearts + ", " + northDiamonds + ", " + northClubs);
            list.add(southSpades + ", " + southHearts + ", " + southDiamonds + ", " + southClubs);
            list.add(eastSpades + ", " + eastHearts + ", " + eastDiamonds + ", " + eastClubs);
            list.add(westSpades + ", " + westHearts + ", " + westDiamonds + ", " + westClubs);

            String spades = northSpades + ", " + southSpades + ", " + eastSpades + ", " + westSpades;
            String[] z = spades.split(", ");
            ArrayList<String> spadesCheckList = new ArrayList<>(Arrays.asList(z));
            spadesCheckList.removeAll(Arrays.asList(""));

            String hearts = northHearts + ", " + southHearts + ", " + eastHearts + ", " + westHearts;
            z = hearts.split(", ");
            ArrayList<String> heartsCheckList = new ArrayList<>(Arrays.asList(z));
            heartsCheckList.removeAll(Arrays.asList(""));

            String diamonds = northDiamonds + ", " + southDiamonds + ", " + eastDiamonds + ", " + westDiamonds;
            z = diamonds.split(", ");
            ArrayList<String> diamondsCheckList = new ArrayList<>(Arrays.asList(z));
            diamondsCheckList.removeAll(Arrays.asList(""));

            String clubs = northClubs + ", " + southClubs + ", " + eastClubs + ", " + westClubs;
            z = clubs.split(", ");
            ArrayList<String> clubsCheckList = new ArrayList<>(Arrays.asList(z));
            clubsCheckList.removeAll(Arrays.asList(""));

            ArrayList<String> spadesList = new ArrayList<>(Arrays.asList("A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2"));
            ArrayList<String> heartsList = new ArrayList<>(Arrays.asList("A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2"));
            ArrayList<String> diamondsList = new ArrayList<>(Arrays.asList("A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2"));
            ArrayList<String> clubsList = new ArrayList<>(Arrays.asList("A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2"));

            spadesList.removeAll(spadesCheckList);
            heartsList.removeAll(heartsCheckList);
            diamondsList.removeAll(diamondsCheckList);
            clubsList.removeAll(clubsCheckList);

            boolean error = false;
            boolean tooManyCardsError = false;
            
            ArrayList<String> hands = new ArrayList<>();

            for (int i = 0; i < list.size(); i++) {
                String[] temp3 = list.get(i).split(", ");
                temp3 = cleanArray(temp3);
                if (temp3.length < 13) {
                    if (i == 0) {
                        error = true;
                        hands.add("North");
                    } else if (i == 1) {
                        error = true;
                        hands.add("South");

                    } else if (i == 2) {
                        error = true;
                        hands.add("East");

                    } else {
                        error = true;
                        hands.add("West");

                    }
                }
                
                if (temp3.length > 13) {
                    if (i == 0) {
                        tooManyCardsError = true;
                        hands.add("North");
                    } else if (i == 1) {
                    	tooManyCardsError = true;
                        hands.add("South");

                    } else if (i == 2) {
                    	tooManyCardsError = true;
                        hands.add("East");

                    } else {
                    	tooManyCardsError = true;
                        hands.add("West");

                    }
                }

            }

            
            if (error) {
                error = false;
                throw new HandException("The following hands do not have 13 cards: \n"
                        + hands.toString().replace("[", "").replace("]", "") + "\n\n"
                        + "The following cards are missing:\n"
                        + "Spades: " + spadesList.toString().replace("[", "").replace("]", "") + "\n"
                        + "Hearts: " + heartsList.toString().replace("[", "").replace("]", "") + "\n"
                        + "Diamonds: " + diamondsList.toString().replace("[", "").replace("]", "") + "\n"
                        + "Clubs: " + clubsList.toString().replace("[", "").replace("]", ""));
            }
            
            if (tooManyCardsError) {
                tooManyCardsError = false;
                throw new HandException("The following hands have more than 13 cards: \n\n"
                        + hands.toString().replace("[", "").replace("]", "") + "\n\n");
            }

            ArrayList<String> tempList = new ArrayList<>();

            tempList.add(northSpades + ", " + southSpades + ", " + eastSpades + ", " + westSpades);
            tempList.add(northHearts + ", " + southHearts + ", " + eastHearts + ", " + westHearts);
            tempList.add(northDiamonds + ", " + southDiamonds + ", " + eastDiamonds + ", " + westDiamonds);
            tempList.add(northClubs + ", " + southClubs + ", " + eastClubs + ", " + westClubs);

            for (int k = 0; k < tempList.size(); k++) {
                String[] temp = tempList.get(k).split(", ");
            }

            String message = "";
            error = false;

            for (int i = 0; i < tempList.size(); i++) {
                String[] t = tempList.get(i).split(", ");

                t = cleanArray(t);

                for (int j = 0; j < t.length; j++) {
                    for (int k = j + 1; k < t.length; k++) {
                        if (t[j].equals(t[k])) {
                            error = true;
                            if (i == 0) {
                                message = message + t[j] + " of Spades, ";
                            }
                            else if (i == 1) {
                                message = message + t[j] + " of Hearts, ";
                            }
                            else if (i == 2) {
                                message = message + t[j] + " of Diamonds, ";
                            }
                            else {
                                message = message + t[j] + " of Clubs, ";
                            }
                        }
                    }
                }
            }
      
            if (error) {
                error = false;
                throw new HandException("The following cards have been entered more than once: " + message.substring(0, message.length() - 2));
            }

            for (int i = 0; i < handList.size(); i++) {
                if (!handList.get(i).isEmpty()) {
                    String[] temp = handList.get(i).split(", ");
                    String hand;
                    if (i % 4 == 0) {
                        for (int j = 0; j < temp.length; j++) {
                            String newTemp = temp[j] + "-S";
                            temp[j] = newTemp;
                        }
                    } else if (i % 4 == 1) {
                        for (int j = 0; j < temp.length; j++) {
                            String newTemp = temp[j] + "-H";
                            temp[j] = newTemp;
                        }
                    } else if (i % 4 == 2) {
                        for (int j = 0; j < temp.length; j++) {
                            String newTemp = temp[j] + "-D";
                            temp[j] = newTemp;
                        }
                    } else if (i % 4 == 3) {
                        for (int j = 0; j < temp.length; j++) {
                            String newTemp = temp[j] + "-C";
                            temp[j] = newTemp;
                        }
                    } else {
                        System.out.println("ERROR");
                    }

                    hand = temp[0];

                    for (int j = 1; j < temp.length; j++) {
                        hand = hand + ", " + temp[j];
                    }

                    handList.set(i, hand);
                }
            }

            for (int i = 0; i < handList.size(); i++) {
                if (handList.get(i).isEmpty()) {
                    handList.remove(i--);
                }
            }

            String[] temp = new String[handList.size()];

            for (int i = 0; i < temp.length; i++) {
                temp[i] = handList.get(i);
            }

            String temp2 = temp[0];

            for (int i = 1; i < temp.length; i++) {
                temp2 = temp2 + ", " + temp[i];
            }

            String[] handListArray = temp2.split(", ");
            
            String northHand = "";
            String southHand = "";
            String eastHand = "";
            String westHand = "";

            for (int i = 0; i < handListArray.length / 4; i++) {
                northHand = northHand + ", " + handListArray[i];
            }

            for (int i = handListArray.length / 4; i < handListArray.length / 4 * 2; i++) {
                southHand = southHand + ", " + handListArray[i];
            }

            for (int i = handListArray.length / 4 * 2; i < handListArray.length / 4 * 3; i++) {
                eastHand = eastHand + ", " + handListArray[i];
            }

            for (int i = handListArray.length / 4 * 3; i < handListArray.length; i++) {
                westHand = westHand + ", " + handListArray[i];
            }

            handList.clear();
            handList.add(northHand.substring(2));
            handList.add(southHand.substring(2));
            handList.add(eastHand.substring(2));
            handList.add(westHand.substring(2));
           
            save(deck, bNum, boardTitle, dealer, handList, NotesText.getText());

            saveUpdateGUI();

        } catch (BoardNumberException | HandException e1) {
            JOptionPane.showMessageDialog(null, e1);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Board Number must be an integer!");
        }
    }

    public void saveUpdateGUI() {
        int num = 0;

        for (int i = 0; i < decks.size(); i++) {
            if (dtField.getText().equals(decks.get(i).getDeckLabel())) {
                num = i;
            }
        }

        bcField.setText("Board Count: \n" + (decks.get(num).getBoardCount()) + " / 36");

        ArrayList<String> stringList = new ArrayList<>();

        for (int i = 0; i < decks.get(num).boards.length; i++) {
            if (!decks.get(num).boards[i].getLabel().equals("")) {
                stringList.add(decks.get(num).boards[i].getLabel());
            }
        }

        String[] temp = stringList.toArray(new String[stringList.size()]);

        if (OpenDeckMenu.getSelectedItem().toString().equals(dtField.getText())) {
            OpenBoardMenu.setModel(new javax.swing.DefaultComboBoxModel(temp));
        }
        if (DeleteDeckMenu.getSelectedItem().toString().equals(dtField.getText())) {
            DeleteBoardMenu.setModel(new javax.swing.DefaultComboBoxModel(temp));
        }

        initializeString();
        try {
            saveDeckObject(decks.get(num));
        } catch (IOException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, boardTitle + " saved successfully.");
        
        if (btField.getText().isEmpty()) {
            btField.setText(boardTitle);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        HelpButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        wsField = new javax.swing.JTextField();
        SpadeImageWest = new javax.swing.JLabel();
        HeartImageWest = new javax.swing.JLabel();
        whField = new javax.swing.JTextField();
        wdField = new javax.swing.JTextField();
        wcField = new javax.swing.JTextField();
        DiamondImageWest = new javax.swing.JLabel();
        ClubImageWest = new javax.swing.JLabel();
        WestLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ecField = new javax.swing.JTextField();
        DiamondImageEast = new javax.swing.JLabel();
        esField = new javax.swing.JTextField();
        SpadeImageEast = new javax.swing.JLabel();
        ehField = new javax.swing.JTextField();
        ClubImageEast = new javax.swing.JLabel();
        edField = new javax.swing.JTextField();
        HeartImageEast = new javax.swing.JLabel();
        EastLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        nhField = new javax.swing.JTextField();
        DiamondImageNorth = new javax.swing.JLabel();
        ncField = new javax.swing.JTextField();
        SpadeImageNorth = new javax.swing.JLabel();
        ndField = new javax.swing.JTextField();
        ClubImageNorth = new javax.swing.JLabel();
        NorthLabel = new javax.swing.JLabel();
        nsField = new javax.swing.JTextField();
        HeartImageNorth = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ClubImageSouth = new javax.swing.JLabel();
        ssField = new javax.swing.JTextField();
        SpadeImageSouth = new javax.swing.JLabel();
        HeartImageSouth = new javax.swing.JLabel();
        DiamondImageSouth = new javax.swing.JLabel();
        shField = new javax.swing.JTextField();
        scField = new javax.swing.JTextField();
        sdField = new javax.swing.JTextField();
        SouthLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        NotesText = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        Panel1 = new javax.swing.JPanel();
        DeckTitleLabel = new javax.swing.JLabel();
        dtField = new javax.swing.JTextField();
        BoardNumLabel = new javax.swing.JLabel();
        bnField = new javax.swing.JTextField();
        BoardTitleLabel = new javax.swing.JLabel();
        DealerLabel = new javax.swing.JLabel();
        bcField = new javax.swing.JTextField();
        NewDeckButton = new javax.swing.JButton();
        ClearBoardButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        OpenLabel = new javax.swing.JLabel();
        OpenDeckMenu = new javax.swing.JComboBox();
        OpenBoardMenu = new javax.swing.JComboBox();
        DeleteLabel = new javax.swing.JLabel();
        DeleteBoardMenu = new javax.swing.JComboBox();
        DeleteDeckMenu = new javax.swing.JComboBox();
        deleteButton = new javax.swing.JButton();
        PrintButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btField = new javax.swing.JTextField();
        dField = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bridge System");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        HelpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/help.jpg"))); // NOI18N
        HelpButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        HelpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        wsField.setEditable(false);
        wsField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wsFieldActionPerformed(evt);
            }
        });

        SpadeImageWest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spade.jpg"))); // NOI18N

        HeartImageWest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heart.jpg"))); // NOI18N

        whField.setEditable(false);
        whField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        whField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whFieldActionPerformed(evt);
            }
        });

        wdField.setEditable(false);
        wdField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wdFieldActionPerformed(evt);
            }
        });

        wcField.setEditable(false);
        wcField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wcField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wcFieldActionPerformed(evt);
            }
        });

        DiamondImageWest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diamond.jpg"))); // NOI18N

        ClubImageWest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/club.jpg"))); // NOI18N

        WestLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        WestLabel.setText("West");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(HeartImageWest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(whField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(SpadeImageWest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(wsField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(DiamondImageWest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(wdField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ClubImageWest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(wcField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(WestLabel)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpadeImageWest))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HeartImageWest)
                            .addComponent(whField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DiamondImageWest)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(WestLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wcField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClubImageWest))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        ecField.setEditable(false);
        ecField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ecField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecFieldActionPerformed(evt);
            }
        });

        DiamondImageEast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diamond.jpg"))); // NOI18N

        esField.setEditable(false);
        esField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        esField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esFieldActionPerformed(evt);
            }
        });

        SpadeImageEast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spade.jpg"))); // NOI18N

        ehField.setEditable(false);
        ehField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ehField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ehFieldActionPerformed(evt);
            }
        });

        ClubImageEast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/club.jpg"))); // NOI18N

        edField.setEditable(false);
        edField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edFieldActionPerformed(evt);
            }
        });

        HeartImageEast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heart.jpg"))); // NOI18N

        EastLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EastLabel.setText("East");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EastLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ClubImageEast)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(DiamondImageEast, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(HeartImageEast, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(SpadeImageEast, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(esField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ehField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ecField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(esField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpadeImageEast))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ehField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HeartImageEast))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DiamondImageEast)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(EastLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ecField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClubImageEast))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        nhField.setEditable(false);
        nhField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nhField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhFieldActionPerformed(evt);
            }
        });

        DiamondImageNorth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diamond.jpg"))); // NOI18N

        ncField.setEditable(false);
        ncField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ncField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ncFieldActionPerformed(evt);
            }
        });

        SpadeImageNorth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spade.jpg"))); // NOI18N

        ndField.setEditable(false);
        ndField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ndField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ndFieldActionPerformed(evt);
            }
        });

        ClubImageNorth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/club.jpg"))); // NOI18N

        NorthLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NorthLabel.setText("North");

        nsField.setEditable(false);
        nsField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nsFieldActionPerformed(evt);
            }
        });

        HeartImageNorth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heart.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DiamondImageNorth)
                                    .addComponent(SpadeImageNorth, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(HeartImageNorth, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(ClubImageNorth, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ncField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ndField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nhField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nsField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(NorthLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SpadeImageNorth)
                            .addComponent(nsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nhField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(HeartImageNorth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiamondImageNorth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ncField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClubImageNorth))
                .addGap(18, 18, 18)
                .addComponent(NorthLabel)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        ClubImageSouth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/club.jpg"))); // NOI18N

        ssField.setEditable(false);
        ssField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ssField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssFieldActionPerformed(evt);
            }
        });

        SpadeImageSouth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spade.jpg"))); // NOI18N

        HeartImageSouth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heart.jpg"))); // NOI18N

        DiamondImageSouth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diamond.jpg"))); // NOI18N

        shField.setEditable(false);
        shField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shFieldActionPerformed(evt);
            }
        });

        scField.setEditable(false);
        scField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        scField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scFieldActionPerformed(evt);
            }
        });

        sdField.setEditable(false);
        sdField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdFieldActionPerformed(evt);
            }
        });

        SouthLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SouthLabel.setText("South");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SpadeImageSouth)
                                    .addComponent(HeartImageSouth, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(DiamondImageSouth, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(ClubImageSouth)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sdField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ssField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(SouthLabel)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SouthLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ssField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SpadeImageSouth))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(HeartImageSouth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiamondImageSouth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClubImageSouth))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        NotesText.setEditable(false);
        NotesText.setColumns(20);
        NotesText.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        NotesText.setRows(5);
        NotesText.setToolTipText("");
        NotesText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(NotesText);
        NotesText.setLineWrap(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Notes:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(HelpButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(222, 222, 222)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(268, 268, 268)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HelpButton)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel1.setBackground(new java.awt.Color(255, 255, 255));
        Panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DeckTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DeckTitleLabel.setText("Deck Title:");

        dtField.setEditable(false);
        dtField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        BoardNumLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BoardNumLabel.setText("Board #:");

        bnField.setEditable(false);
        bnField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        BoardTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BoardTitleLabel.setText("Board Title:");

        DealerLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DealerLabel.setText("Dealer:");

        bcField.setEditable(false);
        bcField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bcField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcFieldActionPerformed(evt);
            }
        });

        NewDeckButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NewDeckButton.setText("New Deck");
        NewDeckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewDeckButtonActionPerformed(evt);
            }
        });

        ClearBoardButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ClearBoardButton.setText("Clear Board");
        ClearBoardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBoardButtonActionPerformed(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        OpenLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OpenLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OpenLabel.setText("Open:");
        OpenLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        OpenDeckMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OpenDeckMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"-----"}));
        OpenDeckMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenDeckMenuActionPerformed(evt);
            }
        });

        OpenBoardMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OpenBoardMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"-----"}));
        OpenBoardMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenBoardMenuActionPerformed(evt);
            }
        });

        DeleteLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DeleteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeleteLabel.setText("Delete:");

        DeleteBoardMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DeleteBoardMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"-----"}));

        DeleteDeckMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DeleteDeckMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"-----"}));
        DeleteDeckMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteDeckMenuActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        PrintButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PrintButton.setText("Create Document & Images");
        PrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintButtonActionPerformed(evt);
            }
        });

        btField.setEditable(false);
        btField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFieldActionPerformed(evt);
            }
        });

        dField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select Dealer--", "North", "South", "East", "West" }));

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel1Layout.createSequentialGroup()
                                .addComponent(DeleteDeckMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DeleteBoardMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(PrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(Panel1Layout.createSequentialGroup()
                                    .addComponent(OpenDeckMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(OpenBoardMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)))))
                    .addGroup(Panel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ClearBoardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NewDeckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OpenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Panel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(DeleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel1Layout.createSequentialGroup()
                        .addComponent(bcField)
                        .addContainerGap())
                    .addGroup(Panel1Layout.createSequentialGroup()
                        .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(Panel1Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(DeckTitleLabel)
                                        .addComponent(BoardNumLabel)))
                                .addComponent(DealerLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(BoardTitleLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bnField)
                            .addComponent(dtField)
                            .addComponent(btField)
                            .addComponent(dField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37))))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeckTitleLabel)
                    .addComponent(dtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoardNumLabel)
                    .addComponent(bnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoardTitleLabel))
                .addGap(21, 21, 21)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DealerLabel)
                    .addComponent(dField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bcField, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewDeckButton)
                .addGap(11, 11, 11)
                .addComponent(ClearBoardButton)
                .addGap(11, 11, 11)
                .addComponent(SaveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OpenLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OpenBoardMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OpenDeckMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteLabel)
                .addGap(8, 8, 8)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteDeckMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBoardMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton)
                .addGap(11, 11, 11)
                .addComponent(PrintButton)
                .addGap(44, 44, 44))
        );

        dtField.getAccessibleContext().setAccessibleName("");
        bnField.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bcFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_bcFieldActionPerformed

    //Action Listener for delete button. Deletes the board and updates the GUI to reflect updated information.
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Delete " + DeleteBoardMenu.getSelectedItem().toString(), JOptionPane.YES_NO_OPTION);

        if (choice == 0) {
            String boardLabel = DeleteBoardMenu.getSelectedItem().toString();
            String dTitle = DeleteDeckMenu.getSelectedItem().toString();

            int num = 0, bNum = 0;

            for (int i = 0; i < decks.size(); i++) {
                if (dTitle.equals(decks.get(i).getDeckLabel())) {
                    num = i;
                }
            }

            for (int i = 0; i < decks.get(num).boards.length; i++) {
                if (boardLabel.equals(decks.get(num).boards[i].getLabel())) {
                    bNum = i;
                }
            }

            if (boardLabel.equals(btField.getText()) && dTitle.equals(dtField.getText())) {
                clearFields();
            }

            deleteBoard(dTitle, bNum);

            if (dTitle.equals(dtField.getText())) {
                bcField.setText("Board Count: \n" + decks.get(num).getBoardCount() + " / 36");
            }

            num = 0;

            for (int i = 0; i < decks.size(); i++) {
                if (DeleteDeckMenu.getSelectedItem().toString().equals(decks.get(i).getDeckLabel())) {
                    num = i;
                }
            }

            ArrayList<String> stringList = new ArrayList<>();

            for (int i = 0; i < decks.get(num).boards.length; i++) {
                if (!decks.get(num).boards[i].getLabel().equals("")) {
                    stringList.add(decks.get(num).boards[i].getLabel());
                }
            }

            String[] temp = stringList.toArray(new String[stringList.size()]);

            DeleteBoardMenu.setModel(new javax.swing.DefaultComboBoxModel(temp));

            num = 0;

            for (int i = 0; i < decks.size(); i++) {
                if (dtField.getText().equals(decks.get(i).getDeckLabel())) {
                    num = i;
                }
            }

            stringList = new ArrayList<>();

            for (int i = 0; i < decks.get(num).boards.length; i++) {
                if (!decks.get(num).boards[i].getLabel().equals("")) {
                    stringList.add(decks.get(num).boards[i].getLabel());
                }
            }

            temp = stringList.toArray(new String[stringList.size()]);

            OpenBoardMenu.setModel(new javax.swing.DefaultComboBoxModel(temp));

            try {
                saveDeckObject(decks.get(num));
            } catch (IOException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    //Populates the open board menu with boards contained in selected deck
    private void OpenDeckMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenDeckMenuActionPerformed
        // TODO add your handling code here:
        String dTitle = OpenDeckMenu.getSelectedItem().toString();
        
        dtField.setText(dTitle);

        int num = 0;

        for (int i = 0; i < decks.size(); i++) {
            if (dtField.getText().equals(decks.get(i).getDeckLabel())) {
                num = i;
            }
        }

        bcField.setText("Board Count: \n" + decks.get(num).getBoardCount() + " / 36");

        ArrayList<String> stringList = new ArrayList<>();

        for (int i = 0; i < decks.get(num).boards.length; i++) {
            if (!decks.get(num).boards[i].getLabel().equals("")) {
                stringList.add(decks.get(num).boards[i].getLabel());
            }
        }

        String[] temp = stringList.toArray(new String[stringList.size()]);

        OpenBoardMenu.setModel(new javax.swing.DefaultComboBoxModel(temp));
        
        clearFields();
        setEditableTrue();
    }//GEN-LAST:event_OpenDeckMenuActionPerformed

    private void PrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintButtonActionPerformed
        createOutput();
    }//GEN-LAST:event_PrintButtonActionPerformed

    //Action listener for deck selection in delete menu. Populates delete board menu with boards in selected deck
    private void DeleteDeckMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteDeckMenuActionPerformed
        // TODO add your handling code here:
        int num = 0;

        for (int i = 0; i < decks.size(); i++) {
            if (DeleteDeckMenu.getSelectedItem().toString().equals(decks.get(i).getDeckLabel())) {
                num = i;
            }
        }

        ArrayList<String> stringList = new ArrayList<>();

        for (int i = 0; i < decks.get(num).boards.length; i++) {
            if (!decks.get(num).boards[i].getLabel().equals("")) {
                stringList.add(decks.get(num).boards[i].getLabel());
            }
        }

        String[] temp = stringList.toArray(new String[stringList.size()]);

        DeleteBoardMenu.setModel(new javax.swing.DefaultComboBoxModel(temp));
    }//GEN-LAST:event_DeleteDeckMenuActionPerformed

    //Action Listener that opens selected board.
    private void OpenBoardMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenBoardMenuActionPerformed
        // TODO add your handling code here:
        if (OpenBoardMenu.getSelectedItem() != null) {
            String boardLabel = OpenBoardMenu.getSelectedItem().toString();
            String dTitle = OpenDeckMenu.getSelectedItem().toString();

            int num = 0, bNum = 0;
            boolean load = false;

            for (int i = 0; i < decks.size(); i++) {
                if (dtField.getText().equals(decks.get(i).getDeckLabel())) {
                    num = i;
                }
            }

            for (int i = 0; i < decks.get(num).boards.length; i++) {
                if (boardLabel.equals(decks.get(num).boards[i].getLabel())) {
                    bNum = i;
                    load = true;
                }
            }

            if (load) {
                loadBoard(dTitle, bNum + 1);
                setEditableTrue();
            }

            load = false;
        }
    }//GEN-LAST:event_OpenBoardMenuActionPerformed

    //Action Listener for saving all entered information
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        if (dtField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Must create new Deck!");
        } else {
            formatCheck();
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    //Action Listener for creating a new board. All text fields are cleared, ready to accept new information
    private void ClearBoardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBoardButtonActionPerformed
        clearFields();
        initializeString();
    }//GEN-LAST:event_ClearBoardButtonActionPerformed

    private void NewDeckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewDeckButtonActionPerformed
        newDeckButton();

        setEditableTrue();
    }//GEN-LAST:event_NewDeckButtonActionPerformed

    private void sdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdFieldActionPerformed

    private void scFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scFieldActionPerformed

    private void shFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shFieldActionPerformed

    private void ssFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ssFieldActionPerformed

    private void nsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nsFieldActionPerformed

    private void ndFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ndFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ndFieldActionPerformed

    private void ncFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ncFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ncFieldActionPerformed

    private void nhFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhFieldActionPerformed

    private void edFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edFieldActionPerformed

    private void ehFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ehFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ehFieldActionPerformed

    private void esFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esFieldActionPerformed

    private void ecFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ecFieldActionPerformed

    private void wcFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wcFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wcFieldActionPerformed

    private void wdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wdFieldActionPerformed

    private void whFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_whFieldActionPerformed

    private void wsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wsFieldActionPerformed

    //Pops up help window
    private void HelpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpButtonActionPerformed
        // TODO add your handling code here:
        String helpMessage = "======================================================================================================================================\n"
                + "Button Help\n"
                + "======================================================================================================================================\n"
                + "     New Deck:\n"
                + "          - Click to create new deck. Enter the desired title for the deck and click 'OK'.\n"
                + "     Clear Board:\n"
                + "          - Click to clear all text fields on screen.\n"
                + "     Save:\n"
                + "          - Saves the current board. The saved board remains on the screen until the user clicks the \"Clear Board\" button.\n"
                + "     Open:\n"
                + "          - From left to right, click the first drop-down menu and select the desired deck.\n"
                + "          - Then, click the second drop-down menu and select the desired board.\n"
                + "          - The screen will be filled with the selected board.\n"
                + "     Delete:\n"
                + "          - From left to right, click the first drop-down menu and select the desired deck.\n"
                + "          - Then, select the click the second drop-down menu and select the desired board.\n"
                + "          - Click the delete button. A window will popup to confirm if you want to delete the board.\n"
                + "     Print:\n"
                + "          - Select the desired deck from the drop-down menu in the popup window.\n"
                + "          - The images and documentation for the desired deck will be generated and the file paths of where to find them will be displayed.\n"
                + "======================================================================================================================================\n"
                + "Card Input\n"
                + "======================================================================================================================================\n"
                + "     - Enter card using the keyboard in the appropriate position. Format for input should be in either uppercase or lowercase.\n"
                + "     - The only accepted values are 2-9 and letters A, K, Q, J, and T.\n"
                + "======================================================================================================================================\n"
                + "Other Notes\n"
                + "======================================================================================================================================\n"
                + "     - In order for a new deck to be saved permanently, at least one valid board must be entered and saved.\n"
                + "     - Operating System: " + System.getProperty("os.name") + "\n"
                + "     - Current Directory: " + System.getProperty("user.dir");

        JOptionPane.showMessageDialog(MainPanel, helpMessage, "Help", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_HelpButtonActionPerformed

    private void btFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btFieldActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainScreen().setVisible(true);

                try {
                    loadDeckObjects();
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BoardNumLabel;
    private javax.swing.JLabel BoardTitleLabel;
    private javax.swing.JButton ClearBoardButton;
    private javax.swing.JLabel ClubImageEast;
    private javax.swing.JLabel ClubImageNorth;
    private javax.swing.JLabel ClubImageSouth;
    private javax.swing.JLabel ClubImageWest;
    private javax.swing.JLabel DealerLabel;
    private javax.swing.JLabel DeckTitleLabel;
    private javax.swing.JComboBox DeleteBoardMenu;
    private static javax.swing.JComboBox DeleteDeckMenu;
    private javax.swing.JLabel DeleteLabel;
    private javax.swing.JLabel DiamondImageEast;
    private javax.swing.JLabel DiamondImageNorth;
    private javax.swing.JLabel DiamondImageSouth;
    private javax.swing.JLabel DiamondImageWest;
    private javax.swing.JLabel EastLabel;
    private javax.swing.JLabel HeartImageEast;
    private javax.swing.JLabel HeartImageNorth;
    private javax.swing.JLabel HeartImageSouth;
    private javax.swing.JLabel HeartImageWest;
    private javax.swing.JButton HelpButton;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton NewDeckButton;
    private javax.swing.JLabel NorthLabel;
    private static javax.swing.JTextArea NotesText;
    private javax.swing.JComboBox OpenBoardMenu;
    private static javax.swing.JComboBox OpenDeckMenu;
    private javax.swing.JLabel OpenLabel;
    private javax.swing.JPanel Panel1;
    private javax.swing.JButton PrintButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel SouthLabel;
    private javax.swing.JLabel SpadeImageEast;
    private javax.swing.JLabel SpadeImageNorth;
    private javax.swing.JLabel SpadeImageSouth;
    private javax.swing.JLabel SpadeImageWest;
    private javax.swing.JLabel WestLabel;
    private static javax.swing.JTextField bcField;
    private static javax.swing.JTextField bnField;
    private javax.swing.JTextField btField;
    private javax.swing.JComboBox dField;
    private javax.swing.JButton deleteButton;
    private static javax.swing.JTextField dtField;
    private static javax.swing.JTextField ecField;
    private static javax.swing.JTextField edField;
    private static javax.swing.JTextField ehField;
    private static javax.swing.JTextField esField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JTextField ncField;
    private static javax.swing.JTextField ndField;
    private static javax.swing.JTextField nhField;
    private static javax.swing.JTextField nsField;
    private static javax.swing.JTextField scField;
    private static javax.swing.JTextField sdField;
    private static javax.swing.JTextField shField;
    private static javax.swing.JTextField ssField;
    private static javax.swing.JTextField wcField;
    private static javax.swing.JTextField wdField;
    private static javax.swing.JTextField whField;
    private static javax.swing.JTextField wsField;
    // End of variables declaration//GEN-END:variables
}
