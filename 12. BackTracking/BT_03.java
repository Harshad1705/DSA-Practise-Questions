public class BT_03 {
    
    static boolean safe(int row , int col , int[][] board , int val , int n){
        
        for(int i=0;i<n;i++){
            // row check
            if(board[row][i]==val){
                return false;
            }
            // col check
            if(board[i][col]==val){
                return false;
            }
            // box check
            if(board[3*(row/3) + (i/3)][3*(col/3) + (i%3) ] == val){
                return false;
            }
        }
        return true;
    }
        
    static boolean sudokusolver(int[][] board){
        int n = board[0].length;

        // traversing in full board
        for(int row=0;row<n  ; row++){
            for(int col=0;col<n;col++){

                // if get empty place
                if(board[row][col]==0){

                    // try to place value between 1 to 9
                    for(int val=1 ; val<= 9 ;val++){

                        // if placing safe
                        if(safe(row ,col ,board , val , n)){
                            // place value
                            board[row][col] = val;
                            // recursion call
                            boolean aageSolutonPossible =  sudokusolver(board);
                            // if further solution possible
                            if(aageSolutonPossible){
                                return true;
                            }else{
                                // else backtrack
                                board[row][col]=0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
	public static void solveSudoku(int[][] sudoku) {
        // Time complexity : 9^m   m = number of empty cells
        // Space complexity : O(1)
        sudokusolver(sudoku);
        
	}
    

}