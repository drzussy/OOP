/**
 * A strategic Tic Tac Toe player that makes intelligent moves based on the current board state.
 * The player follows a priority-based strategy:
 * 1. Win the game if possible by completing a streak
 * 2. Block opponent from winning
 * 3. Make strategic moves (center, corners)
 * 4. Make random moves as a last resort*
 * This implementation works with boards of any size n×n, where n is the board size.
 * The player doesn't maintain any state between moves and doesn't know the winning streak length.
 */
public class GeniusPlayer implements Player {
    /**
     * Constructs a new GeniusPlayer.
     * No initialization is needed as the player doesn't maintain state between moves.
     */
    GeniusPlayer() {}
    /**
     * Makes a move on the given board with the specified mark.
     * Follows a priority-based strategy to choose the best available move:
     * 1. Completes a line to win if possible
     * 2. Blocks opponent from winning
     * 3. Takes strategic positions (center, corners)
     * 4. Takes the first available empty space
     *
     * @param board The current game board to make a move on
     * @param mark The mark (X or O) to place on the board
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        if(extendsStreak(board, mark)){
            return;
        } else if (blockedOpponent(board, mark)) {
            return;
        } else if (madeStrategicMove(board, mark)) {
            return;
        } else {
            makeRandomMove(board, mark);
        }
    }

    private boolean extendsStreak(Board board, Mark mark) {
        // Check rows
        for (int i = 0; i < board.getSize(); i++) {
            if (tryCompleteLine(board, mark, i, 0, 0, 1)) return true; // horizontal
            if (tryCompleteLine(board, mark, 0, i, 1, 0)) return true; // vertical
        }
        // Check diagonals
        if (tryCompleteLine(board, mark, 0, 0, 1, 1)) return true; // main diagonal
        if (tryCompleteLine(board, mark, 0, board.getSize()-1, 1, -1)) return
                true; // anti-diagonal
        return false;
    }

    private boolean tryCompleteLine(Board board, Mark mark, int startRow, int startCol, int rowDelta,
                                    int colDelta) {
        int size = board.getSize();
        int markCount = 0;
        int emptyRow = -1, emptyCol = -1;

        for (int i = 0; i < size; i++) {
            int row = startRow + i * rowDelta;
            int col = startCol + i * colDelta;

            if (!isValidPosition(row, col, size)) break;

            Mark currentMark = board.getMark(row, col);
            if (currentMark == mark) {
                markCount++;
            } else if (currentMark == Mark.BLANK) {
                emptyRow = row;
                emptyCol = col;
            }
        }

        if (markCount == size - 1 && emptyRow != -1) {
            // Try to put the mark and verify success
            if (board.putMark(mark, emptyRow, emptyCol)) {
                return true;
            }
        }
        return false;
    }

    private boolean blockedOpponent(Board board, Mark mark) {
        Mark opponentMark = (mark == Mark.X) ? Mark.O : Mark.X;
        // Reuse extendsStreak logic but with opponent's mark
        for (int i = 0; i < board.getSize(); i++) {
            if (tryBlockLine(board, mark, opponentMark, i, 0, 0, 1)) return true; // horizontal
            if (tryBlockLine(board, mark, opponentMark, 0, i, 1, 0)) return true; // vertical
        }
        if (tryBlockLine(board, mark, opponentMark, 0, 0, 1, 1)) return true; // main diagonal
        if (tryBlockLine(board, mark, opponentMark, 0, board.getSize()-1, 1, -1)) return true;
        // anti-diagonal
        return false;
    }

    private boolean tryBlockLine(Board board, Mark myMark, Mark opponentMark, int startRow, int startCol,
                                 int  rowDelta, int colDelta) {
        int size = board.getSize();
        int opponentCount = 0;
        int emptyRow = -1, emptyCol = -1;

        for (int i = 0; i < size; i++) {
            int row = startRow + i * rowDelta;
            int col = startCol + i * colDelta;

            if (!isValidPosition(row, col, size)) break;

            Mark currentMark = board.getMark(row, col);
            if (currentMark == opponentMark) {
                opponentCount++;
            } else if (currentMark == Mark.BLANK) {
                emptyRow = row;
                emptyCol = col;
            }
        }

        if (opponentCount == size - 1 && emptyRow != -1) {
            // Try to put the mark and verify success
            if (board.putMark(myMark, emptyRow, emptyCol)) {
                return true;
            }
        }
        return false;
    }

    private boolean madeStrategicMove(Board board, Mark mark) {
        int size = board.getSize();
        int center = size / 2;

        // Try center first (best strategic position)
        if (board.getMark(center, center) == Mark.BLANK) {
            if (board.putMark(mark, center, center)) {
                return true;
            }
        }

        // Try corners next
        int[][] corners = {{0,0}, {0,size-1}, {size-1,0}, {size-1,size-1}};
        for (int[] corner : corners) {
            if (board.getMark(corner[0], corner[1]) == Mark.BLANK) {
                if (board.putMark(mark, corner[0], corner[1])) {
                    return true;
                }
            }
        }

        return false;
    }

    private void makeRandomMove(Board board, Mark mark) {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.getMark(i, j) == Mark.BLANK) {
                    if (board.putMark(mark, i, j)) {
                        return;
                    }
                }
            }
        }
    }

    private boolean isValidPosition(int row, int col, int size) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
}