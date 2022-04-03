package test;

import core.CheckersComputerPlayer;
import core.CheckersLogic;

public class Testing {

    public static void main(String[] args) {
        CheckersLogic game = new CheckersLogic();
        CheckersComputerPlayer player = new CheckersComputerPlayer(game);

        game.changeActivePlayer();
        player.searchMovablePieces(game.getBoard());
        System.out.println(player.getMovablePieces());
    }

}
