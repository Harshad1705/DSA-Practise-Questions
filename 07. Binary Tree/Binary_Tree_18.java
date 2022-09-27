// Maximum sum of Non-adjacent nodes

public class Binary_Tree_18 {

    static class pair{
        int included;
        int excluded;

        pair(int x,int y){
            this.included = x;
            this.excluded = y;
        }
    }

    public static int getMaxSum(Binary_Tree_01.Node root)
    {
        // Time complexity = 
        if(root==null){
            return 0 ;
        }
        pair ans = solve(root);

        int max = Math.max(ans.excluded,ans.included);

        return max;

    }
    private static Binary_Tree_18.pair solve(Binary_Tree_01.Node root) {

        if(root==null){
            return new pair(0, 0);
        }

        pair left = solve(root.left);
        pair right = solve(root.right);

        int included = root.data + left.excluded + right.excluded;
        int excluded =  Math.max(left.included , left.excluded) + Math.max(right.included, right.excluded);

        return new pair(included, excluded);

    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,-1,-1,-1,3,5,-1,-1,6,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root);

        System.out.println(getMaxSum(root));
    }
}
