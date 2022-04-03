package core;

import java.util.Arrays;

/**
 * CheckersComputerPlayer
 * 
 * A computer player that can play checkers against a real player
 * 
 * @author Frank Lin
 * @version 1.0 pre-release
 */

public class CheckersComputerPlayer {
    // Defines variables
    /** A string array that is used to contain all movable pieces */
    private String[] movablePieces;

    /** Constuctor for CheckersComputerPlayer */
    public CheckersComputerPlayer() {
    }

    /**
     * Find the movable pieces for the computer player and put them into
     * movablePieces array.
     * 
     * @param currentBoard
     */
    public void searchMovablePieces(String[][] currentBoard) {
        for (int i = 0; i < currentBoard.length; i++) { // Loop each row of the board
            if (Arrays.asList(currentBoard[i]).contains("O")) { // Enter the row is the row contains "O"
                for (int j = 0; j < currentBoard[i].length; j++) { // Loop each item of the row
                    if (currentBoard[i][j].equals("O")) { // Enter if the item is "O"
                        System.out.println(i + " " + j + " ");
                    }
                }
            }
        }
    }

    /**
     * Check is the movablePieces array is empty.
     * 
     * @return true is the movablePieces array is empty. Otherwise false.
     */
    public boolean isMovableEmpty() {
        return movablePieces == null;
    }
}
