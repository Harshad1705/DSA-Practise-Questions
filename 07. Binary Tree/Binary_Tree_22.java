// Morris Traversal - print same as inorder traversal but inorder has space complexity-O(n)

// Time complexity = O(n)
// Space complexity = O(1)

public class Binary_Tree_22 {

    public static void morris_traversal(Binary_Tree_01.Node root){

        if(root==null){
            return;
        }

        Binary_Tree_01.Node curNode = root;
        Binary_Tree_01.Node preNode;

        while(curNode!=null){

            if(curNode.left==null){
                System.out.print(curNode.data + " ");
                curNode = curNode.right;
            }else{
                preNode = curNode.left;

                while (preNode.right != null && preNode.right != curNode)
                    preNode = preNode.right;

                if(preNode.right==null){
                    preNode.right = curNode;
                    curNode = curNode.left;
                }else{
                    preNode.right = null;
                    System.out.print(curNode.data + " ");
                    curNode = curNode.right;
                }
            }
        }


    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,-1,7,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root);
        System.out.println();
        
        morris_traversal(root);
    }
}
