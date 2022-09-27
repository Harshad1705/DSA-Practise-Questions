// boundary traversal

// algorithm
// left part print - exclusive leaf
// leaf node print
// right node print - exclusive leaf and in reverse order

public class Binary_Tree_08 {

    public static void boundary_traversal(Binary_Tree_01.Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        left_boundary(root.left);
        leaf_boundary(root.left);
        leaf_boundary(root.right);
        right_boundary(root.right);
    }
    private static void right_boundary(Binary_Tree_01.Node root) {
        if(root==null || (root.left==null && root.right==null)){
            return;
        }
        if(root.right!=null)
            right_boundary(root.right);
        else
            right_boundary(root.left);
            
        System.out.print(root.data + " ");
    }
    private static void leaf_boundary(Binary_Tree_01.Node root) {
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            System.out.print(root.data+" ");
            return;
        }
    
        leaf_boundary(root.left);
        leaf_boundary(root.right);
    }
    private static void left_boundary(Binary_Tree_01.Node root) {
        if(root==null || (root.left==null && root.right==null)){
            return;
        }
        System.out.print(root.data + " ");
        if(root.left !=null)
            left_boundary(root.left);
        else
            left_boundary(root.right);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,-1,-1,5,-1,-1,4,-1,6,7,-1,-1,8,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        // Binary_Tree_01.levelOrderTraversal(root);

        boundary_traversal(root);
    }
}
