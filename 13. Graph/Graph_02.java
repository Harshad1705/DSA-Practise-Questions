import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

// BFS traversal in Graph

class Solution {
    
    static Map<Integer,ArrayList<Integer>> adj = new HashMap<>();
    static Map<Integer,Boolean> visited = new HashMap<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    
    public static void addList(int u , int v , boolean direction){
        
        ArrayList<Integer> temp = new ArrayList<>();
        if(adj.get(u)!=null){
            temp = adj.get(u);
        }
        temp.add(v);
        
        adj.put(u , temp);
        
        if(direction==false){
            addList(v,u,true);
        }
        
        
    }
    
    public static void bfs(int i){
        // create a queue
        Queue<Integer> q = new ArrayDeque<>();
        // add first value in queue
        q.add(i);
        // mark it visisted
        visited.put(i,true);

        // upto queue not empty
        while(!q.isEmpty()){
            // remove front element
            int frontHead = q.poll();
            // add in answer
            ans.add(frontHead);
            // if list in adj is not null then
            if(adj.get(frontHead)!=null){
                // traverse in all list
                for( int x :  adj.get(frontHead)){
                    // if the value is false
                    if(visited.get(x)==false){
                        // then add in queue
                        q.add(x);
                        // and mark it true
                        visited.put(x,true);
                    }
                }
            }

        }
        
    }
    
    
	public static ArrayList<Integer> BFS(int vertex, int edges[][]){

        // Time complexity : O(N+E)     N = vertex , E = edge
        // Space complexity : O(N+E)
		
        // adding values in adjecency list
        int n = edges.length;
        
        for(int i=0;i<n;i++){
            addList(edges[i][0], edges[i][1], false);
        }
        
        // adding values in visited
        for(int i=0;i<vertex;i++){
            visited.put(i,false);
        }        
        
        // traversing all component of graph
        for(int i=0;i<vertex;i++){
            if(!visited.get(i)){
                bfs(i);
            }
        }
        
        return ans; 
        
	}


    public static void main(String[] args) {
        int[][] arr= {
            {0, 1},
            {0, 3},
            {1, 2},
            {2, 3},
        };
        int n = 4 ;

        BFS(n, arr);

        System.out.println(ans);
    }
}

