import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Articulation point :- it is a node , if removal if this node results graph become have more than 1 componenets.
// Time complexity = O(Node + Edge)
// Space complexity = O(Node)

class Solution
{   
    static Map<Integer,ArrayList<Integer>> adj = new HashMap<>();
    static int[] discovery;
    static int[] low;
    static int[] ap;
    static boolean[] visited;
    static int timer;
    static ArrayList<Integer> ans = new ArrayList<Integer>();
    
    
    
    public static void addAdj(int u , int v , boolean direc){
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        if(adj.get(u)!=null){
            temp = adj.get(u);
        }
        
        temp.add(v);
        
        adj.put(u , temp);
        
        if(direc == true){
            addAdj(v,u,false);
        }
        
    }

    public static void dfs(int node, int parent) {

        visited[node] = true;

        discovery[node] = low[node] = timer++;

        int child = 0;

        for(int nbr : adj.get(node)){

            if(nbr == parent){
                continue;
            }

            if(visited[nbr] == false){
                dfs(nbr , node);

                low[node] = Math.min(low[node] , low[nbr]);
                // check AP or not
                if(low[nbr] >= discovery[node] && parent!=-1){
                    ap[node] = 1;
                }
                child++;
            }else{
                // back edge
                low[node] = Math.min(low[node] , discovery[nbr]); 
            }
        }

        if(parent==-1 && child > 1){
            ap[node] = 1; 
        }

    }
    
    
    public static ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> a)
    {
        // create adjacency list
        for(int i=0;i<a.size();i++){

            int u = a.get(i).get(0);
            int v = a.get(i).get(1);
            
            addAdj(u,v,true);
        }

        // declare data structure
        timer = 0;
        discovery = new int[V];
        low = new int[V];
        ap = new int[V];
        visited = new boolean[V];

        // fill initial value
        Arrays.fill(discovery,-1);
        Arrays.fill(low,-1);
        Arrays.fill(ap,0);
        Arrays.fill(visited,false);
        
        // answer data structure
        ans = new ArrayList<>();

        // dfs
        for(int i=0 ;i<V ; i++){
            if(visited[i]==false){
                dfs(i ,-1 );
            }
        }
        
        // copy values of ap into arraylist
        for(int i=0 ; i<ap.length ; i++){
            if(ap[i]==1){
                ans.add(i);
            }
        }
        
        for(int i : ans)
            System.out.println(i);
        
        return ans;
    }


    


    public static void main(String[] args) {
        
        int[][] arr = {
            {0,3},{3,4},{0,4},{0,1},{1,2}
        };

        int v = 5;

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        for(int i=0 ; i<arr.length ; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(arr[i][0]);
            temp.add(arr[i][1]);

            a.add(temp);
        }

        articulationPoints(v, a);

    }
}
