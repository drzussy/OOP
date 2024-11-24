import java.util.Random;

/**
 * A `Player` whose strategy is to place marks randomly on the game board.
 * This class implements the `Player` interface
 */
public class WhateverPlayer implements Player {

    // implement random field
    private static final Random random = new Random();
    /**
     * Constructs a new `WhateverPlayer`.
     * This constructor initializes a `WhateverPlayer` instance that can make random moves on the board.
     */
    WhateverPlayer(){}

    /**
     * Makes a random move on the given board by selecting random coordinates and placing the player's mark.
     * The method continues to select random coordinates until a valid move is found (i.e., the spot is
     * empty).
     *
     * @param board The game board on which the player's move will be made.
     * @param mark The mark (X or O) representing the current player.
     */
    @Override
    public void playTurn(Board board, Mark mark){
        // get two random integers for col within board limit
        int size = board.getSize();
        int[] input = getCoordinates(size);
        while(!board.putMark(mark, input[0], input[1])){
            input = getCoordinates(size);
        }
    }

    /*
    getCoordinates returns an int array of size two with random integers smaller than size.
     */
    private int[] getCoordinates(int size){
        return new int[] {random.nextInt(size),random.nextInt(size)};
    }


}
