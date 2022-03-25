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
    private String activePlayers;
    /** Stores the current board position for the game. */
    private String[][] currentBoard;

    /**
     * Initializes the game logic.
     * Active player is set to X and board starting position is set.
     */
    public CheckersLogic() {
        activePlayers = "X";
        currentBoard = new String[][] {
                { "_", "X", "_", "X", "_", "X", "_", "X" },
                { "X", "_", "X", "_", "X", "_", "X", "_" },
                { "_", "X", "_", "X", "_", "X", "_", "X" },
                { "_", "_", "_", "_", "_", "_", "_", "_" },
                { "_", "_", "_", "_", "_", "_", "_", "_" },
                { "O", "_", "O", "_", "O", "_", "O", "_" },
                { "_", "O", "_", "O", "_", "O", "_", "O" },
                { "O", "_", "O", "_", "O", "_", "O", "_" },
        };
    }

    public boolean isValid() {
        return true;
    }

    private void changeActivePlayer() {
        if (activePlayers == "X")
            activePlayers = "O";
        else if (activePlayers == "O")
            activePlayers = "X";
    }

    public void updateBoard(int oldRow, int oldCol, int newRow, int newCol) {
        // Empty the old position
        currentBoard[oldRow][oldCol] = "_";

        // Update new position
        currentBoard[newRow][newCol] = activePlayers;

        // Change active players
        changeActivePlayer();
    }

    public boolean moreMoves() {
        if (activePlayers == "X") {
            for (String[] row : currentBoard) {
                if (Arrays.asList(row).contains("X"))
                    return true;
            }
        }

        return false;
    }

    public String[][] getBoard() {
        return currentBoard;
    }
}