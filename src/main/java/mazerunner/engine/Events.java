package mazerunner.engine;

public class Events extends Map {

    public static void CheckEvent(int value1) {

        if (value1 == 2) {
            System.out.println("You collected a gold coin. Shiny!");
            Map.coin = Map.coin + 1;
        }
        if (value1 == 3) {
            System.out.println("You ate an apple. Stamina recovered by 3.");
            Map.stamina = Map.stamina + 4;
        }
        if (value1 == 4) {
            System.out.println("You stepped on a trap.");
            Map.coin = Map.coin - 1;
            if (Map.coin > -1) {
                trigger = 1;
                System.out.println("You sacrificed a coin to the gods to get out.");
            }


        }
        if (Map.stamina == 1) {
            System.out.println("You ran out of stamina. You passed out! Game over.");
            System.exit(0);
        }
        if (Map.coin == -1) {
            System.out.println("The trap ripped your heart out. Game over.");
            System.exit(0);
        }

    }

}