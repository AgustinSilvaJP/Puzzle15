// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
public class Puzzle15 {
    public static void main(String[] args) {
        PuzzleTable game = new PuzzleTable();
        //╠ ╣ ╦ ╩ ╬ ╔ ╗ ═ ╚ ╝
        game.printGameTable();
        String randomThing = Utilities.randomInitGame();
        System.out.println(randomThing);
        //table[(int) (Math.random() * 3) + 1][(int) (Math.random() * 3) + 1] = 0;

    }
}
//temporal wea
//        {{2, 13, 5, 8}, {15, 9, 12, 6}, {3, 14, 4, 7}, {11, 0, 10, 1}}
//        {{14, 10, 7, 6}, {1, 5, 2, 3}, {15, 11, 4, 9}, {0, 13, 8, 12}}
//        {{3, 0, 14, 6}, {4, 12, 9, 15}, {5, 2, 8, 13}, {7, 1, 10, 11}}
//        {{10, 6, 3, 5}, {1, 7, 9, 4}, {14, 2, 0, 12}, {11, 13, 15, 8}}
//        {{14, 12, 11, 9}, {6, 10, 13, 8}, {5, 0, 3, 15}, {7, 1, 4, 2}}
//        {{11, 0, 2, 5}, {14, 9, 1, 4}, {13, 7, 15, 12}, {3, 8, 6, 10}}
//        {{10, 11, 15, 12}, {0, 8, 6, 14}, {13, 5, 2, 3}, {1, 9, 4, 7}}
//        {{0, 12, 3, 8}, {1, 7, 15, 13}, {10, 4, 14, 6}, {9, 11, 5, 2}}
//        {{12, 0, 3, 8}, {1, 7, 15, 13}, {10, 4, 14, 6}, {9, 11, 5, 2}}
//        {{9, 2, 6, 14}, {11, 8, 0, 10}, {15, 3, 4, 5}, {13, 7, 1, 12}}
//        {{9, 7, 6, 3}, {12, 4, 5, 15}, {11, 13, 10, 2}, {14, 8, 0, 1}}