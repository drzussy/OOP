import javax.swing.*;

/**
 * Runs <i>rounds</i> amount of rounds, Games (a tournament) between 2 players (player1 player2).
 */
public class Tournament {
    private int rounds;
    private Renderer renderer;
    private Player player1, player2;
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

    }
    public static void main(String args[]){

    }

    private void printScores(){
        //todo implement
    }
}
