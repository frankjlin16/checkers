package ui;

import core.CheckersLogic;

/**
 * CheckersTextConsole
 * 
 * @author Frank Lin
 * @version 1.0 pre-release
 */
public class CheckersTextConsole {

    private static final String rowIndex[] = {"8", "7", "6", "5","4", "3", "2", "1"};
    private static final String columnIndex[] = {"a", "b", "c", "d","e", "f","g", "h"};

    /** Game driver */
    public static void main(String[] args) {
        CheckersLogic game = new CheckersLogic();
        printBoard(game.getBoard());
    }

    /** Prints current state of the game
     * 
     * @param board
     */
    private static void printBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print(rowIndex[i]);
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" | " + board[i][j]);
            }
            System.out.println(" |\n");
        }
    }

    private static void requestMove() {

    }

    private static void printError() {

    }
}