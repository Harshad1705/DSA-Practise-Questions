import java.util.*;

// cycle detection in Undirected graph using DFS

 class Graph_05 {

    // for mapping
    static Map<Integer,ArrayList<Integer>> adj = new HashMap<>();
    // visited list
    static Map<Integer,Boolean> visited = new HashMap<>();
    
    
    public static void addAdj(int u,int v , boolean direction){

        ArrayList<Integer> temp = new ArrayList<>();
        
        if(adj.get(u)!=null){
            temp = adj.get(u);
        }
        temp.add(v);

        adj.put(u,temp);

        if(direction==false){
            addAdj(v, u, true);
        }

    }
    public static boolean isCyclicDFS(int node , int parent){
        
        visited.put(node,true);
        
        if(adj.get(node)!=null){

            for(int x : adj.get(node)){

                if(visited.get(x)==false){
                    boolean cycleDetection = isCyclicDFS(x, node);
                    if(cycleDetection==true){
                        return true;
                    }
                }else if(x!=parent){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        
         for(int i=0;i<m;i++){
             int u = edges[i][0];
             int v = edges[i][1];
             addAdj(u,v,false);
         }
        for(int i=1;i<=n;i++){
            visited.put(i,false);
        }
        
        for(int i=1;i<=n;i++){
            if(visited.get(i)==false){
                boolean ans = isCyclicDFS(i,-1);
                if(ans==true){
                    return "Yes";
                }
            }
        }
        return "No";
    }
    public static void main(String[] args) {
        
        int[][] arr = {
            {1,2},{2,3},{3,1}
        };
        
        // int n = 3;
        
        System.out.println(cycleDetection(arr, 3, 3));
        

    }
    
}