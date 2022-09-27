import java.util.ArrayList;


// Rat in maze

public class BT_01 {
    
    static int[][] visited ; 
    static ArrayList<String> ans = new ArrayList<>();
    
    
    public static boolean isSafe(int newX , int newY , int[][] arr , int n){
        
        if( (newX>=0 && newX<n) && (newY>=0 && newY<n) && (visited[newX][newY]==0) && (arr[newX][newY]==1) ){
            return true;
        }else{
            return false;
        }
    }
    
    public static void solve(int i , int j ,int[][] arr , int n ,String path  ){
        
        // base case
        if(i==(n-1) && j==(n-1)){
            ans.add(path);
            return;
        }


        visited[i][j] = 1;
        // 4 movement - D ,l ,R ,U
           // Down
        if(isSafe(i+1 , j , arr , n)){
            solve(i+1 , j ,arr ,n, path+'D');
        }
        
              // left
        if(isSafe(i , j-1 , arr , n)){
            solve(i, j-1, arr,n , path+'L');
        }
           
              // right
        if(isSafe(i , j+1 , arr , n)){
            solve(i , j+1 ,arr,n , path+'R');
        }
           
              // up
        if(isSafe(i-1 , j , arr , n)){
            solve(i-1 , j ,arr,n , path+'U');
        }

        visited[i][j] = 0;
    }



    public static ArrayList < String > findSum(int[][] arr, int n) {
        
        // Time complexity : 4^n^2
        // Time complexity : O(n*m)
        
        if(arr[0][0]==0){
            return ans;
        }

        visited = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visited[i][j]=0;
            }
        }
        solve(0,0,arr,n,"");
        return ans;
    }

    public static void main(String[] args) {

        int[][] arr = {
            {1,0,0,0},
            {1,1,0,1},
            {1,1,0,0},
            {0,1,1,1}
        };

        int n = 4;

        ArrayList<String> ans = findSum(arr, n);
        
        for(String s :ans){
            System.out.println(s);
        }
    }
}