// find Kth- smallest element in tree
// find Kth- largest element in tree

// approach-1 : inorder travreal first then get smallest element

public class BST_03 {

    static int index = 0;
    public static int KthSmallestElement(BST_01.Node root, int K) {

        // Time complexity = O(n)
        // Time complexity = O(height)

        if(root==null){
            return -1;
        }
        // Left
        int left = KthSmallestElement(root.left, K);
        if(left!=-1){
            return left;
        }
        // Node
        index = index + 1;
        if(index == K){
            return root.data;
        }
        // Right
        return KthSmallestElement(root.right, K);  
    }

    static int count = 0;
    public static int KthLargestElement(BST_01.Node root, int K) {
        
        // Time complexity = O(n)
        // Time complexity = O(height)

        if(root==null){
            return -1;
        }
        // Right
        int right = KthLargestElement(root.right, K);
        if(right!=-1){
            return right;
        }
        // Node
        count = count + 1;
        if(count == K){
            return root.data;
        }
        // Left
        return KthLargestElement(root.left, K);  
    }

    public static void main(String[] args) {

        int[] arr= {63 ,14 ,92, 5 ,50, 78, 97, 3}; 

        BST_01.Node root = null;

        for(int i : arr){
            root = BST_01.insert(root, i);
        }

        System.out.println(KthSmallestElement(root, 3));
        System.out.println(KthLargestElement(root, 6));

    }

    
}
