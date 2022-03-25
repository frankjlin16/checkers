package core;

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
    private char activePlayers;
    /** Stores the current board position for the game. */
    private String[][] currentBoard;

    /**
     * Initializes the game logic.
     * Active player is set to X and board starting position is set.
     */
    public CheckersLogic() {
        activePlayers = 'X';
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

    }

    public void updateBoard() {}
    
    private boolean gridOccupiedByOpponent() { return false; }

    public boolean moreMoves() { return true; }

    public String[][] getBoard() { return currentBoard; }
}