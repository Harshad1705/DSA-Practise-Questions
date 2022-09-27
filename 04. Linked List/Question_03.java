import java.util.HashMap;
import java.util.Map;

// remove duplicate from sorted list
// remove duplicate from unsorted list


public class Question_03 {

    public static void remove_duplicate_from_sorted_list(Singly_Linked_List.Node head){

        // Time Complexity = O(n)
        // Space Complexity = O(1)

        if(head==null){
    	    return ;
    	}
    	Singly_Linked_List.Node curr = head;
    	
    	while(curr!=null){
    	    Singly_Linked_List.Node temp = curr.next;
    	    if(temp==null){
    	        curr=null;
    	        break;
    	    }
    	    while( temp!=null && temp.data==curr.data ){
    	        temp = temp.next;
    	    }
            
    	    curr.next = temp;
    	    curr = curr.next;
    	}

    }

    public static void remove_duplicate_from_unsorted_list(Singly_Linked_List.Node head){

        // Time Complexity = O(n)
        // Space Complexity = O(n)

        Map<Integer,Boolean> visited = new HashMap<>();

        Singly_Linked_List.Node prevNode = null;
        Singly_Linked_List.Node curNode = head;
        
  
          while(curNode != null){
              
              Boolean found = false;
  
              if(visited.containsKey(curNode.data)){
                  prevNode.next = curNode.next;
                  found = true;
              }
              else{
                  visited.put(curNode.data,true);
              } 
  
              if(found == false){
                prevNode = curNode;
              }
              curNode = curNode.next;
          }
          
 
    }

    public static void main(String[] args) {
        Singly_Linked_List list = new Singly_Linked_List();


        list.addFirst(40);
        list.addFirst(40);
        list.addFirst(20);
        list.addFirst(20);
        list.addFirst(10);

        list.print();

        Singly_Linked_List.Node head = list.head;

        remove_duplicate_from_sorted_list(head);

        list.print();

        System.out.println("--------------------------------------");

        Singly_Linked_List list_2 = new Singly_Linked_List();

        list_2.addFirst(25);
        list_2.addFirst(50);
        list_2.addFirst(25);
        list_2.addFirst(25);
        list_2.addFirst(10);
        list_2.addFirst(20);
        list_2.addFirst(10);

        list_2.print();

        Singly_Linked_List.Node head_2 = list_2.head;

        remove_duplicate_from_unsorted_list(head_2);

        list_2.print(); 

    }

}
