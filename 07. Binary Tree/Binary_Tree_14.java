// Sum of the Longest Bloodline of a Tree

public class Binary_Tree_14 {

    static int maxLen;
    static int maxSum;

    public static int  largest_sum(Binary_Tree_01.Node root ){

        // Time complexity = O(n)
        // Space complexity = O(height)
        
        if(root==null){
            return 0;
        }
        maxSum = Integer.MIN_VALUE;
        maxLen = 0;

        solve(root , 0 , 0 );

        return maxSum;
    }
    private static void solve(Binary_Tree_01.Node root, int sum, int level) {

        if(root == null){
            if(level > maxLen){
                maxLen = level;
                maxSum = sum;
            }else if(level == maxLen && sum > maxSum){
                maxSum = sum;
            }
            return;
        }
        sum = sum + root.data;
        solve(root.left, sum  , level + 1  );
        solve(root.right, sum  , level + 1);
           
    }
    public static void main(String[] args) {
        int arr[] = {4,2,7,-1,-1,1,6,-1,-1,-1,5,2,-1,-1,3,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root);

        System.out.println(largest_sum(root));

    }
}
