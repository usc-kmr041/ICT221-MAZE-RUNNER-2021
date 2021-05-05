package mazerunner.engine;

public class Events {

    public static void CheckEvent(int value1){

        if(value1 == 2){
            System.out.println("coin");
        }
        if(value1 == 3){
            System.out.println("apples");
        }
        if(value1 == 4){
            System.out.println("trap");
        }
    }

}