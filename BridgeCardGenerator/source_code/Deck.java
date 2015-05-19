/*
v1.0

Code for Deck class.

*/

import java.util.ArrayList;
import java.io.Serializable;

public class Deck implements Serializable {

    String deckLabel;
    int boardCount;
    Board[] boards;
    Card[] cards;

    char[] values = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};

    public Deck() {
        deckLabel = "";
        boardCount = 0;
        boards = null;
        cards = null;
    }

    //Constructor for deck object
    public Deck(String label) {
        deckLabel = label;
        boardCount = 0;
        boards = new Board[36];
        cards = new Card[52];

        for (int i = 0; i < 52; i++) {
            if (i < 36) {
                boards[i] = new Board();
            }
            cards[i] = new Card();
        }

        //Builds full card array
        for (int i = 0; i < 4; i++) {
            for (int j = (i * 13); j < ((i + 1) * 13); j++) {
                cards[j].setValue(values[j % 13]);

                if (j < 13) {
                    cards[j].setSuit('S');
                } else if (j < 26) {
                    cards[j].setSuit('H');
                } else if (j < 39) {
                    cards[j].setSuit('D');
                } else {
                    cards[j].setSuit('C');
                }
            }
        }
    }

    public void setDeckLabel(String l) {
        deckLabel = l;
    }

    public String getDeckLabel() {
        return deckLabel;
    }

    public int getBoardCount() {
        return boardCount;
    }

    //Accepts user input and stores information accordingly
    public void addBoard(int boardNum, String boardTitle, String dealer, ArrayList<String> list, String notes) {
        if (boards[boardNum - 1].boardLabel.equals("")) {
            boardCount++;
        }

        boards[boardNum - 1].setLabel(boardTitle);
        boards[boardNum - 1].setDealer(dealer);
        boards[boardNum - 1].setHands(list);
        boards[boardNum - 1].setNotes(notes);

        /*
         The next 800 lines or so may look intimidating, but all it does is takes each card from the hands given
         and sets the value of the corresponding card in the card array to the appropriate
         player.
         */
        for (int i = 0; i < list.size(); i++) {
            String[] temp = list.get(i).split(", ");
            for (int j = 0; j < temp.length; j++) {
                String[] card = temp[j].split("-");
                if (i == 0) {
                    switch (card[1]) {
                        case "S":
                            switch (card[0]) {
                                case "2":
                                    cards[0].setPosition(boardNum - 1, 'N');
                                    break;
                                case "3":
                                    cards[1].setPosition(boardNum - 1, 'N');
                                    break;
                                case "4":
                                    cards[2].setPosition(boardNum - 1, 'N');
                                    break;
                                case "5":
                                    cards[3].setPosition(boardNum - 1, 'N');
                                    break;
                                case "6":
                                    cards[4].setPosition(boardNum - 1, 'N');
                                    break;
                                case "7":
                                    cards[5].setPosition(boardNum - 1, 'N');
                                    break;
                                case "8":
                                    cards[6].setPosition(boardNum - 1, 'N');
                                    break;
                                case "9":
                                    cards[7].setPosition(boardNum - 1, 'N');
                                    break;
                                case "T":
                                    cards[8].setPosition(boardNum - 1, 'N');
                                    break;
                                case "J":
                                    cards[9].setPosition(boardNum - 1, 'N');
                                    break;
                                case "Q":
                                    cards[10].setPosition(boardNum - 1, 'N');
                                    break;
                                case "K":
                                    cards[11].setPosition(boardNum - 1, 'N');
                                    break;
                                case "A":
                                    cards[12].setPosition(boardNum - 1, 'N');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        case "H":
                            switch (card[0]) {
                                case "2":
                                    cards[13].setPosition(boardNum - 1, 'N');
                                    break;
                                case "3":
                                    cards[14].setPosition(boardNum - 1, 'N');
                                    break;
                                case "4":
                                    cards[15].setPosition(boardNum - 1, 'N');
                                    break;
                                case "5":
                                    cards[16].setPosition(boardNum - 1, 'N');
                                    break;
                                case "6":
                                    cards[17].setPosition(boardNum - 1, 'N');
                                    break;
                                case "7":
                                    cards[18].setPosition(boardNum - 1, 'N');
                                    break;
                                case "8":
                                    cards[19].setPosition(boardNum - 1, 'N');
                                    break;
                                case "9":
                                    cards[20].setPosition(boardNum - 1, 'N');
                                    break;
                                case "T":
                                    cards[21].setPosition(boardNum - 1, 'N');
                                    break;
                                case "J":
                                    cards[22].setPosition(boardNum - 1, 'N');
                                    break;
                                case "Q":
                                    cards[23].setPosition(boardNum - 1, 'N');
                                    break;
                                case "K":
                                    cards[24].setPosition(boardNum - 1, 'N');
                                    break;
                                case "A":
                                    cards[25].setPosition(boardNum - 1, 'N');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        case "D":
                            switch (card[0]) {
                                case "2":
                                    cards[26].setPosition(boardNum - 1, 'N');
                                    break;
                                case "3":
                                    cards[27].setPosition(boardNum - 1, 'N');
                                    break;
                                case "4":
                                    cards[28].setPosition(boardNum - 1, 'N');
                                    break;
                                case "5":
                                    cards[29].setPosition(boardNum - 1, 'N');
                                    break;
                                case "6":
                                    cards[30].setPosition(boardNum - 1, 'N');
                                    break;
                                case "7":
                                    cards[31].setPosition(boardNum - 1, 'N');
                                    break;
                                case "8":
                                    cards[32].setPosition(boardNum - 1, 'N');
                                    break;
                                case "9":
                                    cards[33].setPosition(boardNum - 1, 'N');
                                    break;
                                case "T":
                                    cards[34].setPosition(boardNum - 1, 'N');
                                    break;
                                case "J":
                                    cards[35].setPosition(boardNum - 1, 'N');
                                    break;
                                case "Q":
                                    cards[36].setPosition(boardNum - 1, 'N');
                                    break;
                                case "K":
                                    cards[37].setPosition(boardNum - 1, 'N');
                                    break;
                                case "A":
                                    cards[38].setPosition(boardNum - 1, 'N');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        case "C":
                            switch (card[0]) {
                                case "2":
                                    cards[39].setPosition(boardNum - 1, 'N');
                                    break;
                                case "3":
                                    cards[40].setPosition(boardNum - 1, 'N');
                                    break;
                                case "4":
                                    cards[41].setPosition(boardNum - 1, 'N');
                                    break;
                                case "5":
                                    cards[42].setPosition(boardNum - 1, 'N');
                                    break;
                                case "6":
                                    cards[43].setPosition(boardNum - 1, 'N');
                                    break;
                                case "7":
                                    cards[44].setPosition(boardNum - 1, 'N');
                                    break;
                                case "8":
                                    cards[45].setPosition(boardNum - 1, 'N');
                                    break;
                                case "9":
                                    cards[46].setPosition(boardNum - 1, 'N');
                                    break;
                                case "T":
                                    cards[47].setPosition(boardNum - 1, 'N');
                                    break;
                                case "J":
                                    cards[48].setPosition(boardNum - 1, 'N');
                                    break;
                                case "Q":
                                    cards[49].setPosition(boardNum - 1, 'N');
                                    break;
                                case "K":
                                    cards[50].setPosition(boardNum - 1, 'N');
                                    break;
                                case "A":
                                    cards[51].setPosition(boardNum - 1, 'N');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Something went super horribly wrong!");
                            break;
                    }
                } else if (i == 1) {
                    switch (card[1]) {
                        case "S":
                            switch (card[0]) {
                                case "2":
                                    cards[0].setPosition(boardNum - 1, 'S');
                                    break;
                                case "3":
                                    cards[1].setPosition(boardNum - 1, 'S');
                                    break;
                                case "4":
                                    cards[2].setPosition(boardNum - 1, 'S');
                                    break;
                                case "5":
                                    cards[3].setPosition(boardNum - 1, 'S');
                                    break;
                                case "6":
                                    cards[4].setPosition(boardNum - 1, 'S');
                                    break;
                                case "7":
                                    cards[5].setPosition(boardNum - 1, 'S');
                                    break;
                                case "8":
                                    cards[6].setPosition(boardNum - 1, 'S');
                                    break;
                                case "9":
                                    cards[7].setPosition(boardNum - 1, 'S');
                                    break;
                                case "T":
                                    cards[8].setPosition(boardNum - 1, 'S');
                                    break;
                                case "J":
                                    cards[9].setPosition(boardNum - 1, 'S');
                                    break;
                                case "Q":
                                    cards[10].setPosition(boardNum - 1, 'S');
                                    break;
                                case "K":
                                    cards[11].setPosition(boardNum - 1, 'S');
                                    break;
                                case "A":
                                    cards[12].setPosition(boardNum - 1, 'S');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        case "H":
                            switch (card[0]) {
                                case "2":
                                    cards[13].setPosition(boardNum - 1, 'S');
                                    break;
                                case "3":
                                    cards[14].setPosition(boardNum - 1, 'S');
                                    break;
                                case "4":
                                    cards[15].setPosition(boardNum - 1, 'S');
                                    break;
                                case "5":
                                    cards[16].setPosition(boardNum - 1, 'S');
                                    break;
                                case "6":
                                    cards[17].setPosition(boardNum - 1, 'S');
                                    break;
                                case "7":
                                    cards[18].setPosition(boardNum - 1, 'S');
                                    break;
                                case "8":
                                    cards[19].setPosition(boardNum - 1, 'S');
                                    break;
                                case "9":
                                    cards[20].setPosition(boardNum - 1, 'S');
                                    break;
                                case "T":
                                    cards[21].setPosition(boardNum - 1, 'S');
                                    break;
                                case "J":
                                    cards[22].setPosition(boardNum - 1, 'S');
                                    break;
                                case "Q":
                                    cards[23].setPosition(boardNum - 1, 'S');
                                    break;
                                case "K":
                                    cards[24].setPosition(boardNum - 1, 'S');
                                    break;
                                case "A":
                                    cards[25].setPosition(boardNum - 1, 'S');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        case "D":
                            switch (card[0]) {
                                case "2":
                                    cards[26].setPosition(boardNum - 1, 'S');
                                    break;
                                case "3":
                                    cards[27].setPosition(boardNum - 1, 'S');
                                    break;
                                case "4":
                                    cards[28].setPosition(boardNum - 1, 'S');
                                    break;
                                case "5":
                                    cards[29].setPosition(boardNum - 1, 'S');
                                    break;
                                case "6":
                                    cards[30].setPosition(boardNum - 1, 'S');
                                    break;
                                case "7":
                                    cards[31].setPosition(boardNum - 1, 'S');
                                    break;
                                case "8":
                                    cards[32].setPosition(boardNum - 1, 'S');
                                    break;
                                case "9":
                                    cards[33].setPosition(boardNum - 1, 'S');
                                    break;
                                case "T":
                                    cards[34].setPosition(boardNum - 1, 'S');
                                    break;
                                case "J":
                                    cards[35].setPosition(boardNum - 1, 'S');
                                    break;
                                case "Q":
                                    cards[36].setPosition(boardNum - 1, 'S');
                                    break;
                                case "K":
                                    cards[37].setPosition(boardNum - 1, 'S');
                                    break;
                                case "A":
                                    cards[38].setPosition(boardNum - 1, 'S');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        case "C":
                            switch (card[0]) {
                                case "2":
                                    cards[39].setPosition(boardNum - 1, 'S');
                                    break;
                                case "3":
                                    cards[40].setPosition(boardNum - 1, 'S');
                                    break;
                                case "4":
                                    cards[41].setPosition(boardNum - 1, 'S');
                                    break;
                                case "5":
                                    cards[42].setPosition(boardNum - 1, 'S');
                                    break;
                                case "6":
                                    cards[43].setPosition(boardNum - 1, 'S');
                                    break;
                                case "7":
                                    cards[44].setPosition(boardNum - 1, 'S');
                                    break;
                                case "8":
                                    cards[45].setPosition(boardNum - 1, 'S');
                                    break;
                                case "9":
                                    cards[46].setPosition(boardNum - 1, 'S');
                                    break;
                                case "T":
                                    cards[47].setPosition(boardNum - 1, 'S');
                                    break;
                                case "J":
                                    cards[48].setPosition(boardNum - 1, 'S');
                                    break;
                                case "Q":
                                    cards[49].setPosition(boardNum - 1, 'S');
                                    break;
                                case "K":
                                    cards[50].setPosition(boardNum - 1, 'S');
                                    break;
                                case "A":
                                    cards[51].setPosition(boardNum - 1, 'S');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Something went super horribly wrong!");
                            break;
                    }
                } else if (i == 2) {
                    switch (card[1]) {
                        case "S":
                            switch (card[0]) {
                                case "2":
                                    cards[0].setPosition(boardNum - 1, 'E');
                                    break;
                                case "3":
                                    cards[1].setPosition(boardNum - 1, 'E');
                                    break;
                                case "4":
                                    cards[2].setPosition(boardNum - 1, 'E');
                                    break;
                                case "5":
                                    cards[3].setPosition(boardNum - 1, 'E');
                                    break;
                                case "6":
                                    cards[4].setPosition(boardNum - 1, 'E');
                                    break;
                                case "7":
                                    cards[5].setPosition(boardNum - 1, 'E');
                                    break;
                                case "8":
                                    cards[6].setPosition(boardNum - 1, 'E');
                                    break;
                                case "9":
                                    cards[7].setPosition(boardNum - 1, 'E');
                                    break;
                                case "T":
                                    cards[8].setPosition(boardNum - 1, 'E');
                                    break;
                                case "J":
                                    cards[9].setPosition(boardNum - 1, 'E');
                                    break;
                                case "Q":
                                    cards[10].setPosition(boardNum - 1, 'E');
                                    break;
                                case "K":
                                    cards[11].setPosition(boardNum - 1, 'E');
                                    break;
                                case "A":
                                    cards[12].setPosition(boardNum - 1, 'E');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        case "H":
                            switch (card[0]) {
                                case "2":
                                    cards[13].setPosition(boardNum - 1, 'E');
                                    break;
                                case "3":
                                    cards[14].setPosition(boardNum - 1, 'E');
                                    break;
                                case "4":
                                    cards[15].setPosition(boardNum - 1, 'E');
                                    break;
                                case "5":
                                    cards[16].setPosition(boardNum - 1, 'E');
                                    break;
                                case "6":
                                    cards[17].setPosition(boardNum - 1, 'E');
                                    break;
                                case "7":
                                    cards[18].setPosition(boardNum - 1, 'E');
                                    break;
                                case "8":
                                    cards[19].setPosition(boardNum - 1, 'E');
                                    break;
                                case "9":
                                    cards[20].setPosition(boardNum - 1, 'E');
                                    break;
                                case "T":
                                    cards[21].setPosition(boardNum - 1, 'E');
                                    break;
                                case "J":
                                    cards[22].setPosition(boardNum - 1, 'E');
                                    break;
                                case "Q":
                                    cards[23].setPosition(boardNum - 1, 'E');
                                    break;
                                case "K":
                                    cards[24].setPosition(boardNum - 1, 'E');
                                    break;
                                case "A":
                                    cards[25].setPosition(boardNum - 1, 'E');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        case "D":
                            switch (card[0]) {
                                case "2":
                                    cards[26].setPosition(boardNum - 1, 'E');
                                    break;
                                case "3":
                                    cards[27].setPosition(boardNum - 1, 'E');
                                    break;
                                case "4":
                                    cards[28].setPosition(boardNum - 1, 'E');
                                    break;
                                case "5":
                                    cards[29].setPosition(boardNum - 1, 'E');
                                    break;
                                case "6":
                                    cards[30].setPosition(boardNum - 1, 'E');
                                    break;
                                case "7":
                                    cards[31].setPosition(boardNum - 1, 'E');
                                    break;
                                case "8":
                                    cards[32].setPosition(boardNum - 1, 'E');
                                    break;
                                case "9":
                                    cards[33].setPosition(boardNum - 1, 'E');
                                    break;
                                case "T":
                                    cards[34].setPosition(boardNum - 1, 'E');
                                    break;
                                case "J":
                                    cards[35].setPosition(boardNum - 1, 'E');
                                    break;
                                case "Q":
                                    cards[36].setPosition(boardNum - 1, 'E');
                                    break;
                                case "K":
                                    cards[37].setPosition(boardNum - 1, 'E');
                                    break;
                                case "A":
                                    cards[38].setPosition(boardNum - 1, 'E');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        case "C":
                            switch (card[0]) {
                                case "2":
                                    cards[39].setPosition(boardNum - 1, 'E');
                                    break;
                                case "3":
                                    cards[40].setPosition(boardNum - 1, 'E');
                                    break;
                                case "4":
                                    cards[41].setPosition(boardNum - 1, 'E');
                                    break;
                                case "5":
                                    cards[42].setPosition(boardNum - 1, 'E');
                                    break;
                                case "6":
                                    cards[43].setPosition(boardNum - 1, 'E');
                                    break;
                                case "7":
                                    cards[44].setPosition(boardNum - 1, 'E');
                                    break;
                                case "8":
                                    cards[45].setPosition(boardNum - 1, 'E');
                                    break;
                                case "9":
                                    cards[46].setPosition(boardNum - 1, 'E');
                                    break;
                                case "T":
                                    cards[47].setPosition(boardNum - 1, 'E');
                                    break;
                                case "J":
                                    cards[48].setPosition(boardNum - 1, 'E');
                                    break;
                                case "Q":
                                    cards[49].setPosition(boardNum - 1, 'E');
                                    break;
                                case "K":
                                    cards[50].setPosition(boardNum - 1, 'E');
                                    break;
                                case "A":
                                    cards[51].setPosition(boardNum - 1, 'E');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Something went super horribly wrong!");
                            break;
                    }
                } else if (i == 3) {
                    switch (card[1]) {
                        case "S":
                            switch (card[0]) {
                                case "2":
                                    cards[0].setPosition(boardNum - 1, 'W');
                                    break;
                                case "3":
                                    cards[1].setPosition(boardNum - 1, 'W');
                                    break;
                                case "4":
                                    cards[2].setPosition(boardNum - 1, 'W');
                                    break;
                                case "5":
                                    cards[3].setPosition(boardNum - 1, 'W');
                                    break;
                                case "6":
                                    cards[4].setPosition(boardNum - 1, 'W');
                                    break;
                                case "7":
                                    cards[5].setPosition(boardNum - 1, 'W');
                                    break;
                                case "8":
                                    cards[6].setPosition(boardNum - 1, 'W');
                                    break;
                                case "9":
                                    cards[7].setPosition(boardNum - 1, 'W');
                                    break;
                                case "T":
                                    cards[8].setPosition(boardNum - 1, 'W');
                                    break;
                                case "J":
                                    cards[9].setPosition(boardNum - 1, 'W');
                                    break;
                                case "Q":
                                    cards[10].setPosition(boardNum - 1, 'W');
                                    break;
                                case "K":
                                    cards[11].setPosition(boardNum - 1, 'W');
                                    break;
                                case "A":
                                    cards[12].setPosition(boardNum - 1, 'W');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        case "H":
                            switch (card[0]) {
                                case "2":
                                    cards[13].setPosition(boardNum - 1, 'W');
                                    break;
                                case "3":
                                    cards[14].setPosition(boardNum - 1, 'W');
                                    break;
                                case "4":
                                    cards[15].setPosition(boardNum - 1, 'W');
                                    break;
                                case "5":
                                    cards[16].setPosition(boardNum - 1, 'W');
                                    break;
                                case "6":
                                    cards[17].setPosition(boardNum - 1, 'W');
                                    break;
                                case "7":
                                    cards[18].setPosition(boardNum - 1, 'W');
                                    break;
                                case "8":
                                    cards[19].setPosition(boardNum - 1, 'W');
                                    break;
                                case "9":
                                    cards[20].setPosition(boardNum - 1, 'W');
                                    break;
                                case "T":
                                    cards[21].setPosition(boardNum - 1, 'W');
                                    break;
                                case "J":
                                    cards[22].setPosition(boardNum - 1, 'W');
                                    break;
                                case "Q":
                                    cards[23].setPosition(boardNum - 1, 'W');
                                    break;
                                case "K":
                                    cards[24].setPosition(boardNum - 1, 'W');
                                    break;
                                case "A":
                                    cards[25].setPosition(boardNum - 1, 'W');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        case "D":
                            switch (card[0]) {
                                case "2":
                                    cards[26].setPosition(boardNum - 1, 'W');
                                    break;
                                case "3":
                                    cards[27].setPosition(boardNum - 1, 'W');
                                    break;
                                case "4":
                                    cards[28].setPosition(boardNum - 1, 'W');
                                    break;
                                case "5":
                                    cards[29].setPosition(boardNum - 1, 'W');
                                    break;
                                case "6":
                                    cards[30].setPosition(boardNum - 1, 'W');
                                    break;
                                case "7":
                                    cards[31].setPosition(boardNum - 1, 'W');
                                    break;
                                case "8":
                                    cards[32].setPosition(boardNum - 1, 'W');
                                    break;
                                case "9":
                                    cards[33].setPosition(boardNum - 1, 'W');
                                    break;
                                case "T":
                                    cards[34].setPosition(boardNum - 1, 'W');
                                    break;
                                case "J":
                                    cards[35].setPosition(boardNum - 1, 'W');
                                    break;
                                case "Q":
                                    cards[36].setPosition(boardNum - 1, 'W');
                                    break;
                                case "K":
                                    cards[37].setPosition(boardNum - 1, 'W');
                                    break;
                                case "A":
                                    cards[38].setPosition(boardNum - 1, 'W');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        case "C":
                            switch (card[0]) {
                                case "2":
                                    cards[39].setPosition(boardNum - 1, 'W');
                                    break;
                                case "3":
                                    cards[40].setPosition(boardNum - 1, 'W');
                                    break;
                                case "4":
                                    cards[41].setPosition(boardNum - 1, 'W');
                                    break;
                                case "5":
                                    cards[42].setPosition(boardNum - 1, 'W');
                                    break;
                                case "6":
                                    cards[43].setPosition(boardNum - 1, 'W');
                                    break;
                                case "7":
                                    cards[44].setPosition(boardNum - 1, 'W');
                                    break;
                                case "8":
                                    cards[45].setPosition(boardNum - 1, 'W');
                                    break;
                                case "9":
                                    cards[46].setPosition(boardNum - 1, 'W');
                                    break;
                                case "T":
                                    cards[47].setPosition(boardNum - 1, 'W');
                                    break;
                                case "J":
                                    cards[48].setPosition(boardNum - 1, 'W');
                                    break;
                                case "Q":
                                    cards[49].setPosition(boardNum - 1, 'W');
                                    break;
                                case "K":
                                    cards[50].setPosition(boardNum - 1, 'W');
                                    break;
                                case "A":
                                    cards[51].setPosition(boardNum - 1, 'W');
                                    break;
                                default:
                                    System.out.println("Something went terribly wrong");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Something went super horribly wrong");
                            break;
                    }
                } else {
                    System.out.println("Something is broken beyond repair. Abandon all hope.");
                }
            }
        }
    }

    public void removeBoard(int boardNum) {
        boardCount--;

        for (int i = 0; i < cards.length; i++) {
            cards[i].position[boardNum] = '\0';
        }
        boards[boardNum].setLabel("");
    }
}
