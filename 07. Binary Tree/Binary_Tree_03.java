// diameter of binary tree

public class Binary_Tree_03 {

    static class TreeInfo{
        int height;
        int diameter;

        TreeInfo(int x,int y){
            this.height = x;
            this.diameter = y;
        }
    }

    public static TreeInfo diameter_optimized(Binary_Tree_01.Node root){

        // Time complexity : O(n)

        if(root==null){
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter_optimized(root.left);
        TreeInfo right = diameter_optimized(root.right);

        int opt1 = left.diameter;
        int opt2 = right.diameter;
        int opt3 = left.height + right.height + 1;
        int ans = Math.max(opt1, Math.max(opt2, opt3));

        int h = Math.max(left.height, right.height) + 1;
        
        TreeInfo info = new TreeInfo(h, ans);
        
        return info;

    }

    public static int diameter(Binary_Tree_01.Node root){

        // Time complexity : O(n^2)

        if(root==null){
            return 0;
        }
        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);
        int diaIncludeRoot = Binary_Tree_02.height(root.left) + Binary_Tree_02.height(root.right) + 1;

        int ans = Math.max(leftDia,Math.max(rightDia,diaIncludeRoot));

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,7,-1,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root);

        System.out.println("Diameter : " + diameter(root));

        System.out.println("Diameter : " + diameter_optimized(root).diameter);
        System.out.println("Height : " + diameter_optimized(root).height);
    }
}
