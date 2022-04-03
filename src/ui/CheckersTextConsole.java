package ui;

import core.CheckersLogic;
import core.CheckersComputerPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * CheckersTextConsole
 * 
 * @author Frank Lin
 * @version 1.0 pre-release
 */
public class CheckersTextConsole {

    /** Row index of the game board */
    public static final String rowIndex[] = { "8", "7", "6", "5", "4", "3", "2", "1" };
    /** Column index of the game board */
    public static final String colIndex[] = { "a", "b", "c", "d", "e", "f", "g", "h" };

    /** Game driver */
    public static void main(String[] args) {
        // Initializes checker game
        CheckersLogic game = new CheckersLogic();
        // Initializes computer player
        CheckersComputerPlayer computer = new CheckersComputerPlayer(game);
        // Initializes Scanner
        Scanner kb = new Scanner(System.in);

        printBoard(game.getBoard());
        System.out.print("Begin Game. Player ");

        do {
            System.out.println(game.getActivePlayer() + " - your turn.");
            ArrayList<Integer> parsedInput;
            do {
                System.out.println("Choose a cell position of piece to be moved and the new position. e.g., 3a-4b");
                String input = kb.nextLine();
                parsedInput = parseInput(input);
                if (!game.isValid(parsedInput.get(0), parsedInput.get(1), parsedInput.get(2), parsedInput.get(3))) {
                    System.out.println("That's an illegal move! Try again. \n");
                }
            }while(!game.isValid(parsedInput.get(0), parsedInput.get(1), parsedInput.get(2), parsedInput.get(3)));
            
            // Update the board
            game.updateBoard(parsedInput.get(0), parsedInput.get(1), parsedInput.get(2), parsedInput.get(3));
            printBoard(game.getBoard());

        } while (game.isActive);

        System.out.println("Player " + game.getActivePlayer() + " Won the Game");

        kb.close();

    }

    /**
     * Prints current state of the game
     * 
     * @param board 2D string matrix of the current board state
     */
    public static void printBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print(rowIndex[i]);
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" | " + board[i][j]);
            }
            System.out.println(" |\n");
        }
        System.out.print(" ");
        for (String str : colIndex) {
            System.out.print("   " + str);
        }
        System.out.println("\n\n");
    }

    /**
     * Parses user input and returns ArrayList in Integer form
     * 
     * @param input user-input string
     * @return an ArrayList with the initial and final position in integer form
     */
    private static ArrayList<Integer> parseInput(String input) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        String delimiter = "-";
        String[] parsed = input.split(delimiter);
        for (String s : parsed) {
            char[] charArr = s.toCharArray();
            int row = 8 - Character.getNumericValue(charArr[0]);
            result.add(row);
            int col = Arrays.asList(colIndex).indexOf(Character.toString(charArr[1]));
            result.add(col);
        }
        return result;
    }
}