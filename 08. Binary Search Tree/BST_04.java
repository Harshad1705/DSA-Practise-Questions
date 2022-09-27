import java.util.ArrayList;

// find successor and predecessor element 

public class BST_04 {

    public static ArrayList<Integer> predecessorSuccessor(BST_01.Node root, int key) {
         
		// Time complexity = O(n)
		// Space complexity = O(1)
        
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        BST_01.Node temp = root;
        
        while(temp.data!=key){
            if(temp.data > key){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        list.add(temp.left.data);
        temp = temp.right;
        while(temp.left!=null){
            temp = temp.left;
        }
        list.add(temp.data);
        
        return list;
        
        
	}
    public static void main(String[] args) {

        int[] arr= {63 ,14 ,92, 5 ,50, 78, 97, 3}; 

        BST_01.Node root = null;

        for(int i : arr){
            root = BST_01.insert(root, i);
        }

        System.out.println(predecessorSuccessor(root, 63));

    }
}
