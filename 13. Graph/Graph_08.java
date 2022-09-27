import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

// Khan's Algorithm
// Topological Sort using BFS - 

// find indegree of all nodes
// insert all 0 degree node in queue 
// do BFS - remove top
//          decrease its indrgree by 1 , if it 0 then push into stack
//          include into answer

public class Graph_08 {

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
    


    public static void Topological_Sort(Vector<Vector<Integer>> edges , int vertes , int edge){

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

        // do BFS
        while(!q.isEmpty()){

            int ans = q.poll();
            
            // add in answer
            answer.add(ans);

            if(map.get(ans)!=null){
                for(int x : map.get(ans)){
                    inddgree[x]--;
                    if(inddgree[x]==0){
                        q.add(x);
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        int[][] arr = {
            {1,2},{1,3},{2,5},{3,5},{5,4},
        };

        Vector<Vector<Integer>> edges = new Vector<>();

        for(int i=0;i<arr.length;i++){
            Vector<Integer> temp = new Vector<>();
            temp.add(arr[i][0]);
            temp.add(arr[i][1]);
            edges.add(temp);
        }

        int vertex = 5;
        int edge = 5 ;

        Topological_Sort(edges, vertex, edge);  // 1 2 3 5 4

        System.out.println(answer);


    }
    

    
}
