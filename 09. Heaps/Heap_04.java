// is Binary Tree a Heap

public class Heap_04 {

    static class Node{
        int data;
        Node left;
        Node right;
    }


    public static boolean isCBT(Node root , int index , int nodeCount){
        // null is CBT 
        if(root==null){
            return true;
        }
        // if index of element is greter than total number of nodes 
        if(index>nodeCount){
            return false;
        }else{
            boolean left = isCBT(root.left, 2*index+1 , nodeCount);
            boolean right = isCBT(root.right, 2*index+2 , nodeCount);

            return left && right;

        }
    }

    public static boolean isMaxHeap(Node root){
        // leaf node
        if(root.left==null && root.right==null){
            return true;
        }
        // node having only left child
        if(root.right == null){
            return root.data > root.left.data;
        // node having both child
        }else{
            boolean left_tree = isMaxHeap(root.left);
            boolean right_tree = isMaxHeap(root.right);

            boolean left = root.data > root.left.data;
            boolean right = root.data > root.right.data;

            return ((left && right) && (left_tree && right_tree));
        }
    }

    private static int nodeCount(Heap_04.Node root) {
        
        if(root==null){
            return 0;
        }
        return 1 + nodeCount(root.left) + nodeCount(root.right);
    }


    public static boolean isHeap(Node root){

        // heap = CBT + heap property 
        // first check CBT
        // second check max heap

        if(isCBT(root, 0, nodeCount(root)) && isMaxHeap(root)){
            return true;
        }else{
            return false;
        }
    }
    
}
