import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

// Shortest path in undirected graph

// Time complexity = O(N+E)
// Space complexity = O(N+E)

public class Graph_10 {

    // adjacency list
    static Map<Integer,ArrayList<Integer>> adjList = new HashMap<>();
    // visited map
    static Map<Integer,Boolean> visited = new HashMap<>();
    // parent map
    static Map<Integer,Integer> parent = new HashMap<>();


    public static ArrayList<Integer> shortest_path(int source , int destination){

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(destination);

        int temp = destination;

        while(temp != source){
            temp = parent.get(temp);
            arr.add(temp);
        }


        return arr;

    }


    public static void bfs(int source){

        Queue<Integer> q = new ArrayDeque<>();

        q.add(source);
        visited.put(source,true);
        parent.put(source , -1);


        while(!q.isEmpty()){

            int element = q.remove();

            ArrayList<Integer> l = adjList.get(element);

            for(int i : l){
                if(!visited.containsKey(i)){
                    q.add(i);
                    visited.put(i,true);
                    parent.put(i,element);
                }
            }
        }

    }


    public static void addList(int u , int v ,Boolean direction){

        ArrayList<Integer> list = new ArrayList<>();

        if(adjList.get(u)!=null){
            list = adjList.get(u);
        }

        list.add(v);

        adjList.put(u, list);

        if(direction == false){
            addList(v, u, true);
        }

    }




    public static void main(String[] args) {
        
        int[][] lists = {
            {1,2},{1,3},{1,4},
            {2,5},
            {3,8},
            {4,6},
            {5,8},
            {6,7},
            {7,8},
        };

        // create adjacency list
        for(int i=0 ; i<lists.length ; i++){
            int u = lists[i][0];
            int v = lists[i][1];
            addList(u, v, false);
        }

        // print adjacency list
        System.out.println(adjList);

        // source and destination
        int source = 1 ;
        int destination = 8;

        // create parent map
        // do BFS
        bfs(source);


        // print parent map
        System.out.println(parent);

        ArrayList<Integer> path = shortest_path(source, destination);

        Collections.reverse(path);

        System.out.println(path);



    }

    
}
