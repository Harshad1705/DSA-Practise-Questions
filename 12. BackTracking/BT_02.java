import java.util.ArrayList;

// n queens problem

public class BT_02 
{    
    // step - 1  :  create lists
    static int[][] board ;
    static ArrayList<ArrayList<Integer>> ans_1 = new ArrayList<>(); 
    static ArrayList<ArrayList<Integer>> ans_2 = new ArrayList<>(); 
    
    // step - 4
    public static void addSolution_1(int n){
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp.add(board[i][j]);
            }
        }
        ans_1.add(temp);
    }

    public static void addSolution_2(int n){
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    temp.add(j+1);
                }
            }
        }
        
        ans_2.add(temp);
            
    }
    
    public static boolean isSafe(int row , int col , int n){
        int x   = row ;
        int y = col ;
        
        // check for same row
        while(y>=0){
            if(board[x][y]==1){
                return false;
            }
            y--;
        }
        
        x = row ; 
        y = col;
        
        // check for diagonal(left top)
        while(x>=0 && y>=0){
            if(board[x][y]==1){
                return false;
            }
            y--;
            x--;
        }
        
        x = row ; 
        y = col;
        // check for diagonal (left bottom)
        while(x<n& y>=0){
            if(board[x][y]==1){
                return false;
            }
            y--;
            x++;
        }
        
        return true;
    }
    
    // step -3 
    public static void solve(int col,int n){
        if(col==n){
            addSolution_1(n);
            addSolution_2(n);
            return;
        }
        // solve 1 case and rest Recursion will take care
        for(int row = 0 ;row<n ; row++){
            if(isSafe(row,col,n)){
                // if placing queen is safe
                board[row][col] = 1 ; 
                solve(col+1 , n);
                board[row][col] = 0;
            }
        }
    }
    
    public static ArrayList<ArrayList<Integer>> nQueens(int n){
        
        // step -2
        board=new int[n ][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=0;
            }
        }
        
        solve( 0 ,n);
        
        return ans_1;
        
        
    } 

    public static void main(String[] args) {
        nQueens(4);


        for(ArrayList<Integer> arr : ans_1){
            int i  = 1 ;
            for(int a : arr){
                System.out.print(a + " ");
                i++;
                if(i==5){
                    System.out.println();
                    i=1;
                }
            }
            System.out.println();
        }
        System.out.println(ans_2);
    }
} 

