import java.util.Random;

/**
        * A strategic player implementation that combines random and intelligent gameplay approaches
 * to achieve a moderate win rate. This player alternates between two different playing styles:
        * a basic approach (WhateverPlayer) and an intelligent approach (GeniusPlayer).
        *
        * <p>The implementation is specifically designed to achieve approximately a 55% win rate by
 * using a probability-based strategy selection system. Each turn, it decides whether to play
 * as a basic player or an intelligent player based on preset probabilities.</p>
        */
public class CleverPlayer implements Player{
    Random random = new Random();
    Player[] players = new Player[]{new WhateverPlayer(), new GeniusPlayer()};
    CleverPlayer(){};

    /**
     * Executes a move on the given board using a probability-based strategy selection.
     * This method has a 50% chance of playing like a WhateverPlayer (basic moves) and
     * a 50% chance of playing like a GeniusPlayer (optimal moves).
     *
     * <p>The strategy selection is determined using a random number generator:
     * - If the random value is less than 0.45, it plays using WhateverPlayer's strategy
     * - Otherwise, it plays using GeniusPlayer's strategy</p>
     *
     * @param board the game board on which to make a move
     * @param mark the mark (typically X or O) to place on the board
     * @see Board
     * @see Mark
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        //get random value, based on
        int randomValue = Math.abs(random.nextInt()%2);

        players[randomValue].playTurn(board, mark);
    }


}
