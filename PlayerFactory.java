/**
 * A factory that creates Player objects based on
 */
public class PlayerFactory {
    PlayerFactory(){}

    /**
     *
     * @param type - type of player to be created
     * @return refrence to chosen player object
     */
    public Player buildPlayer(String type){
        //todo fill out params
        Player player;
        return switch (type) {
            case "whatever" -> new WhateverPlayer();
            case "clever" -> new CleverPlayer();
            case "genius" -> new GeniusPlayer();
            default -> new HumanPlayer();
        };

    }
}
