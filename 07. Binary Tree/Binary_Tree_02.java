// height of tree

public class Binary_Tree_02 {

    public static int height(Binary_Tree_01.Node root){

        // Time complexity = O(n)
        // Space complexity = O(height)  worst case : O(n)
        
        if(root==null){
            return 0;
        }
        
        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left,right) + 1;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,4,7,-1,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root);

        System.out.println("Height : " + height(root));
    }
}
