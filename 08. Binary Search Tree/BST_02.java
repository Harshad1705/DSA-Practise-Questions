import java.util.ArrayList;

// validate BST

// approach-1 : inorder traversal and check if it BST or not
// approach-1 :  check every element that lies between a range or not

public class BST_02 {

    // Approach - 1
    static ArrayList<Integer> list = new ArrayList<>();
    static void inOrder( BST_01.Node root ){
        if(root==null){
            return ;
        }
        inOrder(root.left);
        list.add(root.data);
        inOrder(root.right);
    }
    public static boolean isBST(BST_01.Node root){

        inOrder(root);;

        for(int i=0;i<list.size()-2;i++){
            if(list.get(i) > list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    // Approach - 2
    static boolean isBST_2(BST_01.Node root , int min , int max){ 
        // Time complexity = O(n)
        // Space complexity = O(n)

        if(root==null)return true;
        
        if(root.data >= min && root.data <= max){
            boolean left  =  isBST_2(root.left,min , root.data);
            boolean right = isBST_2(root.right , root.data , max);
            return left && right;
        }else{
            return false;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {10,8,21,7,27,5,4,3};

        BST_01.Node root = null;

        for(int i : arr){
            root = BST_01.insert(root, i);
        }

        System.out.println(isBST(root));

        System.out.println(isBST_2(root , Integer.MIN_VALUE , Integer.MAX_VALUE));

    
    }
}
