public class PuzzleTable {
    private int[][] gameTable;
    static int cantMoves;
    private int[] emptyPos;
    private int[] adyL;
    private int[] adyR;
    private int[] adyUp;
    private int[] adyDown;

    public PuzzleTable(){
        gameTable = Utilities.arrayTo2x2Matrix(Utilities.randomLineToIntArray(Utilities.randomInitGame()));
        cantMoves = 0;
        emptyPos = Utilities.emptyIndex(gameTable);
        adyL = new int[] {emptyPos[0], emptyPos[1] - 1};
        adyR = new int[] {emptyPos[0], emptyPos[1] + 1};
        adyUp = new int[] {emptyPos[0] - 1, emptyPos[1]};
        adyDown = new int[] {emptyPos[0] + 1, emptyPos[1]};
    }
    public void actAdyThings(){
        emptyPos = Utilities.emptyIndex(gameTable);
        adyR = new int[] {emptyPos[0], emptyPos[1] + 1};
        adyL = new int[] {emptyPos[0], emptyPos[1] - 1};
        adyUp = new int[] {emptyPos[0] - 1, emptyPos[1]};
        adyDown = new int[] {emptyPos[0] + 1, emptyPos[1]};
        cantMoves++;
    }
    public void moveDown(){
        try{
            gameTable[emptyPos[0]][emptyPos[1]] = gameTable[adyUp[0]][adyUp[1]];
            gameTable[adyUp[0]][adyUp[1]] = 0;
            actAdyThings();
        }catch(Exception e){
        }
    }
    public void moveUp(){
        try{
            gameTable[emptyPos[0]][emptyPos[1]] = gameTable[adyDown[0]][adyDown[1]];
            gameTable[adyDown[0]][adyDown[1]] = 0;
            actAdyThings();
        }catch(Exception e){
        }
    }
    public void moveL(){
        try{
            gameTable[emptyPos[0]][emptyPos[1]] = gameTable[adyR[0]][adyR[1]];
            gameTable[adyR[0]][adyR[1]] = 0;
            actAdyThings();
        }catch(Exception e){
        }
    }
    public void moveR(){
        try{
            gameTable[emptyPos[0]][emptyPos[1]] = gameTable[adyL[0]][adyL[1]];
            gameTable[adyL[0]][adyL[1]] = 0;
            actAdyThings();
        }catch(Exception e){
        }
    }
    public void printGameTable(){
        System.out.println("╔════╦════╦════╦════╗");
        for(int x = 0; x < gameTable.length; x++){
            for(int y = 0; y < gameTable.length; y++){
                if(y == 0) System.out.print("║");
                if(gameTable[x][y] == 0){
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

}
