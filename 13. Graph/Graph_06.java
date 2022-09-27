import java.util.*;

// cycle detection in directed graph using DFS

public class Graph_06 {
    
    static Map<Integer,ArrayList<Integer>> map = new HashMap<>();
    static Map<Integer,Boolean> visited = new HashMap<>();
    static Map<Integer,Boolean> dfs_visited = new HashMap<>();
    
    public static void addList(int u  , int v){
        ArrayList<Integer> temp = new ArrayList<>();
        if(map.get(u)!=null){
            temp = map.get(u);
        }
        temp.add(v);
        
        map.put(u,temp);
    }
    
    public static boolean  dfs(int node){
        visited.put(node,true);
        dfs_visited.put(node,true);
        
        if(map.get(node)!=null){
            for(int x : map.get(node)){
                if(visited.get(x)==false){
                    boolean ans = dfs(x);
                    if(ans==true){
                        return true;
                    }
                }else if(dfs_visited.get(x)==true){
                    return true;
                }
            }
        }
        
        dfs_visited.put(node,false);
        
        return false;
    }
    
    
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {

    // Time Complexity = O(edges+nodes)
    // Space Complexity = O(nodes)
    
      for(int i=0;i<edges.size();i++){
          int u = edges.get(i).get(0);
          int v = edges.get(i).get(1);
          addList(u,v);          

        
      }
      
      for(int i=1;i<=n;i++){
          visited.put(i,false);
           dfs_visited.put(i,false);
      }
      
      for(int i=1;i<=n;i++){
          if(visited.get(i)==false){
              boolean ans = dfs(i);
              if(ans==true){
                  return true;
              }
          }
      }
      
      return false;
      
  }


  public static void main(String[] args) {

    int[][] z = {
        {1 ,2},
        {2 ,3},
        {3 ,4},
        {4 ,5},
    };

    int n = 5;

    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    for(int i=0;i<z.length;i++){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(z[i][0]);
        temp.add(z[i][1]);
        arr.add(temp);
    }


    System.out.println(detectCycleInDirectedGraph(n,arr));

    
  }
}