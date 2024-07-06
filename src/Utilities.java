import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utilities {

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

    public static String randomInitGame(){
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

        return randomLine;
    }
}
