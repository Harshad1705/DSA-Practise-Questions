
// Kth ancestor

public class Binary_Tree_17 {

    static int K ;

    public static Binary_Tree_01.Node solve(Binary_Tree_01.Node root , int node){

        if(root==null){
            return null;
        }
        if(root.data == node){
            return root;
        }
        Binary_Tree_01.Node left=solve(root.left, node);
        Binary_Tree_01.Node right=solve(root.right, node); 

        // wapas jate waqt
        if(left==null && right!=null){
            K--;
            if(K<=0){
                // answer lock 
                K = Integer.MAX_VALUE;
                return root;
            }
            return right;
        }
        if(left!=null && right==null){
            K--;
            if(K<=0){
                K = Integer.MAX_VALUE;
                return root;
            }
            return left;
        }

        return null;

    }
    public static int KAncestor(Binary_Tree_01.Node root , int k , int node){

        // Time complexity = O(n)
        // Space complexity = O(height)

        K = k;
        Binary_Tree_01.Node ans = solve(root, node);
        if(ans == null || ans.data==node){
            return -1;
        }
        return ans.data;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root);

        System.out.println();
        int ans =  KAncestor(root, 2, 4);
        System.out.println(ans);
    }
}
