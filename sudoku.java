//sudoku solver by Rithvik..
public class Sudoku{
    final static int n=3;
    final static int grid= 9;
    public static void main(String args[]){
        int[][] board= {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };


    if(solve(board)){
        System.out.println("Solved");
        print(board);
    }
    else System.out.println("Unsolvable");
    }

    private static void print(int[][] board){
        for(int i=0;i< grid; i++ ){
            if(i%n==0 && i!=0) System.out.println("----------------------------------");
            for(int j=0;j<grid;j++){
                System.out.print("  ");
                if(j%n==0 && j!=0)System.out.print(" | ");
                int boxval= board[i][j];
                if(boxval!=0){
                    System.out.print(boxval);

                }
                else System.out.print(" ");
            }
            System.out.println();
            
        }
    }
    private static boolean checkrow(int[][] board, int row, int num){
        for(int i=0;i<grid;i++){
            if(board[row][i]==num) return false;
        }
        return true;
    }
    private static boolean checkcol(int[][] board, int col, int num){
        for(int i=0;i<grid;i++){
            if(board[i][col]==num) return false;
        }
        return true;
    }
    private static boolean checkgrid(int[][] board, int row, int col, int num){
        int boxrow= row- row%3;
        int boxcol= col- col%3;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[boxrow+i][boxcol+j]== num) return false;
            }
        }
        return true;
    }
    private static boolean allowed(int[][] board, int row, int col, int num){
        return (checkrow(board, row, num) &&
                checkcol(board, col, num) &&
                checkgrid(board, row, col, num));
    }
    
    private static boolean solve(int[][] board) {
        for (int i = 0; i < grid; i++) {
            for (int j = 0; j < grid; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= grid; k++) {
                        if (allowed(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board))
                                return true;
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    
}
