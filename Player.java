/**
 * represents specific logic or strategies to play by during a turn given a board.
 *
 */
public interface Player {
    /**
     * plays a turn implementing a players strategy
     * @param board
     * @param mark
     */
    public void playTurn(Board board, Mark mark);
}
