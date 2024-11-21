/**
 * Manages and executes a tournament of Tic Tac Toe games between two players.
 * A tournament consists of multiple rounds where players alternate between going first and second.
 * The tournament tracks scores and displays results after all rounds are completed.
 *
 * The tournament will:
 * 1. Alternate which player goes first each game
 * 2. Track wins for each player and ties
 * 3. Display final results after all rounds
 *
 * @see Player For the interface implemented by tournament participants
 * @see Game For the individual games played in the tournament
 * @see Renderer For displaying the game state
 */
public class Tournament {

    private int rounds;
    private Renderer renderer;
    private Player player1, player2;

    private static final String SCORE_BOARD_MESSAGE0 = "######### Results #########\n",
    SCORE_BOARD_MESSAGE1 = "Player 1, %s won: %d rounds\n",
    SCORE_BOARD_MESSAGE2 = "Player 2, %s won: %d rounds\n",
    SCORE_BOARD_MESSAGE3 = "Ties: %d\n";

    /**
     * Constructs a new tournament with specified number of rounds and players.
     *
     * @param rounds The number of games to be played in the tournament
     * @param renderer The renderer to use for displaying game states
     * @param player1 The first player in the tournament
     * @param player2 The second player in the tournament
     */
    Tournament(int rounds, Renderer renderer, Player player1, Player player2){
        this.rounds = rounds;
        this.renderer = renderer;
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Executes the tournament, playing the specified number of rounds between the two players.
     * Players alternate between going first and second each game. After all rounds are complete,
     * displays the tournament results including wins for each player and ties.
     *
     * @param size The size of the game board (size × size)
     * @param winStreak The number of consecutive marks needed to win
     * @param playerName1 Display name for the first player
     * @param playerName2 Display name for the second player
     */
    public void playTournament(int size, int winStreak, String playerName1, String playerName2){
        //called by main
        //at the end of the tournament print to board the results
        int gamesPlayed=0;
        int[] scores = new int[3];
        while(gamesPlayed<rounds){
            Game game;
            if (gamesPlayed%2 == 0) {
                game = new Game(player1, player2, size, winStreak, renderer);
            } else {
                game = new Game(player2, player1, size, winStreak, renderer);
            }
            Mark mark = game.run();
            score(scores, mark);
            gamesPlayed++;
        }
        printScores(scores, playerName1, playerName2);
    }

    /**
     * Entry point for running a tournament. Accepts command line arguments to configure
     * the tournament parameters and players.
     *
     * @param args Command line arguments in the following order:
     *             args[0] - Number of rounds to play
     *             args[1] - Board size (size × size)
     *             args[2] - Win streak length required
     *             args[3] - Renderer type
     *             args[4] - First player type
     *             args[5] - Second player type
     *
     * @throws NumberFormatException if the numeric arguments cannot be parsed as integers
     * @see PlayerFactory For available player types
     * @see RendererFactory For available renderer types
     */
    public static void main(String[] args){
         int rounds = Integer.parseInt(args[0]), size = Integer.parseInt(args[1]), win_streak =
                 Integer.parseInt(args[2]);

         RendererFactory rendererFactory = new RendererFactory();
         Renderer renderer = rendererFactory.buildRenderer(args[3], size);

         String player1String = args[4], player2String = args[5];

         PlayerFactory playerFactory = new PlayerFactory();
         Player player1 = playerFactory.buildPlayer(player1String);
         Player player2 = playerFactory.buildPlayer(player2String);

         Tournament tournament = new Tournament(rounds, renderer,player1 ,player2 );

         tournament.playTournament(size, win_streak, player1String, player2String);
    }



    private void printScores(int[] scores, String player1, String player2){
        //todo implement
        System.out.printf(SCORE_BOARD_MESSAGE0);
        System.out.printf(SCORE_BOARD_MESSAGE1, player1, scores[0]);
        System.out.printf(SCORE_BOARD_MESSAGE2, player2, scores[1]);
        System.out.printf(SCORE_BOARD_MESSAGE3, scores[2]);

    }
    private void score(int[] scores, Mark mark){
        switch (mark){
            case X:
                scores[0]++;
                break;
            case O:
                scores[1]++;
                break;
            default:
                scores[2]++;
                break;
        }
    }
}
