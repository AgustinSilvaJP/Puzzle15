
//╠ ╣ ╦ ╩ ╬
public class PuzzleTable {
    private int[][] gameTable;
    static int cantMoves;
    private int[] emptyPos;
    private int[] adyL;
    private int[] adyR;

    public PuzzleTable(){
        gameTable = Utilities.arrayTo2x2Matrix(Utilities.randomLineToIntArray(Utilities.randomInitGame()));
        cantMoves = 0;
        emptyPos = Utilities.emptyIndex(gameTable);
        adyL = new int[] {emptyPos[0], emptyPos[1] - 1};
        adyR = new int[] {emptyPos[0], emptyPos[1] + 1};
    }

    public void moveL(){
        try{
            gameTable[emptyPos[0]][emptyPos[1]] = gameTable[adyR[0]][adyR[1]];
            gameTable[adyR[0]][adyR[1]] = 0;
            emptyPos = Utilities.emptyIndex(gameTable);
            adyR = new int[] {emptyPos[0], emptyPos[1] + 1};
            adyL = new int[] {emptyPos[0], emptyPos[1] - 1};
        }catch(Exception e){
        }
    }
    public void moveR(){
        try{
            gameTable[emptyPos[0]][emptyPos[1]] = gameTable[adyL[0]][adyL[1]];
            gameTable[adyL[0]][adyL[1]] = 0;
            emptyPos = Utilities.emptyIndex(gameTable);
            adyL = new int[] {emptyPos[0], emptyPos[1] - 1};
            adyR = new int[] {emptyPos[0], emptyPos[1] + 1};
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
