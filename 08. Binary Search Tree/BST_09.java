import java.util.ArrayList;

// BST from preorder traversal

// approach-1 : just create a BST , it will automatically in BST
// Time complexity = O(n^2)

// approach-2 : sort the poreorder
//            : now we have preorder and inorder
//            : this prroblem is solved in Binary tree series
// Time complexity = O(NlogN)

// approach-3 : check every element in between range
// Time complexity = O(n)


public class BST_09 {

    // approach - 1
    public static ArrayList<Integer> inOrder(BST_01.Node root , ArrayList<Integer> list){

        if(root==null){
            return list;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);

        return list;
    }

    // approach-3
    static int index = 0;
    public static BST_01.Node createBST(ArrayList<Integer> arr){

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        BST_01.Node newNode = solve(arr, min, max);

        return newNode;
    }
    public static BST_01.Node solve(ArrayList<Integer> arr , int min , int max) {

        if(index >= arr.size()){
            return null;
        }
        if(arr.get(index) < min || arr.get(index) > max){
            return null;
        }

        BST_01.Node newNode = new BST_01.Node(arr.get(index));
        index = index+1;

        newNode.left = solve(arr, min, newNode.data); 
        newNode.right = solve(arr, newNode.data, max);
        
        return newNode;
    
    }
    public static void main(String[] args) {
        int[] arr = {15, 10 ,7 ,13, 21, 20, 25 };

        BST_01.Node root = null;

        for(int i : arr){
            root = BST_01.insert(root, i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(10);
        list.add(7);
        list.add(13);
        list.add(21);
        list.add(20);
        list.add(25);
        BST_01.Node root3 = createBST( list);
        BST_01.levelOrder(root3);



    }
}
