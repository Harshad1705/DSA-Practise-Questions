import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;


// cycle detection in undirected graph using BFS

public class Graph_04 {

    static Map<Integer,ArrayList<Integer>> map = new HashMap<>();
    static Map<Integer,Boolean> visited = new HashMap<>();
    static Map<Integer,Integer> parent = new HashMap<>();

    static boolean cycle = false;


    // function to add values in Adj List
    public static void addAdj(int u,int v , boolean direction){

        ArrayList<Integer> temp = new ArrayList<>();
        
        if(map.get(u)!=null){
            temp = map.get(u);
        }
        temp.add(v);

        map.put(u,temp);

        if(direction==false){
            addAdj(v, u, true);
        }

    }


    public static boolean bfs(int i){

        // create queue
        Queue<Integer> q = new ArrayDeque<>();
        // add in queue
        q.add(i);
        // mark true in visited
        visited.put(i, true);
        // entry in parent
        parent.put(i, -1);

        // while q is not empty
        while(!q.isEmpty()){
            // remove first element
            int frontNode = q.poll();
            // if it has edges
            if(map.get(frontNode)!=null){
                // then traverse all the edges
                for(int x : map.get(frontNode)){
                    // if its child != parent[parent]
                    if(visited.get(x)==true && x!=parent.get(frontNode)){
                        return true;
                    }
                    else{
                        q.add(x);
                        visited.put(x, true);
                        parent.put(x, frontNode);
                    }
                }
            }


        }
        return false;

    }




    public static String cycleDetection(int[][] arr , int n , int m){

        // Time complexity = O(n)


        // all value in visited now become false
        for(int i=1;i<=n;i++){
            visited.put(i, false);
        }

        // putting values in adj list
        for(int i=0;i<arr.length;i++){
            int u = arr[i][0];
            int v = arr[i][1];
            addAdj(u, v, false);
        }

        // treavese all the nodes
        for(int i=1;i<=n;i++){
            // if visited node is false then
            if(visited.get(i)==false){
                boolean ans = bfs(i);
                if(ans==true){
                    return "true";    
                }

            }
        }
        return "false";


    }


    public static void main(String[] args) {

        int[][] arr = {
            {1,2},{2,3},{4,5},{5,6},{5,7},{7,8},{6,8},{8,9},
        };

        int n = 9;

        System.out.println(cycleDetection(arr, n, 7));


    }
    
}
