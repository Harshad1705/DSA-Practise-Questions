// lowest common ancestor

public class Binary_Tree_15 {

    public static Binary_Tree_01.Node LCA(Binary_Tree_01.Node root ,int n1,int n2){

        // Time complexity = O(n)
        // Space complexity = O(height)
         
        if(root==null){
            return null;
        }
        if(root.data==n1 || root.data==n2){
            return root;
        }

        Binary_Tree_01.Node left = LCA(root.left, n1, n2);
        Binary_Tree_01.Node right = LCA(root.right, n1, n2);

        if(left!=null && right!=null){
            return root;
        }else if(left==null && right!=null){
            return right;
        }else if(left!=null && right==null){
            return left;
        }else{
            return null;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,7,-1,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root);

        System.out.println(LCA(root, 7, 5).data);
    }
}
