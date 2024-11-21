/**
 * A single Game with a winStreak k.
 */
public class Game {
    private Player playerX, playerO;
    private Renderer renderer;
    private int boardSize, winStreak;
    private static final int defaultSize = 4, defaultWinStreak = 3;


    Game(Player playerX, Player playerO, Renderer renderer){
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        boardSize = defaultSize;
        winStreak = defaultWinStreak;

    }
    Game(Player playerX, Player playerO, int size, int winstreak, Renderer renderer){
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.boardSize = size;
        this.winStreak = winstreak;
    }
    public int getWinStreak(){
        return winStreak;
    }
    public int getBoardsize(){
        return boardSize;
    }

    /**
     * run a single game, from begining to end.
     * @return Mark of winning player
     */
    public Mark run(){
        Board board = new Board(boardSize);
        Mark winningMark = null;

        //alternate turns between X and O player, checking after each turn if game is over.
        while(winningMark == null){
            winningMark =  runPlayer(board, playerX, Mark.X);
            // check if playerX won
            if(winningMark != null){
                break;
            }
            winningMark = runPlayer(board, playerO, Mark.O);
        }
        return winningMark;
    }
    private boolean checkWin(Mark[][] board, int k){
            int rows = boardSize, cols = boardSize;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // Check for streak starting at (i, j) in various directions
                    if (board[i][j] != Mark.BLANK &&
                            (checkDirection(board, i, j, k, 0, 1) ||  // Horizontal
                                    checkDirection(board, i, j, k, 1, 0) ||  // Vertical
                                    checkDirection(board, i, j, k, 1, 1) ||  // Diagonal \
                                    checkDirection(board, i, j, k, 1, -1)))  // Diagonal /
                    {
                        return true;
                    }
                }
            }
            return false;
    }

    private Mark runPlayer(Board board, Player player, Mark mark){
        if(checkBoardFull(board)){
            return Mark.BLANK;
        }
        player.playTurn(board,mark);
        if(checkWin(board.board, winStreak)){
            renderer.renderBoard(board);
            return mark;
        }
        renderer.renderBoard(board);
        return null;
    }

    private boolean checkBoardFull(Board board){
        for(Mark[] row: board.board){
            for(Mark mark: row){
                if(mark == Mark.BLANK){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean checkDirection(Mark[][] matrix, int startRow, int startCol, int k, int rowDir, int colDir) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Mark target = matrix[startRow][startCol];

        for (int step = 1; step < k; step++) {
            int newRow = startRow + step * rowDir;
            int newCol = startCol + step * colDir;

            // Check if we are out of bounds or if the mark doesn't match
            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || matrix[newRow][newCol] != target) {
                return false;
            }
        }
        return true;
    }
}

