package ui;

import core.CheckersLogic;
import java.util.Scanner;

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
        // Initializes checker game
        CheckersLogic game = new CheckersLogic();
        Scanner kb = new Scanner(System.in);

        printBoard(game.getBoard());
        System.out.print("Begin Game. Player ");

        do {
            System.out.println(game.getActivePlayer() + " - your turn.");
            System.out.println("Choose a cell position of piece to be moved and the new position. e.g., 3a-4b");
            String input = kb.nextLine();
            int parsedInput[] = parseInput(input);
            game.updateBoard(parsedInput[0], parsedInput[1], parsedInput[2], parsedInput[3]);
            printBoard(game.getBoard());

        }while (game.moreMoves());

        kb.close();
        
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
        System.out.print(" ");
        for (String str : columnIndex) {
            System.out.print("   " + str);
        }
        System.out.println("\n\n");
    }

    private static void requestMove() {

    }

    private static void printError() {

    }

    private static int[] parseInput(String input) {
        String delimiter = "-";
        String[] parsed = input.split(delimiter);
        System.out.println(parsed[0] + " " + parsed[1]);
        return new int[] {5,0,4,1};
    }
}