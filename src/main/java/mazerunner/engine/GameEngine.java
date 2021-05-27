package mazerunner.engine;

import java.util.Scanner;

public class GameEngine {

    /**
     * An example board to store the current game state.
     *
     * Note: depending on your game, you might want to change this from 'int' to String or something?
     */
    private int[][] map;

    /**
     * Creates a square game board.
     *
     * @param size the width and height.
     */
    public GameEngine(int size) {
        map = new int[size][size];
    }

    /**
     * The size of the current game.
     *
     * @return this is both the width and the height.
     */
    public int getSize() {
        return map.length;
    }

    /**
     * Plays a text-based game
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean win = true;
            Map Map = new Map();
            System.out.println("Set difficulty 0-10:");
            int difficulty = input.nextInt();
            Map.GenerateMap(difficulty);
            Map.PrintMap();

            do{

                char move = input.next().charAt(0);
                Map.move(move);
                Map.PrintMap();

            } while (win);

        System.out.println("win");

    }
}