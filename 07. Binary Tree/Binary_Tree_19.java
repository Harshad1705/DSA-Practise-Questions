import java.util.HashMap;
import java.util.Map;

// Construct Tree from Inorder & Preorder 

// Algotrithm
// create first node as root of preorder
// find elemnet in inorder
// for left child = 0 to indoex-1
// for right child = indox+1 to size-1

public class Binary_Tree_19 {

    // public static int findPosition(int in[] , int element){
    //     for(int i=0;i<in.length-1;i++){
    //         if(element==in[i]){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    

    private static Binary_Tree_01.Node solve(int[] inorder, int[] preorder, int index, int startIndex, int endIndex,int n) {
        
        // base case
        if(index >= n || startIndex>endIndex){
            return null;
        }
        // create a node for element
        int ele = preorder[index];
        Binary_Tree_01.Node root = new Binary_Tree_01.Node(ele);
        // find position of element in indorder array
        int position = map.get(ele);

        // recurrsive calls
        root.left = solve(inorder, preorder, index+1, startIndex, position-1, n);
        root.right = solve(inorder, preorder, index+1, position+1,endIndex, n);

        return root;
    }

    static Map<Integer,Integer> map = new HashMap<>();
    public static void create_map(Map<Integer,Integer> map , int[] inorder , int n){
        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }
    }
    public static Binary_Tree_01.Node buildTree(int[] inorder , int[] preorder , int n){

        // Time complexity = O(NlogN)
        // Space complexity = O(N)

        int index = 0;
        int startIndex = 0;
        int endIndex = n-1;
        create_map(map, inorder, n);

        Binary_Tree_01.Node root = solve(inorder , preorder , index , startIndex , endIndex , n);

        return root;
    }
    
    public static void main(String[] args) {

        int inorder[] = {1 ,6, 8, 7};
        int preorder[] = {1 ,6 ,7 ,8};
        int n = 4;

        Binary_Tree_01.Node root = buildTree(inorder , preorder ,n);

        Binary_Tree_01.levelOrderTraversal(root);

    }
}
