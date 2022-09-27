import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Shortest path in directed acyclic graph

// Time complexity = O(N+E)
// Space complexity = O(N+E)

public class Graph_11 {

    static Map<Integer,ArrayList<ArrayList<Integer>>> adj = new HashMap<>();
    static Map<Integer,Boolean> visited = new HashMap<>();
    static Stack<Integer> s = new Stack<>();



    public static void addAdj(int u , int v , int weight){

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if(adj.get(u)!=null){
            list = adj.get(u);
        }

        ArrayList<Integer> a = new ArrayList<>();
        a.add(v);
        a.add(weight);

        list.add(a);
        
        adj.put(u,list);
    }


     
    public static void dfs(int node){
        visited.put(node, true);

        if(adj.get(node)!=null){
            for(ArrayList<Integer> i : adj.get(node)){
                if(visited.get(i.get(0))==false)
                    dfs(i.get(0));
            }
        }

        s.add(node);

    }

    public static int[] shortest_path(int source , int node){

        // create array of size node
        int[] arr = new int[node];

        // mark with infinite number
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.MAX_VALUE;
        }
        // mark source node to 0
        arr[source] = 0;

        while(!s.isEmpty()){
            // get top element
            int top = s.pop();
            // if top in array is not infinite
            if(arr[top] != Integer.MAX_VALUE){
                // if map in top value contain arraylist
                if(adj.get(top) != null){
                    // getting arraylist in top in map
                    for(ArrayList<Integer> i : adj.get(top)){
                        // check condition
                        if( (arr[top] + i.get(1)) < arr[i.get(0)]){
                            // update value
                            arr[i.get(0)] =  (arr[top] + i.get(1)) ;
                        }
                    }
                }
            }
        }


        return arr;
    }

    public static void main(String[] args) {

        // create adjacency list

        addAdj(0, 1, 5);
        addAdj(0, 2, 3);
        addAdj(1 ,2 ,2);
        addAdj(1, 3, 6);
        addAdj(2, 3, 7);
        addAdj(2, 4, 4);
        addAdj(2, 5, 2);
        addAdj(3, 4, -1);
        addAdj(4, 5, -2);

        System.out.println(adj);

        int source = 1;
        int node = 6;

        // prepare visited map
        for(int i=0 ; i<node ;i++){
            visited.put(i,false);
        }

        // topological sort
        for(int i = 0 ; i<node ; i++){
            if(!visited.get(i)){
                dfs(i);
            }
        }

        // print satck
        System.out.println(s);

        // et shortest path
        int[] shortest_path = shortest_path(source, node);

        // print shortest path
        for(int i :  shortest_path){
            if(i == Integer.MAX_VALUE){
                System.out.print("-1" + " ");
            }else{
                System.out.print(i + " ");
            }
        }
        
    }
    
}
