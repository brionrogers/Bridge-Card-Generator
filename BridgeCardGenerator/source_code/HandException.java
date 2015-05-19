/*
v1.0

Class for error handling.

This class handles errors in the user input for each hand. If the input for each player's hand
is erronious in any way, this error catches and throws a prompt.
*/

public class HandException extends Exception {

    private static final long serialVersionUID = 1L;

    String str;

    public HandException() {
        str = "Hand must contain valid input! \n "
            + "2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, and A are the accepted values.\n";
    }
    
    public HandException(char c) {
        str = "Hand must contain valid input! \n "
            + "2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, and A are the accepted values.\n"
            + c + " is not allowed!";
    }

    public HandException(String value) {
        this.str = value;
    }

    @Override
    public String toString() {
        return str;
    }
}
