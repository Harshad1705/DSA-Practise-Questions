import java.util.ArrayList;

// merge 2 BST - approach:1

public class BST_10 {

    public static ArrayList<Integer> inOrder(BST_01.Node root , ArrayList<Integer> list){
        if(root==null){
            return list;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);

        return list;
    }

    public static ArrayList<Integer> sort_and_merge_list(ArrayList<Integer> list_1 , ArrayList<Integer> list_2){

        ArrayList<Integer> list = new ArrayList<>();

        int size1 = list_1.size();
        int size2 = list_2.size();
        int i = 0;
        int j = 0;

        while((i < size1) && (j < size2)){

            int num1 = list_1.get(i);
            int num2 = list_2.get(j);

            if(num1<=num2){
                list.add(num1);
                i++;
            }else{
                list.add(num2);
                j++;
            }
        }


        if(i!=size1){
            for(int k=0;k<size1;k++){
                list.add(list_1.get(k));
            }
        }
        if(j!=size2){
            for(int k=j;k<size2;k++){
                list.add(list_2.get(k));
            }
        }

        return list;


    }

    public static BST_01.Node createNode( int min , int max, ArrayList<Integer> list){

        if(min > max){
            return null;
        }

        int mid = (min + max)/2;
    
        BST_01.Node root = new BST_01.Node(list.get(mid));

        root.left = createNode(min, mid-1, list);
        root.right = createNode(mid+1, max, list);

        return root;

    }
    public static BST_01.Node merge(BST_01.Node root1,BST_01.Node root2){

        // Time complexity = O(m+n)
        // Space complexity = O(m+n)

        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();

        // get element of both the tree
        ArrayList<Integer> list_1 = inOrder(root1, l1);
        ArrayList<Integer> list_2 = inOrder(root2, l2);

        System.out.println(list_1);
        System.out.println(list_2);

        // create new list 
        ArrayList<Integer> list = sort_and_merge_list(list_1, list_2);

        System.out.println(list);

        // create tree from list
        BST_01.Node newNode = createNode(0, list.size()-1, list);

        return newNode;

        
    }
    

    public static void main(String[] args) {
        
        int[] arr_1 = {3,6,2,4,5};

        BST_01.Node root_1 = null;

        for(int i : arr_1){
            root_1 = BST_01.insert(root_1, i);
        }

        int[] arr_2 = {7,1,3,2,6};

        BST_01.Node root_2 = null;

        for(int i : arr_2){
            root_2 = BST_01.insert(root_2, i);
        }

       BST_01.Node newNode  =  merge(root_1, root_2);

       BST_01.levelOrder(newNode);


    }
}
