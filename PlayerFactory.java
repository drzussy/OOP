/**
 * A factory that creates Player objects based on
 */
public class PlayerFactory {
    PlayerFactory(){

    }

    /**
     *
     * @param type - type of player to be created
     * @return refrence to chosen player object
     */
    public Player buildPlayer(String type){
        //todo fill out params
        Player player;
        switch(type){
            case "whatever":
                player = new WhateverPlayer();
            case "clever":
                player = new CleverPlayer();
            case "genius":
                player = new GenuisPlayer();
            default:
                player = new HumanPlayer();


        }
        return player;

    }
}
