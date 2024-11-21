

/**
 * Represents a human player in a game.
 * A HumanPlayer interacts with the game by inputting coordinates to place a mark on the game board.
 */

public class HumanPlayer implements Player{
    private static final String PROMPT = "Player %s, type coordinates:", INVALID_MSG = "Invalid mark " +
            "position. Please choose a valid position:", NOT_BLANK = "Mark position is already occupied. " +
            "Please choose a valid postion:";
    /**
     * Constructs a new HumanPlayer.
     * The constructor initializes a HumanPlayer object that will be used to interact with the game.
     */
    HumanPlayer(){
    }

    /**
     * play a human users turn.
     * Requests the human player to provide coordinates for their move and places the player's mark on the
     * board.
     * If the player selects an invalid or occupied position, they will be prompted to enter new coordinates.
     *
     * @param board The game board on which the player will place their mark.
     * @param mark The mark (e.g., X or O) representing the player's move.
     */
    @Override
    public void playTurn(Board board, Mark mark){

        //request coordinates from user
        System.out.printf(PROMPT, mark);
        int[] input = getCoordinates();

        while(!board.putMark(mark, input[0], input[1])){
            //else print message on board and wait for new coordinates
            if(board.board[input[0]][input[1]] != Mark.BLANK){
                System.out.printf(NOT_BLANK);
            }
            else{
                System.out.printf(INVALID_MSG);
            }
            input = getCoordinates();
        }
    }



    private int[] getCoordinates(){
        int inputRaw = KeyboardInput.readInt();
        return new int[] {inputRaw/10, inputRaw%10};
    }
}
