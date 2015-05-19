/*
v1.0

Code for Card class.

*/

import java.io.Serializable;

public class Card implements Serializable {

    public char value;
    public char suit;
    public char[] position;
    
    //Default constructor for Card class
    public Card() {
        value = '\0';
        suit = '\0';
        position = new char[36];

        for (int i = 0; i < position.length; i++) {
            position[i] = '\0';
        }
    }
    
    //Setter for value
    public void setValue(char v) {
        value = v;
    }

    //Getter for value
    public char getValue() {
        return value;
    }

    //Setter for suit
    public void setSuit(char s) {
        suit = s;
    }

    //Getter for suit
    public char getSuit() {
        return suit;
    }

    //Setter for position
    public void setPosition(int i, char p) {
        position[i] = p;
    }

    //Getter for position
    public char getPosition(int i) {
        return position[i];
    }

    //toString method to change the character into a String
    public String toString(char[] p) {
        return new String(p);
    }
}
