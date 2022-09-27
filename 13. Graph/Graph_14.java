import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// DisJoint set  : yeh dekh lena lect:97 krushal's algortihm

// Krushkal's Algorithm


// Time complexity = O(nlogn)
// Space complexity = O(n)

// procedure
// sort the list of array on basis of their wieght
// iterate on the list
// and if the parent of u and v are not equal 
// then add nodes and wieght


public class Graph_14 {

    // create class for getting weights in sorted order
    static class Node implements Comparator<Node>{

        int weight;
        int u;
        int v;
    
        Node(){}
    
        public Node(int wt , int u, int v){
            this.weight = wt;
            this.u = u;
            this.v = v;
        }
    
        @Override
        public int compare(Node n1 , Node n2){
            if(n1.weight > n2.weight){
                return 1;
            }
            if(n1.weight < n2.weight){
                return -1;
            }
            return 0;
        }
    }


    // declare parent , rank and queue
    static int[] parent;
    static int[] rank;
    static PriorityQueue<Node> pq ;

    // initialize parent and rank array
    public static void makeSet(int n){
        for(int i=0 ; i<n ; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // used to find the parent of node
    public static int findParent(int node){
        if(parent[node] == node){
            return node;
        }

        return parent[node] = findParent(parent[node]);
    }

    // used to join two nodes
    public static void unionSte(int u , int v){

        // find parents
        v = findParent(v);
        u = findParent(u);

        // if rank are less than other
        if(rank[u] < rank[v]){
            // then add smaller node into bigger 
            parent[u] = v;
        }else if(rank[v] < rank[u]){
            parent[v] = u;
        }else{
            // if both rank are equal then make add any node to other
            parent[v] = u;
            // and increase rank of node by which other node is joined
            rank[u]++;
        }

    }

    // return minimum weigth of grapg which connects all nodes
    public static int minimumSpannnigTree(ArrayList<ArrayList<Integer>> edges, int n){

        // initialize arrays
        parent = new int[n];
        rank = new int[n];

        // intialize queue
        pq = new PriorityQueue<Node>(edges.size() , new Node());
        
        // adding values in queue using edges
        for(int i=0 ; i<edges.size() ; i++){

            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int wt = edges.get(i).get(2);

            Node tempNode = new Node(wt, u, v);

            pq.add(tempNode);
        }
        
        // inititae value in arrays
        makeSet(n);

        // taking valriable which track the minimumm weights
        int minimum = 0;


        // iterate in queue
        while(!pq.isEmpty()){

            Node top = pq.poll();
            
            int u = top.u;
            int v = top.v;
            int wt = top.weight;

            // check if the parent of both nodes are node equal
            if(findParent(u) !=findParent(v)){
                // then join the nodes
                unionSte(u, v);
                // update the minimum weight
                minimum += wt; 
            }
        }

        // return answer
        return minimum;

    }
    


    public static void main(String[] args) {
        int[][] arr = {
            {0 ,1 ,3},
            {0 ,3 ,5},
            {1 ,2 ,1},
            {2 ,3 ,8},
        };

        int n = 4;

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        for(int i=0 ; i<arr.length ; i++){
            int u = arr[i][0];
            int v = arr[i][1];
            int wt = arr[i][2];

            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(u);
            temp.add(v);
            temp.add(wt);

            a.add(temp);
        }

        int ans = minimumSpannnigTree(a, n);

        System.out.println(ans);
    }
}
