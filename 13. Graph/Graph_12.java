import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


// Dijkshtra's Algorithm  
// find the shortest paths from the source to all vertices in the given graph.


class Node implements Comparator<Node>{
    
    int distance;
    int node;

    Node(){}

    Node(int d , int n){
        this.distance = d;
        this.node = n;
    }

    @Override
    public int compare(Node n1 , Node n2){
        if(n1.distance > n2.distance){
            return 1;
        }
        if(n1.distance < n2.distance){
            return -1;
        }
        return 0;
    }
}


public class Graph_12 {

    static Map<Integer,ArrayList<ArrayList<Integer>>> adj = new HashMap<>();
    static int[] distance;
    


    public static void addAdj(int u , int v , int weight , boolean direction){


        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if(adj.get(u)!=null){
            list = adj.get(u);
        }

        ArrayList<Integer> a = new ArrayList<>();
        a.add(v);
        a.add(weight);

        list.add(a);

        adj.put(u,list);

        if(direction == false)
            addAdj(v, u, weight , true);

    }


    public static void main(String[] args) {
        
        int[][] arr = {
            { 0, 1, 7},
            { 0, 2, 1},
            { 0, 3, 2},
            { 1, 2, 3},
            { 1, 3, 5}, 
            { 1, 4, 1},
            { 3, 4, 7},
        };

        // create adjacency list
        for(int i=0 ; i<arr.length ; i++){
            int u = arr[i][0];
            int v = arr[i][1];
            int w = arr[i][2];

            addAdj(u, v, w , false);
        }

        System.out.println(adj);

        // initialize distance array
        int vertex = 5;
        distance = new int[vertex];
        for(int i =0 ;i <vertex ; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        // declare priority queue
        PriorityQueue<Node> pq = new PriorityQueue<Node>(vertex ,new Node());

        // initiaize source and distance 
        int source = 0;
        distance[source] = 0;

        // add first emtry in pq
        pq.add(new Node(0,0));

        while(!pq.isEmpty()){
            // remove smallest element
            Node top = pq.poll();

            int topDistance = top.distance;
            int topNode = top.node;

            if(adj.get(topNode)!=null){
                // traverse the nieghbour
                for(ArrayList<Integer> neightbour  :adj.get(topNode)){
                    // check condition
                    if( topDistance + neightbour.get(1)  <  distance[neightbour.get(0)]){

                        Node temp = new Node(distance[neightbour.get(0)],neightbour.get(0));
                        // if record found then erase it
                        if(pq.contains(temp)){
                            pq.remove(temp);
                        }
                        // distance update
                        distance[neightbour.get(0)] = topDistance + neightbour.get(1);
                        // record push in set
                        pq.add(new Node(distance[neightbour.get(0)]  , neightbour.get(0)));     
                    }
                }
            }
        }

        // print A
        for(int i = 0 ; i<vertex ; i++){
            System.out.print(distance[i] + "  ");
        }

    }
    
}
