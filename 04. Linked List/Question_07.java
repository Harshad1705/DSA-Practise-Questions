import java.util.HashMap;
import java.util.Map;

// clone a linked list 

public class Question_07 {
    
    // create a node
    class Node{
        int data;
        Node next = null;
        Node random = null;

        Node(int data){
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }
    // create a head pointer
    Node head = null;

    // function to print node values
    public static void print(Node head){
        Node curNode = head;
        while(curNode!=null){
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }
        System.out.print("null");
        System.out.println();
    }
    
    public void print(){
        Node curNode = head;
        while(curNode!=null){
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }
        System.out.print("null");
        System.out.println();
    }

    // function to add node in a list
    public void add( int data){
        Node newNode = new  Node(data);

        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next=newNode;
        
    }

    // function to initiate a random pointer
    public void randon_pointer(){

        System.out.println(head.data);
        System.out.println(head.next.data);
        System.out.println(head.next.next.data);
        System.out.println(head.next.next.next.data);
        
        head.random = head.next.next;            // 1 = 3
        head.next.random = head.next.next.next;  // 2 = 4
        head.next.next.random = head.next;       // 3 = 2
        head.next.next.next.random = head;       // 4 = 1
 
    }

    // function to check our random pointer
    public static void print_random(Node head){
        Node cur = head;
        while(cur != null){
            System.out.println(cur.random.data);
            cur = cur.next;
        }
    }
    public static void main(String[] args) {
        
        Question_07 ll = new Question_07();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);

        ll.randon_pointer();
        System.out.println("________________");


        Node head = ll.head;
        Node randon_node = clone_method_01(head);
        print_random(randon_node);
        System.out.println("--------------------");

        Node random_head_2 = clone_method_02(head);
        print_random(random_head_2);
        System.out.println("****************************");

        Node random_head_3=clone_method_03(head);
        print_random(random_head_3);

    }

    public static Node clone_method_01(Node head){

        // Time complexity = O(n^2)
        // Space complexity = O(n)

        Question_07 clone = new Question_07();

        Node currNode =  head;

        // add same node of previous data in clone list
        while(currNode != null){
            clone.add(currNode.data);
            currNode = currNode.next;
        }
    
        // logic for random pointer
        currNode = head;
        Node currNode_random = clone.head;

        while(currNode != null){
            Node random_node = clone.head;
            while(currNode.random.data != random_node.data && random_node!=null){
                random_node = random_node.next;
            }
            currNode_random.random = random_node;

            currNode_random = currNode_random.next;
            currNode = currNode.next;
        }
        return clone.head;
    }

    public static Node clone_method_02(Node head){

        // Time complexity = O(n)
        // Space complexity = O(n)
        
        Question_07 clone = new Question_07();
        
        // create pointes on both the list
        Node currNode = head;
        Node curNode_clone = clone.head;
        
        // copy the data of previous list into new liat
        while(currNode != null){
            clone.add(currNode.data);
            currNode = currNode.next;
        }

        // create map to store  oldList to newList
        Map<Node,Node> mapping = new HashMap<>();

        currNode = head;
        curNode_clone = clone.head;

        // logic to put values into map
        while(curNode_clone!=null && currNode!=null){
            mapping.put(currNode, curNode_clone);
            currNode = currNode.next;
            curNode_clone = curNode_clone.next;
        }

        currNode = head;
        curNode_clone = clone.head;

        // logic to fill random values of newList
        while (currNode!=null) {
            curNode_clone.random = mapping.get(currNode.random);
            curNode_clone = curNode_clone.next;
            currNode = currNode.next;
            
        }

        return clone.head;

    }

    public static Node clone_method_03(Node head){

        // Time complexity : O(n)
        // Space complexity : O(1)

        // create a clone list
        // clone node add in between original node
        // random pointer update of clone list    temp.next.random = temp.random.next;
        // revert changes done in step-2
        // return ans

        Question_07 clone = new Question_07();

        Node original_head = head;
        Node clone_head = clone.head;

        // create a clone list
        while(original_head!=null){
            clone.add(original_head.data);
            original_head = original_head.next;   
        }


        // add clone node in between original node
        original_head = head;
        clone_head = clone.head;

        while(original_head!=null && clone_head!=null){
            Node next = original_head.next;
            original_head.next = clone_head;
            original_head = next;

            next = clone_head.next;
            clone_head.next = original_head;
            clone_head = next;
        }


        // copy random pointer value of original list into clone list
        Node temp = head;

        while(temp!=null ){
            if(temp.next!=null ){
                temp.next.random = temp.random!=null ? temp.random.next : temp.random;
            }

            temp = temp.next.next;
        }

        

        // revert step-2
        original_head = head;
        clone_head = clone.head;

        while(original_head!=null && clone_head!=null){
            original_head.next = clone_head.next;
            original_head = original_head.next;

            if(original_head!=null){
            clone_head.next = original_head.next;
            }
            clone_head = clone_head.next;
         
        }

        return clone.head;
    }
}
