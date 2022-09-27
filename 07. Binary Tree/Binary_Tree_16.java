
import java.util.Vector;

// K Sum Paths

public class Binary_Tree_16 {

    static Vector<Integer> path = new Vector<>();
    static int count = 0;

    public static void KSum(Binary_Tree_01.Node root, int k) {

        if(root==null){
            return;
        }

        path.add(root.data);

        KSum(root.left,k);
        KSum(root.right, k);

        int size = path.size()-1;
        int sum = 0;
        for(int i=size ;i>=0;i--){
            sum = sum + path.get(i);
            if(sum == k){
                count++;
            }
        }

        path.remove(path.size()-1);

    }


    
    public static void main(String[] args) {
        int arr[] = {1,2,-1,-1,3,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root);

        KSum(root, 3);
        System.out.println(count);
    }
}
