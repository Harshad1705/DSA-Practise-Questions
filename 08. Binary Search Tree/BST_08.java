import java.util.ArrayList;

// convert Normal BST To Balanced BST

public class BST_08 {

    public static ArrayList<Integer> inOrder(BST_01.Node root , ArrayList<Integer> list){

        if(root==null){
            return list;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);

        return list;
    }

    public static BST_01.Node createNode( int min , int max , ArrayList<Integer> list){

        // base condition
        if(max < min ){
            return null;
        }
        // find Mid value
        int mid = (min + max) / 2;

        // create node of mid value
        BST_01.Node node = new BST_01.Node(list.get(mid));

        // recurssive calls
        node.left = createNode( min, mid-1, list);
        node.right = createNode( mid+1, max, list);

        // return node 
        return node;
    }

    public static BST_01.Node buildBalancedTree(BST_01.Node root) {

        // Time complexity = O(n)
        // Space complexity = O(n)

        // step - 1 : store element in inorder traversal
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> list = inOrder(root, l);

        // step - 2 : create node which contain middle element of list
        BST_01.Node newNode = createNode( 0, list.size()-1 , list);

        return newNode;
        
    }
    public static void main(String[] args) {
        
        int[] arr = {30,20,10};

        BST_01.Node root = null;

        for(int i : arr){
            root = BST_01.insert(root, i);
        }

        BST_01.levelOrder(root);
        System.out.println("---------------------");
        root = buildBalancedTree(root);

        BST_01.levelOrder(root);


    }
}
