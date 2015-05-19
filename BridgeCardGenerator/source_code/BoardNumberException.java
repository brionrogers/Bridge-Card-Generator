/*
v1.0

Class for error handling.

This class handles the error of a user entering a noninteger in the 'Board #' text field.
If a user enters a noninteger, the program prompts them saying that Board Number must
be an integer.
*/

public class BoardNumberException extends Exception {

    private static final long serialVersionUID = 1L;

    String str;

    public BoardNumberException() {
        str = "Board Number must be between 1 and 36!";
    }

    public BoardNumberException(String value) {
        this.str = value;
    }

    @Override
    public String toString() {
        return str;
    }

}
