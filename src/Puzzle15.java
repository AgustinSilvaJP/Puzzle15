// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
import java.util.Scanner;
//╠ ╣ ╦ ╩ ╬ ╔ ╗ ═ ╚ ╝
public class Puzzle15 {
    public static void main(String[] args) {
        PuzzleTable game = new PuzzleTable();
        game.printGameTable();
        
        Scanner scan = new Scanner(System.in);
        
        char movement;
        System.out.println("press a button: (w,a,s,d)");
        do{
            movement = scan.next().charAt(0);

            if(movement == 'a') game.moveL();
            if(movement == 's') game.moveDown();
            if(movement == 'd') game.moveR();
            if(movement == 'w') game.moveUp();
            System.out.print("\033[H\033[2J");//
            System.out.flush();
            game.printGameTable();
            System.out.println("movements: " + PuzzleTable.cantMoves);
        }while(movement != 'f');
        scan.close();
    }
}
