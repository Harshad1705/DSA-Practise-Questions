import java.util.ArrayList;

// flatten BST to a sorted list

// algo 
// store inorder
// left pointer = null
// right point = next node
// last node : right & left = null

public class BST_07 {

    public static ArrayList<Integer> inOrder(BST_01.Node root , ArrayList<Integer> list){

        if(root==null){
            return list;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);

        return list;
    }

    public static BST_01.Node flatten(BST_01.Node root)
    {

        // Time complexity = O(n)
        // Space complexity = O(n)

        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> list = inOrder(root, l);

        BST_01.Node newNode = new BST_01.Node(list.get(0));
        BST_01.Node temp = newNode;

        for(int i = 1; i<list.size() ; i++){
            
            BST_01.Node curNode= new BST_01.Node(list.get(i));

            temp.left = null;
            temp.right = curNode;

            temp = curNode;
        }
        temp.left = null;
        temp.right = null;


        return newNode;
    }
    public static void main(String[] args) {
        
        int[] arr = {10,8,21,7,27,5,4,3};

        BST_01.Node root = null;

        for(int i : arr){
            root = BST_01.insert(root, i);
        }

        System.out.println(flatten(root));
    }
}
