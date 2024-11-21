import java.util.Random;

/**
 * A Player whos strategy is to place marks randomly on a Board
 */
public class WhateverPlayer implements Player {
    //todo implement

    // implement random field
    private static final Random random = new Random();
    WhateverPlayer(){};
    public void playTurn(Board board, Mark mark){
        // get two random ints for col within board limit
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
