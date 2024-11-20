/**
 * represents specific logic or strategies to play by during a turn given a board.
 *
 */
public interface Player {
    public playTurn(Board board, Mark mark);
}
