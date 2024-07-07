public class PuzzleTable {
    private int[][] gameTable;
    private int cantMoves;
    private int score;
    private int[] emptyPos;
    private int[] adyL;
    private int[] adyR;
    private int[] adyUp;
    private int[] adyDown;

    public PuzzleTable(){
        gameTable = Utilities.arrayTo2x2Matrix(Utilities.randomLineToIntArray(Utilities.randomInitGame()));
        cantMoves = 0;
        score = -1;
        emptyPos = Utilities.emptyIndex(gameTable);
        adyL = new int[] {emptyPos[0], emptyPos[1] - 1};
        adyR = new int[] {emptyPos[0], emptyPos[1] + 1};
        adyUp = new int[] {emptyPos[0] - 1, emptyPos[1]};
        adyDown = new int[] {emptyPos[0] + 1, emptyPos[1]};
    }

    public int getScore(){
        return score;
    }
    public void setScore(int apuesta){
        if(cantMoves < apuesta - 10){
            score = 1500;
        }else if ((cantMoves >= apuesta) && (cantMoves < apuesta)){
            score = 1200;
        }else if(cantMoves == apuesta){
            score = 1000;
        }else if((cantMoves > apuesta) && (cantMoves <= apuesta + 10)){
            score = 500;
        }else{
            score = 0;
        }
    }
    public void setScoreAbandonGame(){
        score = 0;
    }
    public int getMovements(){
        return cantMoves;
    }
    public void actAdyThings(){
        emptyPos = Utilities.emptyIndex(gameTable);
        adyR = new int[] {emptyPos[0], emptyPos[1] + 1};
        adyL = new int[] {emptyPos[0], emptyPos[1] - 1};
        adyUp = new int[] {emptyPos[0] - 1, emptyPos[1]};
        adyDown = new int[] {emptyPos[0] + 1, emptyPos[1]};
        cantMoves++;
    }
    public boolean winCondition(){
        if(gameTable[0][3] > gameTable[1][0])return false;
        if(gameTable[1][3] > gameTable[2][0])return false;
        if(gameTable[2][3] > gameTable[3][0])return false;
        for(int x = 0; x < 4; x++){
            for(int y = 0; y < 3; y++){
                if(gameTable[x][y] > gameTable[x][y + 1]) return false;
            }
        }
        return true;
    }
    public void moveDown(){
        try{
            gameTable[emptyPos[0]][emptyPos[1]] = gameTable[adyUp[0]][adyUp[1]];
            gameTable[adyUp[0]][adyUp[1]] = 16;
            actAdyThings();
        }catch(Exception e){
        }
    }
    public void moveUp(){
        try{
            gameTable[emptyPos[0]][emptyPos[1]] = gameTable[adyDown[0]][adyDown[1]];
            gameTable[adyDown[0]][adyDown[1]] = 16;
            actAdyThings();
        }catch(Exception e){
        }
    }
    public void moveL(){
        try{
            gameTable[emptyPos[0]][emptyPos[1]] = gameTable[adyR[0]][adyR[1]];
            gameTable[adyR[0]][adyR[1]] = 16;
            actAdyThings();
        }catch(Exception e){
        }
    }
    public void moveR(){
        try{
            gameTable[emptyPos[0]][emptyPos[1]] = gameTable[adyL[0]][adyL[1]];
            gameTable[adyL[0]][adyL[1]] = 16;
            actAdyThings();
        }catch(Exception e){
        }
    }
    public void printGameTable(){
        System.out.println("╔════╦════╦════╦════╗");
        for(int x = 0; x < gameTable.length; x++){
            for(int y = 0; y < gameTable.length; y++){
                if(y == 0) System.out.print("║");
                if(gameTable[x][y] == 16){
                    System.out.print("    ║");
                }else{
                    System.out.printf(" %2d ║", gameTable[x][y]);
                }
            }
            System.out.println();
            if(x < 3) System.out.println("╠════╬════╬════╬════╣");
        }
        System.out.println("╚════╩════╩════╩════╝");
    }
    public void printGameController(){
        System.out.println("           ╔═══╗");
        System.out.println("           ║ w ║");
        System.out.println("╔═══╗  ╔═══╬═══╬═══╗  ╔══════════════════╗");
        System.out.printf( "║ x ║  ║ a ║ s ║ d ║  ║Cant Movements:%3d║\n", cantMoves );
        System.out.println("╚═══╝  ╚═══╩═══╩═══╝  ╚══════════════════╝");
    }
    //╠ ╣ ╦ ╩ ╬ ╔ ╗ ═ ╚ ╝ ║
    public void printGameScore(){
        System.out.println("╔═════════════════╗");
        System.out.printf("║Total Score:%4d ║\n",getScore());
        System.out.println("╚═════════════════╝");
    }
    public void winMessage(){
        System.out.println("GG ez");
    }
}
