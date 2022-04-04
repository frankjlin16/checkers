package core;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

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
    /** Define variable that will hold game logic */
    private CheckersLogic game;

    /**
     * Constructor for the CheckersComputerPlayer
     * 
     * @param game game logic for the active game
     */
    public CheckersComputerPlayer(CheckersLogic game) {
        this.game = game;
        this.movablePieces = new ArrayList<Pair>();
    }

    /**
     * Find the movable pieces for the computer player and put them into
     * movablePieces array.
     * 
     * @param currentBoard the current checker board position
     */
    public void searchMovablePieces(String[][] currentBoard) {
        movablePieces.clear();
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
                        try {
                            if (game.isValid(i, j, i + 1, newCol1) || game.isValid(i, j, i + 1, newCol2)) {
                                movablePieces.add(new Pair(i, j));
                            }
                        } catch (Exception e) {
                        }

                    }
                }
            }
        }
    }

    /**
     * Select a random piece from movablePieces and move it to a legal new position
     */
    public void move() {
        Random rand = new Random();
        // Pick a random piece from movablePieces
        Pair p = movablePieces.get(rand.nextInt(movablePieces.size()));
        // Get old position
        int oldRow = p.getRow();
        int oldCol = p.getCol();
        // Figure out new position
        int newRow = oldRow + 1;
        int newCol;
        if (oldCol == 0) {
            newCol = oldCol + 1;
        } else if (oldCol == 7) {
            newCol = oldCol - 1;
        } else {
            if (rand.nextInt(2) == 1) {
                newCol = oldCol + 1;
            } else {
                newCol = oldCol - 1;
            }
        }

        // Validate Move
        try {
            game.isValid(oldRow, oldCol, newRow, newCol);
        } catch (Exception e) {
            System.out.println("Computer Error: From (" + oldRow + ", " + oldCol + ") to (" + newRow + ", " + newCol + ")");
            throw e;
        }
        // Update board with move
        game.updateBoard(oldRow, oldCol, newRow, newCol);
    }

    /**
     * Get the movable pieces' coordinates
     * 
     * @return an ArrayList that contains the movable pieces' coordinates
     */
    public ArrayList<Pair> getMovablePieces() {
        return movablePieces;
    }

    /** A inner-class that represents a movable piece's coordinates */
    private class Pair {
        /** The row coodinate for the checker piece */
        private int row;
        /** The column coodinate for the checker piece */
        private int col;

        /**
         * Constructor for the Pair class
         * 
         * @param row the row index of the piece
         * @param col the column index of the piece
         */
        private Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        /**
         * Get the row of the piece
         * 
         * @return an int that represents the row of the piece
         */
        public int getRow() {
            return row;
        }

        /**
         * Get the column of the piece
         * 
         * @return an int that represents the column of the piece
         */
        public int getCol() {
            return col;
        }

        /** Returns the string representation of this object */
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }
}
