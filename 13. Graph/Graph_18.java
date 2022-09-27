import java.util.ArrayList;

// Bellman Ford algorith :  used to find the shortest path
// applied on Directed Graph and Undirected Graph with negative weights
// finds negative cycle
// finds shortest path , if negative cycle is not present

class Graph_18
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
    
        int[] ans = new int[V+1];
        for(int i=0 ; i<=V ; i++){
            ans[i] = 100000000;
        }
        
        ans[S] = 0;
        
        for(int i=1 ; i<=V ; i++){
            for(ArrayList<Integer> j : adj){
                int u = j.get(0);
                int v = j.get(1);
                int wt = j.get(2);
                
                if((ans[u] != 100000000) && ((ans[u]+wt) < ans[v])){
                    ans[v] = ans[u] + wt ; 
                }
            }
        }
        
        // check for negative cycle
   
        
        // for(ArrayList<Integer> j : adj){
        //         int u = j.get(0);
        //         int v = j.get(1);
        //         int wt = j.get(2);
                
        //         if(ans[u] != 1e9 && ((ans[u]+wt) < ans[v])){
        //             flag = true;
        //     }
        // }
        
        // if(flag == true){
        //     return ans.get(ans);
        // }

        
        return ans;
        
    }
}
