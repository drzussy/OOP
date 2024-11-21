

/**
 * represents a human Player.
 */

public class HumanPlayer implements Player{
    private static final String PROMPT = "Player %s, type coordinates:", INVALID_MSG = "Invalid mark " +
            "position. Please choose a valid position:", NOT_BLANK = "Mark position is already occupied. " +
            "Please choose a valid postion:";
    HumanPlayer(){
    }

    /**
     * todo write this shit
     * @param board
     * @param mark
     */
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
