/**
 * A factory class that creates `Player` objects based on the given type.
 * The factory supports creating different types of players, such as a human player or various AI players.
 */
public class PlayerFactory {

    /**
     * A factory class that creates `Player` objects based on the given type.
     * The factory supports creating different types of players, such as a human player or various AI players.
     */
    PlayerFactory(){}

    /**
     * Builds and returns a `Player` object based on the specified type.
     * The type determines which type of player to create:
     * - "whatever" creates an instance of `WhateverPlayer`.
     * - "clever" creates an instance of `CleverPlayer`.
     * - "genius" creates an instance of `GeniusPlayer`.
     * - Any other type (including null or unspecified) creates an instance of `HumanPlayer`.
     *
     * @param type The type of player to create (e.g., "whatever", "clever", "genius", or others).
     * @return A `Player` object corresponding to the given type.
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
