
// merge 2 BST - approach:2

// step-1  : sort both the tree into linked list . 
//        Time complexity :  O(m)   O(n)
//        Space complexity : O(h1)  O(h2) 
// step-2 : merge 2 sorted linked list
//        Time complexity : O(m+n)
//        Space complexity : O(1)
// step-3 : sort linked list into BST 
//        Time complexity :O(m+n)
//        Space complexity : O(h1+h2)

// 3 question made in this question --
// convert a BST into sorted Linked List
// merge 2 sorted linked list
// convert sorted linked list into BST


public class BST_11 {
    
    // convert a BST into sorted Linked List
    public static void convertIntoSortedDLL(BST_01.Node root , BST_01.Node head){
        // base case
        if(root==null){
            return;
        }
        // right subtree
        convertIntoSortedDLL(root.right, head);

        root.right = head ; 

        if(head!=null){
            head.left = root;
        }
        head = root;
        // left subtree
        convertIntoSortedDLL(root.left, head);
    }

    // merge 2 sorted linked list
    public static BST_01.Node mergeLinkedList(BST_01.Node head1 ,BST_01.Node head2){

        BST_01.Node head = null;
        BST_01.Node tail = null;

        while(head1!=null && head2!=null){

            BST_01.Node curNode = (head1.data < head2.data) ? head1 : head2;

            if(curNode.data == head1.data){
                head1 = head1.right;
            }else{
                head2 = head2.right;
            }

            if(head==null){
                head = curNode;
                tail = curNode;
                break;
            }else{
                tail.right = curNode;
                curNode.left = tail;
                tail = curNode;
            }
            
        }
        if(head1!=null){
            tail.right = head1;
            head1.left = tail;
        }
        if(head2!=null){
            tail.right = head2;
            head2.left = tail;
        }

        return head;
    }

    // convert sorted linked list into BST
    public static int totalNodes(BST_01.Node head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.right;
        }
        return count;
    }
    public static BST_01.Node sortedLLtoBST(BST_01.Node head,int n){
        if(n<=0 || head==null){
            return null;
        }

        BST_01.Node left  = sortedLLtoBST(head, n/2);
        
        BST_01.Node root = head;
        root.left = left;

        head = head.right;

        root.right = sortedLLtoBST(head, n-(n/2)-1);

        return root; 
    }


    static BST_01.Node mergeBST(BST_01.Node root1, BST_01.Node root2) {
        // step-1 : convert BST into sorted doubly linked list       
        BST_01.Node head1 = null;
       convertIntoSortedDLL(root1,head1);
       root1.left = null;
       
       BST_01.Node head2 = null;
       convertIntoSortedDLL(root2,head2);
       root2.left = null;
    
       // step-2 : merge soretd linked list
       BST_01.Node head= mergeLinkedList(head1,head2);
       
       // step -3 : convert sorted linked list into BST
       return sortedLLtoBST(head , totalNodes(head));
    }
}
