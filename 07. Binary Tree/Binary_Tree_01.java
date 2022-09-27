import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Binary_Tree_01{

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    
    static Scanner scn = new Scanner(System.in);

    // build a tree
    public static Node buildTree(Node root){

        System.out.println("Enter the data : ");
        int data = scn.nextInt();

        root = new Node(data);

        if(data == -1){
            return null;
        }

        System.out.println("Enter data for inserting in left : ");
        root.left = buildTree(root.left);

        System.out.println("Enter data for inserting in right : ");
        root.right = buildTree(root.right);

        return root;

    }


    // traverse a tree in level order traversal
    public static void levelOrderTraversal(Node root){

        if(root==null){
            return;
        }
        Node defaultNode = new Node(-1);

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        q.add(defaultNode);


        while(!q.isEmpty()){
            Node curNode = q.remove();

            if(curNode.data == -1){

                System.out.println();

                if(q.isEmpty()){
                    break;
                }else{
                    q.add(defaultNode);
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

    // build a tree in level order fashion
    public static Node buildTreeUsingLevelOrder(Node root){

        Queue<Node> q = new ArrayDeque<>();

        System.out.println("Enter data for root : ");
        int data = scn.nextInt();

        root = new Node(data);

        q.add(root);

        while(!q.isEmpty()){
            Node temp = q.remove();

            System.out.println("Enter data for left of " + temp.data + " : ");
            int leftdata = scn.nextInt();

            if(leftdata!=-1){
                temp.left = new Node(leftdata);
                q.add(temp.left);
            }

            System.out.println("Enter data for right of " + temp.data + " : ");
            int rightdata = scn.nextInt();

            if(rightdata!=-1){
                temp.right = new Node(rightdata);
                q.add(temp.right);
            }
        }

        return root;

    }

    // build a tree by using array
    static int index = -1;
    public static Node buildTree(Node root, int[] arr){
        index++;
        if(arr[index] == -1){
            return null;
        }
        root = new Node(arr[index]);

        root.left = buildTree(root,arr);
        root.right = buildTree(root,arr);

        return root;

    }

    // calculate number of leaf in tree
    static int getLeafCount(Node node){
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return getLeafCount(node.left) + getLeafCount(node.right);
    }

    public static void main(String[] args) {
        
        // Node root = null;
        // root = buildTree(root);
        // levelOrderTraversal(root);

        // Node root_2 = null;
        // root_2 = buildTreeUsingLevelOrder(root_2);
        // levelOrderTraversal(root_2);

        int arr[] = {1,2,4,7,-1,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root_3 = null;
        root_3 = buildTree(root_3, arr);
        levelOrderTraversal(root_3);


        System.out.println(getLeafCount(root_3));

        
    }
}



/*
Node buildTree(Node root);
void levelOrderTraversal(Node root);
Node buildTreeUsingLevelOrder(Node root);
Node buildTree(Node root, int[] arr);
int getLeafCount(Node node);
 */