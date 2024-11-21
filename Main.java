public class Main {
    public static void main(String[] args){
        ConsoleRenderer renderer1=new ConsoleRenderer(4);
        Player x=new WhateverPlayer();
        Player o=new GeniusPlayer();
        Game game = new Game(x, o, 4, 3, renderer1);
        game.run();
    }
}
