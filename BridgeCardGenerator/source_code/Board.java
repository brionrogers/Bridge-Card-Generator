/*
v1.0

Code for Board class.

*/

import java.util.ArrayList;
import java.io.Serializable;

public class Board implements Serializable {

    String boardLabel;
    String dealer;
    String notes;
    ArrayList<String> hands;
    
    //Default constructor for Board class
    public Board() {
        boardLabel = "";
        dealer = "";
        notes = "";
    }

    //Parameterized constructor for Board class
    public Board(String l, String d, String n) {
        boardLabel = l;
        dealer = d;
        notes = n;
    }

    //Setter for boardLabel
    public void setLabel(String l) {
        boardLabel = l;
    }

    //Getter for boardLabel
    public String getLabel() {
        return boardLabel;
    }

    //Setter for dealer
    public void setDealer(String d) {
        dealer = d;
    }

    //Getter for dealer
    public String getDealer() {
        return dealer;
    }

    //Setter for notes
    public void setNotes(String n) {
        notes = n;
    }

    //Getter for notes
    public String getNotes() {
        return notes;
    }

    //Setter for hands ArrayList
    public void setHands(ArrayList<String> list) {
        hands = list;
    }

    //Getter for hands ArrayList
    public ArrayList<String> getHands() {
        return hands;
    }
}
