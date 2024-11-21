import java.util.Random;

/**
 * A Player that implements a strategy that'll almost always beat a WhateverPlayer
 */
public class CleverPlayer implements Player{
//    todo implement
    Random random = new Random();
    Player[] players = new Player[]{new WhateverPlayer(), new GeniusPlayer()};
    CleverPlayer(){};

    /**
     * will partially play with strategy, will win roughly 55% of the time
     * @param board
     * @param mark
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        //get random value, based on
        int randomValue = random.nextInt();
        players[randomValue%2].playTurn(board, mark);
    }
}
