import java.util.Vector;

// right view of tree

public class Binary_Tree_13 {    

    public static Vector<Integer> right_view(Binary_Tree_01.Node root , int level){

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
        solve(root.right, ans, level+1);
        solve(root.left, ans, level+1);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root);

        System.out.println(right_view(root,0));
        
    }
}