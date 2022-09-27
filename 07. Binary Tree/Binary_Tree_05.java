// determine two trees are identical or not

public class Binary_Tree_05 {

    public static boolean isIdentical(Binary_Tree_01.Node root1 , Binary_Tree_01.Node root2){

        // Time complexity = O(n)

        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root1.data == root2.data){
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,-1,-1,3,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root);

        Binary_Tree_01.index = -1;

        Binary_Tree_01.Node root_2 = null;
        root_2 = Binary_Tree_01.buildTree(root_2, arr);
        Binary_Tree_01.levelOrderTraversal(root_2);

        System.out.println(isIdentical(root, root_2));


    }
}
