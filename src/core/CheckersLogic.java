package core;

import java.util.Arrays;

/**
 * Checkers
 * 
 * Checker's game logic
 * 
 * @author Frank Lin
 * @version 1.0 pre-release
 */
public class CheckersLogic {
    /** 0 is player X's turn. 1 is player O's turn. */
    private String activePlayer;
    /** Stores the current board position for the game. */
    private String[][] currentBoard;

    /**
     * Initializes the game logic.
     * Active player is set to X and board starting position is set.
     */
    public CheckersLogic() {
        activePlayer = "X";
        currentBoard = new String[][] {
                { "_", "O", "_", "O", "_", "O", "_", "O" },
                { "O", "_", "O", "_", "O", "_", "O", "_" },
                { "_", "O", "_", "O", "_", "O", "_", "O" },
                { "_", "_", "_", "_", "_", "_", "_", "_" },
                { "_", "_", "_", "_", "_", "_", "_", "_" },
                { "X", "_", "X", "_", "X", "_", "X", "_" },
                { "_", "X", "_", "X", "_", "X", "_", "X" },
                { "X", "_", "X", "_", "X", "_", "X", "_" },
        };
    }

    public boolean isValid(int oldRow, int oldCol, int newRow, int newCol) {
        // Can't be same columnIndex
        if (newCol == oldCol)
            return false;
        // Distance between colums can't be greater than 1
        if (Math.sqrt(newCol - oldCol) > 1)
            return false;
        if (activePlayer == "X") {
            if (newRow > oldRow) {
                return true;
            }
        } else if (activePlayer == "O") {
            if (newRow < oldRow) {
                return true;
            }
        }
        return false;
    }

    private void changeActivePlayer() {
        if (activePlayer == "X")
            activePlayer = "O";
        else if (activePlayer == "O")
            activePlayer = "X";
    }

    public void updateBoard(int oldRow, int oldCol, int newRow, int newCol) {
        // Empty the old position
        currentBoard[oldRow][oldCol] = "_";

        // Update new position
        currentBoard[newRow][newCol] = activePlayer;

        // Change active players
        changeActivePlayer();
    }

    public boolean moreMoves() {
        // TODO: Need to check if any legal moves are left
        return piecesLeft();
    }

    private boolean piecesLeft() {
        // If current player is X, search each row for O. If O is not found, move to the
        // next row. If O is found, return true.
        if (activePlayer == "O") {
            for (String[] row : currentBoard) {
                if (Arrays.asList(row).contains("X"))
                    return true;
            }
        } else if (activePlayer == "X") {
            for (String[] row : currentBoard) {
                if (Arrays.asList(row).contains("O"))
                    return true;
            }
        }
        // If none are found, return false
        return false;
    }

    public String[][] getBoard() {
        return currentBoard;
    }

    public String getActivePlayer() {
        return activePlayer;
    }
}