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
    public static int stamina = 12;
    public static int coin = 0;


    public void move() {
        Scanner input = new Scanner(System.in);
        System.out.println("Where do you want to go?");
        char move = input.next().charAt(0);

        switch(move){
            case 'u':
                Events.CheckEvent(map[x-1][y]);
                x=x-1;
                map[x+1][y] = 0;
                map[x][y] =1;
                stamina --;
                PrintMap();
                break;

            case 'd':
                Events.CheckEvent(map[x+1][y]);
                x=x+1;
                map[x-1][y] = 0;
                map[x][y] =1;
                stamina --;
                PrintMap();
                break;
            case 'l':
                Events.CheckEvent(map[x][y-1]);
                y=y-1;
                map[x][y+1] = 0;
                map[x][y] =1;
                stamina --;
                PrintMap();
                break;
            case 'r':
                Events.CheckEvent(map[x][y+1]);
                y=y+1;
                map[x][y-1] = 0;
                map[x][y] =1;
                stamina --;
                PrintMap();
                break;

            default:
                System.out.println("That is not a valid response");
                move();
        }
    }

    public static void shuffle(int[][] matrix, int columns, Random rnd) {
        int size = matrix.length * columns;
        for (int i = size; i > 1; i--) {
            swap(matrix, columns, i - 1, rnd.nextInt(i));
        }
    }

    public static void swap(int[][] matrix, int columns, int i, int j) {
        int tmp = matrix[i / columns][i % columns];
        matrix[i / columns][i % columns] = matrix[j / columns][j % columns];
        matrix[j / columns][j % columns] = tmp;

    }

    public void GenerateMap() {
        GenerateElements(5,2);
        GenerateElements(5,3);
        GenerateElements(5,4);
        shuffle(map,10,new Random());
        map[x][y] =1;
        map[a][b] =5;
        System.out.println(stamina);

            //System.out.println(Arrays.deepToString(map));
        }

    public void PrintMap(){
        System.out.println("You take a look at your map:");
        for (int[] row : map) {
            if (map[x][y] == map[a][b]) {
                System.out.println("\"OH! You have reached your destination! You finished with a score of "+Map.coin+".");
                System.exit(0);
            }
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

