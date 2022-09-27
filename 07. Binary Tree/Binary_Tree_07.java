import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

// zig zag traversal or spiral traversal

public class Binary_Tree_07 {

    public static ArrayList<Integer> zigZagTraversal(Binary_Tree_01.Node root){

        // Time complexity = O(n)
        // Space complexity = O(n)

        ArrayList<Integer> result = new ArrayList<>();

        if(root ==null){
            return result;
        }

        Queue<Binary_Tree_01.Node> q = new ArrayDeque<>();
        q.add(root);

        boolean leftToRight = true;

        // jab tak queue empty nhi ho jati
        while(!q.isEmpty()){

            int size = q.size();
            int[] ans = new int[size];

            // sare element ko array mai store krna hai
            for(int i=0;i<size;i++){
                Binary_Tree_01.Node frontNode = q.remove();

                // agar left se right krna hai toh 
                // array mai aage se store krenge
                // nhi toh piche se store karenge
                int index = leftToRight ? i : size - i -1;
                ans[index] = frontNode.data;

                if(frontNode.left!=null){
                    q.add(frontNode.left);
                }
                if(frontNode.right!=null){
                    q.add(frontNode.right);
                }
            }
            // direction change kar denge
            leftToRight = !leftToRight;

            // array copy kar denge result mai
            for(int i : ans){
                result.add(i);
            }

        }

        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,-1,-1,5,-1,-1,4,-1,6,7,-1,-1,8,-1,-1};
        Binary_Tree_01.Node root = null;
        root = Binary_Tree_01.buildTree(root, arr);
        Binary_Tree_01.levelOrderTraversal(root);

        System.out.println();

        ArrayList<Integer> array = zigZagTraversal(root);

        for(int i : array){
            System.out.print(i + " ");
        }
    }
}
