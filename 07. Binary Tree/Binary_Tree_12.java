
import java.util.Vector;

// left view of tree

public class Binary_Tree_12 {    

    public static Vector<Integer> left_view(Binary_Tree_01.Node root , int level){

        Vector<Integer> ans  = new Vector<>();
        solve(root,ans,0);
        return ans;

    }
    public static void solve(Binary_Tree_01.Node root, Vector<Integer> ans, int level) {
        if(root == null){
            return ;
        }
        // you entered into new level
        if(level == ans.size()){
            ans.add(root.data);
        }
        solve(root.left, ans, level+1);
        solve(root.right, ans, level+1);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,-1,-1,3,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        // Binary_Tree_01.levelOrderTraversal(root);

        System.out.println(left_view(root,0));
        
    }
}
