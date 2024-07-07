import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utilities {
    //╠ ╣ ╦ ╩ ╬ ╔ ╗ ═ ╚ ╝ ║
    public static void printGameOption(){
        System.out.println("╔═══╗  ╔═══╗");
        System.out.println("║ Y ║  ║ N ║");
        System.out.println("╚═══╝  ╚═══╝");
    }
    public static boolean newGameImput(char charac){
        if(charac == 'y') return true;
        return false;
    }

    public static void clearWindow(){
        System.out.print("\033[H\033[2J");//
        System.out.flush();
    }
    //dado un directorio, cuenta la cantidad de lienas que contiene el archivo
    public static int countLines(String filePath) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader(filePath));
        int lines = 0;
        while(read.readLine() != null) lines++;
        read.close();
        return lines;
    }

    //dado un directorio de archivo y la cantidad de lineas del mismo
    //lee una linea random y lo retorna;
    public static String readRandomLine(String filePath, int lineNum) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader(filePath));
        String line = null;
        for(int i = 0; i <= lineNum; i++){
            line = read.readLine();
        }
        read.close();
        return line;
    }
    //dado la direccion de un archivo, lee una linea aleatoria, la guarda en un variable y lo retorna
    public static String randomInitGame(){
        //directorio del archivo a leer;
        String filePath = "/home/agus/JavaPractica/JavaBookPrac/Puzzle15Game/initPartida.txt";
        String randomLine = null; //var que contendra la linea aleatoria.
        try{
            //1) se cuentan el total de lineas que contiene el archivo;
            int totalFileLines = countLines(filePath);

            //2) se generara un numero aleatorio a partir de la cantidad de lineas del paso (1)
            int randomNum = (int) (Math.random() * totalFileLines) + 1;

            //3) dado el filepath y cant de lineas del archivo, se lee linea aleatoria y se guarda
            //   en randomLine;
            randomLine = readRandomLine(filePath, randomNum);
        }catch (Exception e){
            System.err.println("Error");
        }
        return randomLine;
    }

    //dada un texto que contiene numeros, los separa por ',', los convierte a ints, lo almacena
    // en un array y lo retorna;
    public static int[] randomLineToIntArray(String text){
        //se separa el string por ','
        String[] array = text.split(",");

        int cantElem = array.length; //cant de elementos separados del string.
        int[] intArray = new int[cantElem];

        for(int x = 0; x < cantElem; x++){
            try{
                //se convierte a cada elemento str a Int y se almacena en intArray
                intArray[x] = Integer.valueOf(array[x]);
            }catch(Exception e){
                System.out.println("Error!");
            }
        }
        //retorno del array de ints
        return intArray;
    }
    public static int[][] arrayTo2x2Matrix(int[] array){
        int[][] mat = new int[4][4];
        int index = 0;
        for(int x = 0; x < 4; x++){
            for(int y = 0; y < 4; y++){
                mat[x][y] = array[index];
                index++;
            }
        }
        return mat;
    }
    //dado una matriz retorna un int[] con la posicion del elemento 16; 16 que representara un num 'vacio'
    public static int[] emptyIndex(int[][] matrix){
        int[] emptyPosi = {-1, -1};
        int cElem = matrix.length;
        for(int x = 0; x < cElem; x++){
            for(int y = 0; y < cElem; y++){
                if(matrix[x][y] == 16){
                    emptyPosi = new int[] {x, y};
                    return emptyPosi;   
                }
            }
        }
        return emptyPosi;
    }
}