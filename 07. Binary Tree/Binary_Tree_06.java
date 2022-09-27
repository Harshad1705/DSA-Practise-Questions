// check sum tree or not

public class Binary_Tree_06 {

    static class TreeInfo{
        boolean isSum;
        int sum;

        TreeInfo(boolean x , int y){
            this.isSum = x;
            this.sum = y;
        }
    }

    public static TreeInfo isSumTree(Binary_Tree_01.Node root){

        // Time complexity = O(n)

        if(root == null){
            return new TreeInfo(true, 0);
        }
        if(root.left==null && root.right==null){
            return new TreeInfo(true,root.data);
        }

        TreeInfo left = isSumTree(root.left);
        TreeInfo right = isSumTree(root.right);

        boolean left_sumTree = left.isSum;
        boolean right_sumTree = right.isSum;
        boolean condition = (left.sum + right.sum) == root.data;

        boolean ans = left_sumTree && right_sumTree && condition;

        int total_sum = (left.sum + right.sum) + root.data;

        TreeInfo info = new TreeInfo(ans,total_sum );

        return info;
       
    }
    public static void main(String[] args) {

        int arr[] = {3,1,-1,-1,2,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root);

        System.out.println(isSumTree(root).isSum);
    }
}
