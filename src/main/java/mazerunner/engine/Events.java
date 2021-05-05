package mazerunner.engine;

public class Events {

    public static void CheckEvent(int value1){

        if(value1 == 2){
            Map.coin = Map.coin +1;
        }
        if(value1 == 3){
            Map.stamina =Map.stamina+4;
        }
        if(value1 == 4){
            System.out.println("trap");
        }
        if(Map.stamina == 1){
            System.out.println("ran out of stamina");
            System.exit(0);
        }
        }
    }

