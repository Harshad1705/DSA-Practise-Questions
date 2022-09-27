import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

// cycle detection in directed graph using BFS

public class Graph_09 {

    static Map<Integer,ArrayList<Integer>> map = new HashMap<>();
    static int[] inddgree ;
    static ArrayList<Integer> answer = new ArrayList<>();
    static Queue<Integer> q = new ArrayDeque<>();


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
    


    public static boolean Topological_Sort(Vector<Vector<Integer>> edges , int vertes , int edge){

        // Time complexity = O(edges + node)
        // Space Complexity = O(node+edge)

        // create adjecency list
        for(int i=0;i<edges.size();i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            addAdj(u, v, true);
        }

        // find indegree
        inddgree = new int[vertes+1];
        for(Map.Entry<Integer,ArrayList<Integer>> i : map.entrySet()){
            for(Integer j : i.getValue()){
                inddgree[j]++;
            }
        }

        inddgree[0]=-1;
        
        // push all element having indegree = 0
        for(int i=0;i<=vertes;i++){
            if(inddgree[i]==0){
                q.add(i);
            }
        }

        // imp         
        int count = 0 ;

        // do BFS       
        while(!q.isEmpty()){

            int ans = q.poll();
            
            // increment in count
            count++;

            if(map.get(ans)!=null){
                for(int x : map.get(ans)){
                    inddgree[x]--;
                    if(inddgree[x]==0){
                        q.add(x);
                    }
                }
            }

        }

        if(count == vertes){
            return false;
        }else{
            return true;
        }

    }



    public static void main(String[] args) {
        int[][] arr = {
            {1,2},{2,3},{3,1},
        };

        Vector<Vector<Integer>> edges = new Vector<>();

        for(int i=0;i<arr.length;i++){
            Vector<Integer> temp = new Vector<>();
            temp.add(arr[i][0]);
            temp.add(arr[i][1]);
            edges.add(temp);
        }

        int vertex = 3;
        int edge = 3 ;

        boolean answer = Topological_Sort(edges, vertex, edge);  

        System.out.println(answer);


    }
    

    
}
