import java.util.Scanner;
//╠ ╣ ╦ ╩ ╬ ╔ ╗ ═ ╚ ╝
public class Puzzle15 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        do{
            Utilities.clearWindow();
            PuzzleTable game = new PuzzleTable();
        
            int apuestaGame;

            System.out.println("Ingrese valor entre (40, 200)");
            do{
                apuestaGame = scan.nextInt();
                if((apuestaGame < 40 || apuestaGame > 200)){
                    Utilities.clearWindow();
                    System.out.print("Ingrese otro valor: ");
                    }
            }while(apuestaGame < 40 || apuestaGame > 200);
            Utilities.clearWindow();
            char movement;
            game.printGameTable();
            game.printGameController();
            do{
                movement = scan.next().charAt(0);

                if(movement == 'a') game.moveL();
                if(movement == 's') game.moveDown();
                if(movement == 'd') game.moveR();
                if(movement == 'w') game.moveUp();
                Utilities.clearWindow();
                game.printGameTable();
                game.printGameController();
            }while(!game.winCondition() && movement != 'x');
            if(movement == 'x'){
                game.setScoreAbandonGame();
            }else{
                game.setScore(apuestaGame);
            }
    
            Utilities.clearWindow();

            game.winMessage();
            game.printGameScore();

            System.out.println("Do you want to play again?:");
            Utilities.printGameOption();
            
        }while((scan.next().charAt(0) == 'y'));
        scan.close();
        Utilities.clearWindow();
        //╠ ╣ ╦ ╩ ╬ ╔ ╗ ═ ╚ ╝

    }
}
