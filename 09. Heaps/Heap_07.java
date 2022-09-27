// convert BST to min heap
 
// N < L ,  N < R                  // min Heap condition
// L < R                           // extra condition to be fulfilled

// N < L < R                       // so overall condition  ( preorder )

public class Heap_07 {  

    static class Node{
        int data;
        Node left;
        Node right;
    }

    static int index = -1;
    public static Node preOrder(Node root , int[] arr){

        index++;

        if(arr[index]==-1){
            return null;
        }
        
        root.data = arr[index];
        
        preOrder(root.left, arr);
        preOrder(root.right, arr);

        return root;
    }

    public static void main(String[] args) {
        
         
    }
    
}


// BST to MAx Heap


// class Solution

// {

//     public static ArrayList<Integer> list=new ArrayList<>();

//     static int i=0;

//     public static void InOrderTraversal(Node root){

        

//         if(root == null) return ;

//         InOrderTraversal(root.left);

//         list.add(root.data);

//         InOrderTraversal(root.right);

//     }

//     public static void PreOrderTraversal(Node root){

//         if(root == null )return; 

//         PreOrderTraversal(root.left);

//         PreOrderTraversal(root.right);

//         root.data= list.get(i);

//         i++;

//     }

//     public static void convertToMaxHeapUtil(Node root)

//     {

//         //code here

//         InOrderTraversal(root);

//         PreOrderTraversal(root);

//     }

// }