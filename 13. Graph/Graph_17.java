import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Kosaraju's Algorith : used to get the total count of strongly connected component in graph.
// step-1 :
    // sort all the nodes based ont their finishing timer ( topological sort )
// strp-2 :
    // transpose the graph
// step-3
    // dfs and count

// Time complexity = O(Node + Edge)
// Space complexity = O(Node)


public class Graph_17 {
    
    static Map<Integer,ArrayList<Integer>> adj = new HashMap<>();
    static Stack<Integer> s ;
    static boolean[] visited;
    static Map<Integer,ArrayList<Integer>> transpose = new HashMap<>();
    
    
    public static void topological_sort(int node){

        visited[node] = true;

        if(adj.get(node)!=null){
            for(int nbr : adj.get(node)){
                if(visited[nbr]==false){
                    topological_sort(nbr);
                }
            }
        }

        s.push(node);
    }

    public static void create_transpose(int V){
        for(int i=0 ; i<V ; i++){
            visited[i] = false;
            if(adj.get(i)!=null){
                for(int nbr : adj.get(i)){
                    if(!transpose.containsKey(nbr)){
                        transpose.put(nbr,new ArrayList<>());
                    }
                    transpose.get(nbr).add(i);
                }
            }
        }
    }

    public static void dfs(int node){
        visited[node] = true;

        if(transpose.get(node)!=null){
            for(int nbr : transpose.get(node)){
                if(visited[nbr]==false){
                    dfs(nbr);
                }
            }
        }
    }

    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> a)
    {
        // create adjacency list
        for(int i=0 ; i<a.size() ;i++){
            int u = a.get(i).get(0);
            int v = a.get(i).get(1);

            if(!adj.containsKey(u)){
                adj.put(u,new ArrayList<>());
            }

            adj.get(u).add(v);
        }

        // topological sort
        s = new Stack<>();
        visited = new boolean[V];

        Arrays.fill(visited, false);

        for(int i=0 ; i<V ; i++){
            if(visited[i]==false){
                topological_sort(i);
            }
        }

        // create a transpose graph
        create_transpose(V);


        // dfs suiting above ordering
        int count = 0;
        while(!s.isEmpty()){

            int top = s.pop();

            if(visited[top]==false){
                count++;
                dfs(top);
            }

        }

        return count;
    }




    public static void main(String[] args) {
        
        int vertex = 5;

        int[][] arr = {
            {1 ,0},
            {0 ,2},
            {2 ,1},
            {0 ,3},
            {3 ,4},
        };

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        for(int i=0 ; i<arr.length ;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(arr[i][0]);
            temp.add(arr[i][1]);
            a.add(temp);
        }

        int ans = kosaraju(vertex, a);

        System.out.println(ans);
    }


}
