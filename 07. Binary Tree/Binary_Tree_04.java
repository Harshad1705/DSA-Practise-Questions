// check for balanced tree

public class Binary_Tree_04 {

    static class TreeInfo{
        boolean balanced;
        int height;

        TreeInfo(boolean x ,int y){
            this.balanced = x;
            this.height = y;
        }
    }

    public static TreeInfo isBalanced_optimized(Binary_Tree_01.Node root){

        // Time complexity = O(n)

        if(root==null){
            return new TreeInfo(true,0);
        }

        TreeInfo left = isBalanced_optimized(root.left);
        TreeInfo right = isBalanced_optimized(root.right);

        boolean balanced = Math.abs((left.height - right.height)) <=1;
        boolean ans = left.balanced && right.balanced && balanced;

        int totalHeight = Math.max(left.height, right.height) + 1;

        return new TreeInfo(ans,totalHeight);

    }

    public static boolean isBalanced(Binary_Tree_01.Node root){

        // Time complexity : O(n^2)
         
        if(root == null){
            return true;
        }

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        boolean diff = Math.abs(Binary_Tree_02.height(root.left) - Binary_Tree_02.height(root.right)) <=1;

        if(left && right && diff){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,7,-1,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root);

        System.out.println(isBalanced(root));
        System.out.println(isBalanced_optimized(root).balanced);
    }
}
