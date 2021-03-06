package core;

import java.util.Arrays;

/**
 * CheckersLogic
 * 
 * Checker's game logic
 * 
 * @author Frank Lin
 * @version 1.0 pre-release
 */
public class CheckersLogic {
    /** Shows which player is the active player */
    private String activePlayer;
    /** Stores the current board position for the game. */
    private String[][] currentBoard;
    /** Is the game still active? */
    public boolean isActive;

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
        isActive = true;
    }

    /**
     * Check if a move is legal
     * 
     * @param oldRow row index of initial position
     * @param oldCol colume index of initial position
     * @param newRow row index of new position
     * @param newCol colume index of new position
     * @return true if the move is valid, false otherwise.
     * @throws IllegalArgumentException if the move is invalid
     */
    public boolean isValid(int oldRow, int oldCol, int newRow, int newCol) throws IllegalArgumentException {
        // Can't move opponent piece
        if (currentBoard[oldRow][oldCol] != activePlayer || currentBoard[newRow][newCol] == activePlayer) {
            return false;
        }
        // Can't be same columnIndex
        if (newCol == oldCol) {
            return false;
        }

        // Distance between columns can't be greater than 1
        if (newCol - oldCol > 1 || newCol - oldCol < -1) {
            return false;
        }

        // Distance between rows can't be greater than 1
        if (newRow - oldRow > 1 || newRow - oldRow < -1) {
            return false;
        }

        if (activePlayer == "X") {
            if (newRow < oldRow) {
                return true;
            }
        } else if (activePlayer == "O") {
            if (newRow > oldRow) {
                return true;
            }
        }
        return false;
    }

    /** Change the active player */
    public void changeActivePlayer() {
        if (activePlayer == "X")
            activePlayer = "O";
        else if (activePlayer == "O")
            activePlayer = "X";
    }

    /**
     * Update the game's board state
     * 
     * @param oldRow row index of initial position
     * @param oldCol colume index of initial position
     * @param newRow row index of new position
     * @param newCol colume index of new position
     */
    public void updateBoard(int oldRow, int oldCol, int newRow, int newCol) {
        // Empty the old position
        currentBoard[oldRow][oldCol] = "_";

        // Update new position
        currentBoard[newRow][newCol] = activePlayer;

        // Check Win/Lose
        isActive = moreMoves();

        // Change active players
        if (isActive)
            changeActivePlayer();
    }

    /**
     * Check if there are more moves left to be played
     * 
     * @return true if there are more moves left to be played, false otherwise.
     */
    public boolean moreMoves() {
        return piecesLeft();
    }

    /**
     * Check for no pieces left
     * 
     * @return false if no pieces left, otherwise true
     */
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

    /**
     * Get the latest board state
     * 
     * @return string matrix of the current board state
     */
    public String[][] getBoard() {
        return currentBoard;
    }

    /**
     * Get the current active player
     * 
     * @return string of the current active player
     */
    public String getActivePlayer() {
        return activePlayer;
    }
}