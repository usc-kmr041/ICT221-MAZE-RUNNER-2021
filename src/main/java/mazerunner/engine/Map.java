package mazerunner.engine;

import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class Map {
    Random rand = new Random();
    int a = rand.nextInt(9);
    int b = rand.nextInt(9);
    int[][] map = new int[10][10];
    int x = 9;
    int y = 0;



    public void move() {
        Scanner input = new Scanner(System.in);
        System.out.println("Where do you want to go?");
        char move = input.next().charAt(0);

        switch(move){
            case 'u':
                x=x-1;
                map[x+1][y] = 0;
                map[x][y] =1;
                PrintMap();
                break;

            case 'd':
                x=x+1;
                map[x-1][y] = 0;
                map[x][y] =1;
                PrintMap();
                break;
            case 'l':
                y=y-1;
                map[x][y+1] = 0;
                map[x][y] =1;
                PrintMap();
                break;
            case 'r':
                y=y+1;
                map[x][y-1] = 0;
                map[x][y] =1;
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
        map[8][9] = 2;
        map[7][9] = 2;
        map[5][9] = 2;
        map[6][9] = 2;
        map[3][9] = 2;
        shuffle(map,10,new Random());
        map[x][y] =1;
        map[a][b] =6;

            //System.out.println(Arrays.deepToString(map));
        }

    public void PrintMap(){
        for (int[] row : map) {
            if (map[x][y] == map[a][b]){
                System.out.println("WIN");
                System.exit(0);
            }
            StringJoiner sj = new StringJoiner("|");
            for (int col : row) {
                sj.add(String.format("%02d", col));
            }
            System.out.println(sj.toString());


        }
    }
}

