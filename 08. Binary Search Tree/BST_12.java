// Size of Largest BST in Binary Tree

public class BST_12 {

    static class Info{
        int min;
        int max;
        boolean isBST;
        int size;

        Info(){}

        Info(int min , int max , Boolean isBST , int size ){
            this.min = min;
            this.max  = max;
            this.isBST = isBST;
            this.size = size;

        }
    }

    public static Info solve(BST_01.Node root ){

        if(root==null){
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
        }

        Info left = solve(root.left);
        Info right = solve(root.right);

        Info data = new Info();

        data.isBST = (left.isBST==true) && (right.isBST==true) && (root.data > left.max)  && (root.data < right.min);
       
        data.min = Math.min(root.data, Math.min(left.min, right.min));
        
        data.max = Math.max(root.data ,Math.max(left.max, right.max));
        
        data.size = (data.isBST==true) ? (left.size + right.size + 1) : Math.max(left.size, right.size);

        return data;
    }


    public static int largestBST(BST_01.Node root){

        // Time complexity = O(n)
    
        Info ans = solve(root);

        return ans.size;
    }
}
