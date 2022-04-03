package test;

import core.CheckersComputerPlayer;
import core.CheckersLogic;
import ui.CheckersTextConsole;

public class Testing {

    public static void main(String[] args) {
        CheckersLogic game = new CheckersLogic();
        CheckersComputerPlayer player = new CheckersComputerPlayer(game);

        game.changeActivePlayer();
        CheckersTextConsole.printBoard(game.getBoard());
        player.searchMovablePieces(game.getBoard());
        player.move();
        CheckersTextConsole.printBoard(game.getBoard());
    }

}
