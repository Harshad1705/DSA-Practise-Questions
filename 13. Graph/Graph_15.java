import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Bridge - is a edge by removal of this edge, number of component are increased.


public class Graph_15 {

    static Map<Integer,ArrayList<Integer>> adj;
    static int[] discovery ;
    static int[] low ;
    static boolean[] visited ;
    static int timer;
    static List<List<Integer>> result;
    

    private static void dfs(int node , int parent ) {

        visited[node] = true;

        discovery[node] = low[node] =  timer++;

        for(Integer neighbour : adj.get(node)){

            if(neighbour == parent){
                continue;
            }

            if(!visited[neighbour]){
                
                dfs(neighbour , node );
                low[node] = Math.min(low[node], low[neighbour]);

                // check edge is bridge
                if(low[neighbour] > discovery[node]){

                    List<Integer> ans  = new ArrayList<>();
                    ans.add(node);
                    ans.add(neighbour);
                    result.add(ans);
                }
            }else{
                // Back Edge
                low[node] = Math.min(low[node] , discovery[neighbour]);
            }
        }
    }


    
    public static List<List<Integer>> findBridges(int[][] edges, int n, int e) {
        
        // create adjacency list
        adj = new HashMap<>();

        for(int i=0 ; i<edges.length ; i++){
            
            int u = edges[i][0];
            int v = edges[i][1];

            if(!adj.containsKey(u)){
                adj.put(u ,  new ArrayList<>());
            }
            if(!adj.containsKey(v)){
                adj.put(v, new ArrayList<>());
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // declare variable and DS
        timer = 0;
        discovery = new int[n];
        low = new int[n];
        visited = new boolean[n];
        int parent = -1;

        // answer list
        result = new ArrayList<>();

        // intitiate arrays
        Arrays.fill(discovery , -1);
        Arrays.fill(low , -1);
        Arrays.fill(visited , false);

        // dfs
        for(int i=0 ; i<n ; i++){
            if(visited[i]==false){
                dfs(i  , parent);
            }
        }

        return result;

    }


    
    public static void main(String[] args) {
        
        int[][] arr= {
            {1 ,2},
            {1 ,0},
            {0 ,2},
            {0 ,4},
            {5 ,4},
            {5 ,3},
            {3 ,4},
        };

        int n = 6;
        int edges = 7;

        findBridges(arr,n,edges);

        System.out.println(result);

    }



    
}
