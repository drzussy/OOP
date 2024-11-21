

/**
 * Runs <i>rounds</i> amount of rounds, Games (a tournament) between 2 players (player1 player2).
 */
public class Tournament {

    private int rounds;
    private Renderer renderer;
    private Player player1, player2;

    private static final String SCORE_BOARD_MESSAGE0 = "######### Results #########\n",
    SCORE_BOARD_MESSAGE1 = "Player 1, %s won: %d rounds\n",
    SCORE_BOARD_MESSAGE2 = "Player 2, %s won: %d rounds\n",
    SCORE_BOARD_MESSAGE3 = "Ties: %d\n";
    Tournament(int rounds, Renderer renderer, Player player1, Player player2){
        this.rounds = rounds;
        this.renderer = renderer;
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * implements logic of rounds and calls to game
     * @param size - size of board that game is played on(?)
     * @param winStreak - length of identical marks that consitute a victory
     * @param playerName1  - must be a type of player
     * @param playerName2  - must be a type of player
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
                game = new Game(player1, player2, size, winStreak, renderer);
            }
            Mark mark = game.run();
            score(scores, mark);
            gamesPlayed++;
        }
        printScores(scores, playerName1, playerName2);
    }
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
    private int[] score(int[] scores, Mark mark){
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
        return scores;
    }
}
