import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Graph<T>{

    Map<T,ArrayList<T>> adj = new HashMap<>();

    public  void addEdge(T u , T v , boolean direction){
        // direction = true   -> directed graph
        // direction = false  -> undirected graph

        ArrayList<T> temp = new ArrayList<>();
        if(adj.get(u)!=null){
            temp = adj.get(u);
        }
        temp.add(v);

        adj.put(u,temp);

        if(direction==false){
            addEdge(v, u, true);
        }
    }

    public void printAdjList(){
        for(Map.Entry<T,ArrayList<T>> m : adj.entrySet() ){
            System.out.print(m.getKey() + "-->");
            System.out.println(m.getValue());
            System.out.println();
        }
    }
}


public class Graph_01{

    public static void main(String[] args) {
        
        Graph<Integer> g = new Graph<>();
        try (Scanner scn = new Scanner(System.in)) {
            
            int n;
            System.out.println("Enter the number of nodes");
            n = scn.nextInt();
            System.out.println(n);

            int m ;
            System.out.println("Enter the number of edges");
            m = scn.nextInt();

            for(int i=0;i<m;i++){
                int u , v;
                System.out.println("Enter u and v");
                u = scn.nextInt();
                v = scn.nextInt();

                g.addEdge(u, v, false);

            }
        }

        g.printAdjList();


    }


}