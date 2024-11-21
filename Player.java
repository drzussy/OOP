/**
 * represents specific logic or strategies to play by during a turn given a board.
 *
 */
public interface Player {
    public void playTurn(Board board, Mark mark);
}
