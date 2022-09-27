import java.util.ArrayList;

// two sum in BST

// first brute force - by searching element which gets by subtracting target with root data's .


public class BST_06 {

    // brute force
    // Time complexity = O(n^2)

    static BST_01.Node toor = null;
    public static boolean isPresent( int data){

        BST_01.Node root = toor;

        while(root!=null){
            if(root.data == data){
                return true;
            }
            else if(root.data > data){
                root = root.left;
            }else{
                root = root.right;
            }

        }
        return false;
    }
    public static boolean isSum(BST_01.Node root , int target){

        if(root==null){
            return false;
        }

        boolean present = isPresent( target - root.data);
        if(present==true){
            return true;
        }

        boolean left = isSum(root.left, target);
        boolean right = isSum(root.right, target);

        return left || right;

    }

    // second approach
    // Time complexity = O(n)


    public static boolean isPairPresent(BST_01.Node root, int target){
        
        ArrayList<Integer> l = new ArrayList<>();

        ArrayList<Integer> list = inOrderTraversal(root , l);

        int i = 0;
        int j = list.size()-1;

        while( i < j){

            int sum = (list.get(i) + list.get(j));

            if( sum == target){
                return true;
            }else if( sum < target){
                i++ ;
            }else if( sum > target){
                j--;
            }
        }

        return false;
        
        
    }
    private static ArrayList<Integer> inOrderTraversal(BST_01.Node root , ArrayList<Integer> list) {
        if(root==null){
            return list;
        }
        inOrderTraversal(root.left,list);
        list.add(root.data);
        inOrderTraversal(root.right,list);

        return list;
    }
    public static void main(String[] args) {

        int[] arr = {2,1,3};

        BST_01.Node root = null;

        for(int i : arr){
            root = BST_01.insert(root, i);
        }
        toor = root;

        System.out.println(isPresent( 27));

        System.out.println(isSum(root, 5));

        System.out.println(isPairPresent(root, 5));



    }
    
}
