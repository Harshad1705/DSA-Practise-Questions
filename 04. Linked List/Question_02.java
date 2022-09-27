// Detect loop
// Beginning of loop
// Remove loop

import java.util.HashMap;
import java.util.Map;

public class Question_02 {

    // create a loop 
    public static void make_loop (Singly_Linked_List.Node head){

        Singly_Linked_List.Node curNode = head;

        while(curNode.next != null) {
            curNode = curNode.next;
        }

        curNode.next = head.next.next;

    }

    // remove loop from list
    public static void remove_loop(Singly_Linked_List.Node head){

        if(head == null){
            return ;
        }
        if(head.next == head){
            head.next = null;
            return;
        }

        Singly_Linked_List.Node start_loop = floyd_cycle_detection(head);

        Singly_Linked_List.Node curNode = start_loop;

        while(curNode.next != start_loop){
            curNode = curNode.next;
        }

        curNode.next = null;

    }

    // return node from where loop start
    public static Singly_Linked_List.Node find_starting_of_loop(Singly_Linked_List.Node head ){
        
        Singly_Linked_List.Node fast = floyd_cycle_detection(head);
        Singly_Linked_List.Node slow = head ;

        
        
        while(slow != fast ){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }

    // flood cycle algorithm to detect loop
    public static Singly_Linked_List.Node floyd_cycle_detection(Singly_Linked_List.Node head){

        // Time complexity = O(n)
        // Space complexity = O(1)

        if(head == null || head.next == null){
            return null;
        }

        Singly_Linked_List.Node turtle = head;
        Singly_Linked_List.Node rabbit = head;

        while(rabbit.next != null && rabbit.next.next != null){
            
            turtle = turtle.next;
            rabbit = rabbit.next.next;

            if(rabbit == turtle){
                // System.out.println("Both intersect at : " + turtle.data);
                // System.out.println("Starting of loop at " + find_starting_of_loop(head,turtle, rabbit).data);
                return rabbit;
            }
            
        }
        return null;

    }

    //  map used to detect loop in list
    public static boolean detectLoop(Singly_Linked_List.Node head){

        // Time complexity = O(n)
        // Space complexity = O(n)

        if(head == null){
            return false;
        }

        Map<Singly_Linked_List.Node,Boolean> visited =  new HashMap<Singly_Linked_List.Node,Boolean>();

        Singly_Linked_List.Node curNode = head;

        // visited.put(head,true);

        while(curNode != null){

            if( visited.containsKey(curNode) == true  ){
                System.out.println("Loop at element : " + curNode.data);
                return true;
            }

            visited.put(curNode, true);

            curNode = curNode.next;
        }

        return false;
    }
    public static void main(String[] args) {
        
        Singly_Linked_List list = new Singly_Linked_List();


        list.addFirst(40);
        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10);
     
        list.print();


        Singly_Linked_List.Node head = list.head;

        System.out.println("----------------------------------------");

        Singly_Linked_List.Node answer = floyd_cycle_detection(head);
        if(answer==null)
            System.out.println("No loop present");
        else
            System.out.println("Loop present");

        System.out.println("----------------------------------------");

        boolean answer_2 = detectLoop(head);
        System.out.println(answer_2);

        System.out.println("----------------------------------------");

        make_loop(head);

        System.out.println("----------------------------------------");

        // list.print();

        boolean answer_3 = detectLoop(head);
        System.out.println(answer_3);

        System.out.println("----------------------------------------");

        Singly_Linked_List.Node answer_4 = floyd_cycle_detection(head);

        if(answer_4==null)
            System.out.println("No loop present");
        else
            System.out.println("Loop present");

        System.out.println("----------------------------------------");

        System.out.println("Loop start from element : " + find_starting_of_loop(head).data);

        remove_loop(head);

        list.print();

    }   
}
