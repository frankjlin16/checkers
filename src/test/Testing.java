package test;

import core.CheckersComputerPlayer;

public class Testing {

    static String[][] currentBoard = new String[][] {
        { "_", "O", "_", "O", "_", "O", "_", "O" },
        { "O", "_", "O", "_", "O", "_", "O", "_" },
        { "_", "O", "_", "O", "_", "O", "_", "O" },
        { "_", "_", "_", "_", "_", "_", "_", "_" },
        { "_", "_", "_", "_", "_", "_", "_", "_" },
        { "X", "_", "X", "_", "X", "_", "X", "_" },
        { "_", "X", "_", "X", "_", "X", "_", "X" },
        { "X", "_", "X", "_", "X", "_", "X", "_" },
};

    public static void main(String[] args) {
        CheckersComputerPlayer player = new CheckersComputerPlayer();
        player.searchMovablePieces(currentBoard);

    }
    
}
