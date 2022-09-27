import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Prim's Algo
// used to find minnimum spanning tree

// when you convert graph into tree with n nodes and n-1 edges and every node os reachable to other node , then it is known as spanning tree
// minimum spannig tree - sum of all the cost is minimum



public class Graph_13 {

    static Map<Integer,ArrayList<ArrayList<Integer>> > adj = new HashMap<>();


    public static void addAdj(int u , int v , int w ){

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if(adj.get(u)!=null){
            list = adj.get(u);
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(v);
        temp.add(w);

        list.add(temp);

        adj.put(u,list);     

    }


    public static void printAdj(){

        for(Map.Entry<Integer,ArrayList<ArrayList<Integer>>> i : adj.entrySet()){
            System.out.print(i.getKey() + " -> ");
            for(ArrayList<Integer> j : i.getValue()){
                System.out.print("( " + j.get(0) +"," + j.get(1) +" )");
            }
            System.out.println();

        }


    }


    public static void main(String[] args) {


        int[][] arr = {  
            {1,2, 21},
            {1 ,4, 16},
            {2 ,1, 12},
            {2 ,3, 13},
            {2 ,4, 18},
            {2 ,5, 15},
            {3 ,2, 13},
            {3 ,5, 17},
            {4 ,1, 16},
            {4 ,2, 18},
            {4 ,5, 19},
            {5 ,1, 18},
            {5 ,2, 15},
            {5 ,3, 17},
            {5 ,4, 19},
        };


        for(int i=0; i<arr.length ; i++){

            int u = arr[i][0];
            int v = arr[i][1];
            int w = arr[i][2];

            addAdj(u, v, w);
        }

        printAdj();


        int nodes = 5;
        int source_node = 1;

        // create data strcutures
        // 1. Map array   2. MST array  3. Parent Array
        int[] key = new int[nodes + 1];
        boolean[] mst = new boolean[nodes + 1];
        int[] parent = new int[nodes + 1];

        // initialize
        for(int i=0 ; i<nodes+1 ; i++){
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
            parent[i] = -1;
        }
        key[source_node] = 0;


        // logic



        for(int i=1 ; i<=nodes ; i++){

            // find smallest one
            int min = Integer.MAX_VALUE;
            int u = 0 ;

            for(int k=1 ; k<=nodes ; k++){
                if(mst[k]==false && key[k]<min){
                    u = k;
                    min = key[k];
                } 
            }

            // mark value true in mst
            mst[u] = true;

            // check its adjacent node
            for(ArrayList<Integer> neighbour : adj.get(u)){

                int v = neighbour.get(0);
                int w = neighbour.get(1);

                if(mst[v]==false && key[v] > w){
                    key[v] = w;
                    parent[v] = u;
                }

            }
        }

        // result
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i=2 ; i<nodes+1 ; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(parent[i]);
            temp.add(i);
            temp.add(key[i]);
            result.add(temp);
        }


        System.out.println(result);
        



        
    }



    
}
