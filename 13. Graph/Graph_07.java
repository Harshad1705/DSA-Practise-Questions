import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

// Topological Sort using DFS
// It is used only on Directed Acyclic Graph
// Linear ordering of vertices such that for every edge u->v , u always appears before v in that ordering

public class Graph_07 {

    static Map<Integer,ArrayList<Integer>> map = new HashMap<>();
    static Map<Integer,Boolean> visited = new HashMap<>();
    static Stack<Integer> stack = new Stack<>();

    public static void addAdj(int u , int v , boolean direction){

        ArrayList<Integer> temp = new ArrayList<>();

        if(map.get(u)!=null){
            temp = map.get(u);
        }
        temp.add(v);

        map.put(u, temp);

        if(direction==false){
            addAdj(v, u, true);
        }
        
    }

    public static void dfs(int node){

        visited.put(node, true);

        if(map.get(node)!=null){
            for(int x : map.get(node)){
                if(visited.get(x)==false){
                    dfs(x);
                }
            }
        }

        // imp
        stack.push(node);

    }

    public static void Topological_Sort(Vector<Vector<Integer>> edges , int vertex , int edge){


        // Time complexity = O(edges + node)
        // Space Complexity = O(node)


        // create adjecency list
        for(int i=0;i<edges.size();i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            addAdj(u, v, true);
        }

        // map visited all false
        for(int i=1 ; i <= vertex ; i++){
            visited.put(i, false);
        }

        for(int i=1 ;i<=vertex;i++){
            if(visited.get(i)==false){
                dfs(i);
            }
        }

    }


    public static void main(String[] args) {
        
        int[][] arr = {
            {1,2},{1,3},{2,4},{3,4},{4,5},{4,6},{5,6},
        };

        Vector<Vector<Integer>> edges = new Vector<>();

        for(int i=0;i<arr.length;i++){
            Vector<Integer> temp = new Vector<>();
            temp.add(arr[i][0]);
            temp.add(arr[i][1]);
            edges.add(temp);
        }

        int vertex = 6;
        int edge = 7;
        Topological_Sort(edges, vertex, edge);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }


    }

    
}
