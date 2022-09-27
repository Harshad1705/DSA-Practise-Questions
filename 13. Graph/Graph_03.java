import java.util.*;

// Depth first search

class Graph_03 {
    
    public static void  dfs(int v, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list,boolean visited[]) {

        list.add(v);
        visited[v]=true;
        
        for(int i:adj.get(v)) {
            if(visited[i]==false)
            dfs(i,adj,list,visited);
        }
        
        
    }

    public static ArrayList<Integer> depthFirstSearch(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> list=new ArrayList<>();
        boolean visited[] = new boolean[V];

        dfs(0,adj,list,visited);
        
        return list;
        
    }

    public static void main(String[] args) {
        int[][] arr= {
            {0, 1},
            {0, 3},
            {1, 2},
            {2, 3},
        };


        ArrayList<ArrayList<Integer>> edges  =  new ArrayList<>();

        for(int i=0 ; i<arr.length ; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(arr[i][0]);
            temp.add(arr[i][1]);

            edges.add(temp);
        }


        int V = 5 ;

        ArrayList<Integer> ans = depthFirstSearch(V , edges);

        System.out.println(ans);
    }
}

// In c++


// #include<unordered_map>

// void dfs(int node , vector<int> &temp ,unordered_map<int,list<int>> &adj ,unordered_map<int,bool> &visited){
//     temp.push_back(node);
//     visited[node] = true;
    
//     for(auto i : adj[node]){
//         if(!visited[i]){
//             dfs(i,temp,adj,visited);
//         }
//     }
// }

// vector<vector<int>> depthFirstSearch(int V, int E, vector<vector<int>> &edges)
// {

//     unordered_map<int,list<int>> adj;
    
//     for(int i=0;i<edges.size();i++){
//         int u = edges[i][0];
//         int v = edges[i][1];
        
//         adj[u].push_back(v);
//         adj[v].push_back(u);
//     }
    
//     vector<vector<int>> ans ;
//     unordered_map<int,bool> visited;
    
//     for(int i=0;i<V;i++){
//         if(!visited[i]){
//             vector<int> temp;
//             dfs(i , temp , adj , visited);
//             ans.push_back(temp);
//         }
//     }
    
    
//     return ans;
// }