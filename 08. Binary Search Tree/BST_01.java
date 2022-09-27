import java.util.ArrayDeque;
import java.util.Queue;


// insert data in Binary search tree

class BST_01{

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // level order traversal
    
    public static void levelOrder(Node root){

        if(root==null){
            return;
        }
        Node deafultNode = new Node(-1);
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        q.add(deafultNode);

        while(!q.isEmpty()){

            Node curNode = q.remove();

            if(curNode.data==-1){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(deafultNode);
                }

            }else{
                System.out.print(curNode.data + " ");
                if(curNode.left!=null){
                    q.add(curNode.left);
                }
                if(curNode.right!=null){
                    q.add(curNode.right);
                }

            }
        }
    }

    // insert element in Tree
    public static Node insert(Node root , int key){

        // Time complexity = O(logN)

        if(root==null){
            Node newNode = new Node(key);
            return newNode;
        }
        if(root.data > key){
           root.left =  insert(root.left,key);
        }else{
            root.right = insert(root.right, key);
        }

        return root;
    }

    // search in Tree and return that node
    public static Node searchBST(Node root, int val) {
        if(root==null){
            return null;
        }
        if(root.data==val){
            return root;
        }
        if(root.data > val){
            return searchBST(root.left,val);
        }else{
            return searchBST(root.right,val);
        }
       
    }

    // serach in tree and boolean
    public static Boolean searchInBST_recursive(Node root, int x) {
        // Time complexity = O(logN)
        // Space complexity = O(logN)
        if(root==null){
            return false;
        }
        if(root.data==x){
            return true;
        }
        if(root.data > x){
            return searchInBST_recursive(root.left,x);
        }else{
            return searchInBST_recursive(root.right,x);
        }
	}

    // serach in tree and boolean
    public static Boolean searchInBST_iterative(Node root, int x){

        // Time complexity = O(logN)
        // Space complexity = O(1)

        if(root == null){
            return false;
        }
        Node temp = root;

        while(temp!=null){
            if(temp.data==x){
                return true;
            }
            if(temp.data > x){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }

        return false;
    }

    // Minimum value in Tree
    public static int minValue(Node root){ 
        if(root==null){
            return -1;
        } 
        Node temp = root;

        while(temp.left!=null){
            temp = temp.left;
        }

        return temp.data;
    }

    // Maximum value in Tree
    public static int maxValue(Node root){
        if(root==null){
            return -1;
        } 
        Node temp = root;

        while(temp.right!=null){
            temp = temp.right;
        }

        return temp.data;
    }

    // delete node from tree
    public static Node deleteNode(Node root, int X) {

        // Time complexity = O(logN)
        // Space complexity = O(logN)
        
        if(root==null){
            return null;
        }
        if(root.data==X){
            if(root.left==null && root.right==null){
                return null;
            } 
            if (root.left!=null && root.right==null){
                return root.left;
            }
            if(root.left==null && root.right!=null){
                return root.right;
            }
            if (root.left!=null && root.right!=null){
                int mini = minValue(root.right);
                root.data = mini;
                root.right = deleteNode(root.right , mini);
                return root;
            }
        }else if(root.data > X){
            root.left =  deleteNode(root.left,X);
        }else{
            root.right =  deleteNode(root.right,X);
        }
        
        return root;
    }

    public static void main(String[] args) {

        int[] arr = {10,8,21,7,27,5,4,3};

        Node root = null;

        for(int i : arr){
            root = insert(root, i);
        }

        levelOrder(root);
        System.out.println("------------------------------------");
        
        System.out.println(searchBST(root, 21));
        System.out.println(searchInBST_recursive(root, 4));
        System.out.println(searchInBST_iterative(root,6));
        System.out.println("------------------------------------");
        
        System.out.println("Minimum value : " + minValue(root));
        System.out.println("Maximum value : " + maxValue(root));
        System.out.println("------------------------------------");
        
        deleteNode(root, 10);
        levelOrder(root);
        System.out.println("------------------------------------");
        
    }
}

/*
void levelOrder(Node root);
Node insert(Node root , int key);
Node searchBST(Node root, int val);
Boolean searchInBST_recursive(Node root, int x);
Boolean searchInBST_iterative(Node root, int x);
int minValue(Node root);
int mAXValue(Node root);
 */