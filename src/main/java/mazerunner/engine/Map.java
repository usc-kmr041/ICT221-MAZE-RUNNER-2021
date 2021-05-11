package mazerunner.engine;

import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class Map {
    Random rand = new Random();
    int a = rand.nextInt(2);
    int b = rand.nextInt(9);
    int[][] map = new int[10][10];
    int x = 9;
    int y = 0;
    public static int stamina = 99;
    public static int coin = 10;
    public static int trigger = 0;

    public void move() {
        // Controls the toon.//
        Scanner input = new Scanner(System.in);
        if (map[x][y] == map[a][b]) {
            System.out.println("\"OH! You have reached your destination! You finished with a score of "+Map.coin+".");
            System.exit(0);
        }
        System.out.println("Where do you want to go?");
        char move = input.next().charAt(0);

        switch(move){
            case 'u':
                if (x==0){
                    map[x][y] =1;
                    System.out.println("There is a wall blocking your path.");
                    move();
                    break;
                }

                Events.CheckEvent(map[x-1][y]);

                if (trigger == 2){
                    trigger = 3;
                }

                if (trigger == 0){
                    map[x-1][y] = 1;
                    map[x][y] =0;
                }


                if (trigger == 1){
                    map[x-1][y]=9;
                    map[x][y] =0;
                    trigger = 2;
                }

                if (trigger == 3){
                    map[x][y] = 4;
                    map[x-1][y]=1;
                    trigger = 0;
                }

                x=x-1;
                stamina --;
                PrintMap();

                break;

            case 'd':
                if (x==9){
                    map[x][y] =1;
                    System.out.println("There is a wall blocking your path.");
                    move();
                    break;
                }
                Events.CheckEvent(map[x+1][y]);

                if (trigger == 2){
                    trigger = 3;
                }

                if (trigger == 0){
                    map[x+1][y] = 1;
                    map[x][y] =0;
                }


                if (trigger == 1){
                    map[x+1][y]=9;
                    map[x][y] =0;
                    trigger = 2;
                }

                if (trigger == 3){
                    map[x][y] = 4;
                    map[x+1][y]=1;
                    trigger = 0;
                }

                x=x+1;
            //    map[x-1][y] = 0;
            //    map[x][y] =1;
            //    stamina --;
                PrintMap();
                break;
            case 'l':
                if (y==0) {
                    map[x][y] = 1;
                    System.out.println("There is a wall blocking your path.");
                    move();
                    break;
                }
                Events.CheckEvent(map[x][y-1]);

                if (trigger == 2){
                    trigger = 3;
                }

                if (trigger == 0){
                    map[x][y-1] = 1;
                    map[x][y] =0;
                }


                if (trigger == 1){
                    map[x][y-1]=9;
                    map[x][y] =0;
                    trigger = 2;
                }

                if (trigger == 3){
                    map[x][y] = 4;
                    map[x][y-1]=1;
                    trigger = 0;
                }


                y=y-1;
                //map[x][y+1] = 0;
                //map[x][y] =1;
                stamina --;
                PrintMap();
                break;
            case 'r':
                if (y==9){
                    map[x][y] =1;
                    System.out.println("There is a wall blocking your path.");
                    move();
                    break;
                }
                Events.CheckEvent(map[x][y+1]);

                if (trigger == 2){
                    trigger = 3;
                }

                if (trigger == 0){
                    map[x][y+1] = 1;
                    map[x][y] =0;
                }


                if (trigger == 1){
                    map[x][y+1]=9;
                    map[x][y] =0;
                    trigger = 2;
                }

                if (trigger == 3){
                    map[x][y] = 4;
                    map[x][y+1]=1;
                    trigger = 0;
                }


                y=y+1;
                //map[x][y-1] = 0;
                //map[x][y] =1;
                stamina --;
                PrintMap();
                break;

            default:
                System.out.println("That is not a valid response");
                move();
        }
    }

    public static void shuffle(int[][] completemap, int columns, Random rnd) {
        int size = completemap.length * columns;
        for (int i = size; i > 1; i--) {
            swap(completemap, columns, i - 1, rnd.nextInt(i));
        }
    }

    public static void swap(int[][] completemap, int columns, int i, int j) {
        int tmp = completemap[i / columns][i % columns];
        completemap[i / columns][i % columns] = completemap[j / columns][j % columns];
        completemap[j / columns][j % columns] = tmp;

    }

    public void GenerateMap() {
        // Map is generated to meet criteria for assessment. Changed the behaviour of the exit so that it only spawns on the top 3 columns of the grid.//
        Scanner input = new Scanner(System.in);
        System.out.println("Set difficulty 0-10:");
        int response = input.nextInt();
        GenerateElements(5,2);
        GenerateElements(10 - response,3);
        GenerateElements(response,4);
        shuffle(map,10,new Random());
        map[x][y] =1;
        map[a][b] =5;

            //System.out.println(Arrays.deepToString(map));
        }

    public void PrintMap(){
        System.out.println("You take a look at your map:");
        for (int[] row : map) {
            StringJoiner sj = new StringJoiner("|");
            for (int col : row) {
                sj.add(String.format("%02d", col));
            }
            System.out.println(sj.toString());
        }
            System.out.println("you have "+stamina+" stamina left.");
            System.out.println("You have collected "+coin+" coins.");

        }

    public void GenerateElements(int quantity,int type){

        for (int i = 0; i < quantity; i++){
            map[type][i] = type;
        }

    }
}

