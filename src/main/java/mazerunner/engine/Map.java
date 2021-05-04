package mazerunner.engine;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.Random;

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
                GenerateMap();
                break;

            case 'd':
                x=x+1;
                map[x-1][y] = 0;
                GenerateMap();
                break;
            case 'l':
                y=y-1;
                map[x][y+1] = 0;
                GenerateMap();
                break;
            case 'r':
                y=y+1;
                map[x][y-1] = 0;
                GenerateMap();
                break;

            default:
                System.out.println("That is not a valid response");
                move();
        }
    }

    public void GenerateMap() {

        for (int[] row : map) {
            map[x][y] =1;
            map[a][b] =6;
            if (map[x][y] == map[a][b]){
                System.out.println("WIN");
                System.exit(0);
            }
            StringJoiner sj = new StringJoiner("|");
            for (int col : row) {
                sj.add(String.format("%02d", col));
            }
            System.out.println(sj.toString());


            //System.out.println(Arrays.deepToString(map));

        }
    }
}
