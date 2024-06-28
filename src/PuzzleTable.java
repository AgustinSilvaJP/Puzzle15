
//╠ ╣ ╦ ╩ ╬
public class PuzzleTable {
    private int[][] gameTable;
    static int cantMoves;
    public PuzzleTable(){
        gameTable = new int[][]{{2, 13, 5, 8}, {15, 9, 12, 6}, {3, 14, 4, 7}, {11, 0, 10, 1}};
        cantMoves = 0;
    }
    public void printGameTable(){
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
}
