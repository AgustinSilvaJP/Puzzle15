import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Puzzle15 {
    public static void printGameTabl(int[][] gameTable){
        System.out.println("╔════╦════╦════╦════╗");
        for(int x = 0; x < gameTable.length; x++){
            for(int y = 0; y < gameTable.length; y++){
                if(y == 0) System.out.print("║");
                System.out.printf(" %2d ║", gameTable[x][y]);
            }
            System.out.println();
            if(x < 3) System.out.println("╠════╬════╬════╬════╣");
        }
        System.out.println("╚════╩════╩════╩════╝");
    }
    public static void main(String[] args) {
        PuzzleTable game = new PuzzleTable();
        //╠ ╣ ╦ ╩ ╬ ╔ ╗ ═ ╚ ╝
        game.printGameTable();

        int[][] table = new int[4][4];

        //table[(int) (Math.random() * 3) + 1][(int) (Math.random() * 3) + 1] = 0;

        String filePath = "/home/agus/JavaPractica/JavaBookPrac/Puzzle15Game/initPartida.txt";
        String randomLine = null;
        try{
            //paso 1 contar lineas del archivo
            int totalFileLines = countLines(filePath);

            //paso 2 generar num aleatorio
            int randomNum = (int) (Math.random() * totalFileLines) + 1;

            //leer linea aleatoria
            randomLine = readRandomLine(filePath, randomNum);

            //print linea aleatoria
            System.out.println("linea aleatoria: " + randomLine);

        }catch (IOException e){
            System.err.println("Error");
        }

        //Carga de la linea aleatoria a un array

        printGameTabl(table);
    }
    //cuenta las lineas que tiene el archivo y lo retorna
    public static int countLines(String filePath) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader(filePath));
        int lines = 0;
        while(read.readLine() != null) lines++;
        read.close();
        return lines;
    }
    //lee linea random y lo retorna;
    public static String readRandomLine(String filePath, int lineNum) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader(filePath));
        String line = null;
        for(int i = 0; i <= lineNum; i++){
            line = read.readLine();
        }
        read.close();
        return line;
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