// flatten binary tree to linked list 

public class Binary_Tree_23 {
    public static void flatten (Binary_Tree_01.Node root){

        if(root == null){
            return;
        }
        Binary_Tree_01.Node curNode = root;
        
        while(curNode!=null){

            if(curNode.left!=null){

                Binary_Tree_01.Node prevNode = curNode.left;

                while(prevNode.right!=null){
                    prevNode = prevNode.right;
                }

                prevNode.right = curNode.right;
                curNode.right = curNode.left;
                curNode.left = null;
            }

            curNode = curNode.right;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,4,-1,7,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root);
        System.out.println();

        flatten(root);

        
    }
}
