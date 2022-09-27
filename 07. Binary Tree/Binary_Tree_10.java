import java.util.ArrayDeque;
import java.util.ArrayList; 
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// top view of tree

public class Binary_Tree_10 {

    static class queue{
        Binary_Tree_01.Node node;
        Integer horizontal_distance;
        
        queue(int x , Binary_Tree_01.Node node){
            this.node = node;
            this.horizontal_distance = x;
        }
    }

    public static ArrayList<Integer> top_view(Binary_Tree_01.Node root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<queue> q = new ArrayDeque<>();

        q.add(new queue(0,root));

        while(!q.isEmpty()){
            queue temp = q.remove();

            Binary_Tree_01.Node node = temp.node;
            int horizonal = temp.horizontal_distance;

            if(!map.containsKey(horizonal)){
                map.put(horizonal, node.data);
            }

            if(node.left!=null){
                q.add(new queue(horizonal-1,root.left));
            }
            if(node.right!=null){
                q.add(new queue(horizonal+1,root.right));
            }

        }
        
        for(Map.Entry<Integer,Integer> i :map.entrySet()){
            result.add(i.getValue());
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,-1,-1,3,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        // Binary_Tree_01.levelOrderTraversal(root);

        System.out.println(top_view(root));
        
    }
}
