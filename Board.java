/**
 * A Board of size <i>size * size</i>. This class is intended for use in a game of Tic Tac Toe.
 * players will access the board, check its state and based on the players strategy, will attempt to place a
 * mark of type Mark.
 * @field size - size of board defined by the user.
 * @field board - a two dimensional array of Mark enums.
 * @method getSize - returns size of board
 * @method PutMark - will attempt to place mark on board
 * @method getMark - will return the mark of a specified place on the board
 *
 * @author
 */
public class Board {
    private int size;
    public Mark[][] board;
    private static final int defaultSize = 3;
    public Board() {
        /**
         * define new empty board in of default size <i>3 * 3</i> (n=3)
         */
        this.size = defaultSize;
//        todo define actual board
        board = makeBoard();
    }

    /**
     *
     * @param size
     * initialize empty board of size: <i>size * size</i>
     */
    public Board(int size){
        this.size = size;
        board = makeBoard();
    }

    private Mark[][] makeBoard(){
        Mark[][] board = new Mark[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Mark.BLANK;
            }
        }
        return board;
    }

    /**
     * @return size of this instance of board
     */
    public int getSize(){
        return size;
    }

    /**
     * Will attempt to put mark in place <i>[row][col]</i> of board based on the game rules and current
     * state of board.
     * @param mark
     * @param row
     * @param col
     * @return true if succeeded to place mark, else false;
     */
    public boolean putMark(Mark mark, int row, int col){
        //check valid coordinates
        if(!(0<=row && row <size) || !(0<=col && col <size)){

            return false;
        }
        // check that selected space is BLANK
        else if(getMark(row, col) != Mark.BLANK){
            return false;
        }
        else{
            board[row][col] = mark;
            return true;
        }
    }


    /**
     * returns Mark of place <i>[row][col]</i> of board.
     * @param row
     * @param col
     * @return
     */
    public Mark getMark(int row, int col){
        return board[row][col];
    }
}
