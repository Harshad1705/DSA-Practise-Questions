import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

// minimum time to burn a tree

// approach
// create mapping between node to its parent node
// find target node
// create queue and map for visited node and time variable

public class Binary_Tree_21{

    // create mapping and return target node
    public static Binary_Tree_01.Node create_mapping(Binary_Tree_01.Node root , int target){

        Binary_Tree_01.Node res = null;

        Queue<Binary_Tree_01.Node> q = new ArrayDeque<>();
        q.add(root);

        // mark root parent to null
        map.put(root, null);

        while(!q.isEmpty()){

            Binary_Tree_01.Node front = q.remove();
            // find target node
            if(front.data == target){
                res = front;
            }
            // if left node exist 
            if(front.left!=null){
                map.put(front.left, front);
                q.add(front.left);
            }
            // if right node exist
            if(front.right!=null){
                map.put(front.right, front);
                q.add(front.right);
            }

        }
        // return targer node
        return res;
    }

    public static int burnTree(Binary_Tree_01.Node root){

        // creayte a map for visited nodes
        Map<Binary_Tree_01.Node,Boolean> visited = new HashMap<>();
        // create queue to travers in tree in level order
        Queue<Binary_Tree_01.Node> q = new ArrayDeque<>();

        // put target node in queue
        q.add(root);
        // mark target node true
        visited.put(root, true);

        // create ans for total time
        int ans = 0;

        // iterate upto queue not empty
        while(!q.isEmpty()){

            boolean flag = false;

            int size = q.size();

            // iterate in queue upto its size
            for(int i=0;i<size;i++){

                // proccess neighbouring nodes
                Binary_Tree_01.Node front = q.remove();

                // if left exist and it is false in visited map
                if(front.left!=null && (!visited.containsKey(front.left))){
                    flag = true;
                    visited.put(front.left, true);
                    q.add(front.left);
                }
                // if right exist and it is false in visited map
                if(front.right!=null && (!visited.containsKey(front.right))){
                    flag = true;
                    visited.put(front.right, true);
                    q.add(front.right);
                }
                // if parent of that node exist and it is false in visited map
                if((map.get(front)!=null) &&(!visited.containsKey(map.get(front)))){
                    flag = true;
                    visited.put(map.get(front), true);
                    q.add(map.get(front));
                }
            }
            // if any node added in queue
            if(flag==true){
                ans = ans +1;
            }

        }
        // return ans
        return ans;
    }

    static Map<Binary_Tree_01.Node , Binary_Tree_01.Node> map = new HashMap<>();

    public static int minTime(Binary_Tree_01.Node root ,int target){

        // Time Complexity = O(n)
        // Space Complexity = O(n)
        
        // create a map between child node and parent node
        Binary_Tree_01.Node targetNode = create_mapping(root, target);

        return burnTree(targetNode);
    }

    public static void main(String[] args) {

        int arr[] = {1,2,4,-1,-1,5,7,-1,-1,8,-1,-1,3,-1,6,-1,9,-1,10,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root); 

        System.out.println(minTime(root, 8));
        
    }
}