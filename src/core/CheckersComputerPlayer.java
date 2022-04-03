package core;

import java.util.Arrays;
import java.util.ArrayList;

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
    private ArrayList<Pair> movablePieces;
    private CheckersLogic game;

    /**
     * Constructor for the CheckersComputerPlayer
     * 
     * @param game game logic for the active game
     */
    public CheckersComputerPlayer(CheckersLogic game) {
        this.game = game;
    }

    /**
     * Find the movable pieces for the computer player and put them into
     * movablePieces array.
     * 
     * @param currentBoard the current checker board position
     */
    public void searchMovablePieces(String[][] currentBoard) {
        if (!isMovableEmpty()) { // Clear movablePieces is the array is not empty.
            movablePieces = null;
        }
        for (int i = 0; i < currentBoard.length - 1; i++) { // Loop each row of the board (but not the last row)
            if (Arrays.asList(currentBoard[i]).contains("O")) { // Enter the row is the row contains "O"
                for (int j = 0; j < currentBoard[i].length; j++) { // Loop each item of the row
                    if (currentBoard[i][j].equals("O")) { // Enter if the item is "O"
                        int newCol1;
                        int newCol2;
                        if (j == 0) { // If the piece is on the 0 col, only check +1 position
                            newCol1 = j + 1;
                            newCol2 = newCol1;
                        } else if (j == 7) { // If the piece is on the 7 col, only check -1 position
                            newCol1 = j - 1;
                            newCol2 = newCol1;
                        } else { // Else, check both +1 and -1 possition
                            newCol1 = j + 1;
                            newCol2 = j - 1;
                        }
                        if (game.isValid(i, j, i + 1, newCol1) || game.isValid(i, j, i + 1, newCol2)) {
                            movablePieces.add(new Pair(i, j));
                        }
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

    /**
     * Get the movable pieces' coordinates
     * 
     * @return an ArrayList that contains the movable pieces' coordinates
     */
    public ArrayList<Pair> getMovablePieces() {
        return movablePieces;
    }

    /** A class that represents a movable piece's coordinates */
    class Pair {
        int row;
        int col;

        /**
         * Constructor for the Pair class
         * 
         * @param row the row index of the piece
         * @param col the column index of the piece
         */
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }
}
