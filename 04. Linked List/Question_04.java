

// sort 0,1,2
// merge two sorted linked list

class Question_04 {

    class Node{
        int data;
        Node next ;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void print(Singly_Linked_List.Node head){
        Singly_Linked_List.Node cur = head;
        while(cur.next != null){
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void sort_0_1_2_method_1(Singly_Linked_List.Node head){

        // Time Complexity = O(n)
        // Space Complexity = O(1)

        if(head == null){
            return;
        }

        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;

        Singly_Linked_List.Node curNode = head;

        while(curNode != null){

            if(curNode.data == 0)
                count_0 = count_0 + 1;
            if(curNode.data == 1)
                count_1 = count_1 + 1;
            if(curNode.data == 2)
                count_2 = count_2 + 1;

            curNode = curNode.next;
        }

        curNode = head;

        while(count_0>0) {

            curNode.data = 0;

            curNode = curNode.next;

            count_0 = count_0 -1 ;
        }
        while(count_1>0) {

            curNode.data = 1;

            curNode = curNode.next;

            count_1 = count_1 -1 ;
        }
        while(count_2>0) {

            curNode.data = 2;

            curNode = curNode.next;

            count_2 = count_2 -1 ;  
        }

    } 

    public static void insertAtTail(Singly_Linked_List.Node tail ,int data){
        Singly_Linked_List ll = new Singly_Linked_List();
        Singly_Linked_List.Node newNode = ll.new Node(data);

        tail.next = newNode;
        tail = tail.next;
    }

    public static void sort_0_1_2_method_2(Singly_Linked_List.Node head){

        // Time Complexity = O(n)
        // Space Complexity = O(1) 

        Singly_Linked_List zero = new Singly_Linked_List();
        Singly_Linked_List.Node zeroTail = zero.head;

        Singly_Linked_List one = new Singly_Linked_List();
        Singly_Linked_List.Node oneTail = one.head;
        
        Singly_Linked_List two = new Singly_Linked_List();
        Singly_Linked_List.Node twoTail = two.head;

        Singly_Linked_List.Node curNode = head;


        // create seperate lists 0s,1s,2s
        while(curNode != null){

            int value = curNode.data;

            if(value == 0){
                insertAtTail(zeroTail , 0);
            }
            if(value == 1){
                insertAtTail(oneTail , 1);
            }
            if(value == 2){
                insertAtTail(twoTail , 2);
            }
            curNode = curNode.next;
        }

        // merge 3 lists
        if(one.head != null){
            zeroTail.next = one.head;
        }else{
            zeroTail.next = two.head;
        }
        oneTail.next = two.head;
        twoTail.next = null;

        // setup head
        head = zero.head;
        
    }

    public static Singly_Linked_List.Node solve(Singly_Linked_List.Node first ,Singly_Linked_List.Node second){

        //if only one element is present
        if(first.next == null ){
            first.next = second;
            return first;
        }

        Singly_Linked_List.Node curr_1 = first;
        Singly_Linked_List.Node next_1 = first.next;

        Singly_Linked_List.Node curr_2 = second;

        while(next_1 != null && curr_2 != null){

            if((curr_2.data >= curr_1.data) && (curr_2.data <= next_1.data)){

                // add node in between the list
                Singly_Linked_List.Node next_2 = curr_2 .next;
                curr_1.next = curr_2;
                curr_2.next = next_1;

                // update pointers
                curr_1 = curr_2;
                curr_2 = next_2;

            }else{
                // curr1 and next1 ko aage badhana padega  
                curr_1 = curr_1.next;
                next_1 = next_1.next;

                if(next_1 == null){
                    curr_1.next = curr_2;
                    return first;
                }
            }
        }
        return first;

    }

    public static Singly_Linked_List.Node merge_sorted_list(Singly_Linked_List.Node head_1 ,Singly_Linked_List.Node head_2){

        if(head_1 == null && head_2 == null){
            return null;
        }
        if(head_1 == null){
            return head_2;
        }
        if(head_2 == null){
            return head_1;
        }

        if(head_1.data <= head_2.data){
           return  solve(head_1,head_2);
        }else{
           return solve(head_2,head_1);
        }


    }
    public static void main(String[] args) {
        
        Singly_Linked_List list = new Singly_Linked_List();

        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(0);
        list.addFirst(1);

        list.print();

        Singly_Linked_List.Node head = list.head;

        sort_0_1_2_method_1(head);

        list.print();

        System.out.println("---------------------------");

        Singly_Linked_List list_2 = new Singly_Linked_List();

        list_2.addFirst(2);
        list_2.addFirst(1);
        list_2.addFirst(0);
        list_2.addFirst(1);

        list_2.print();
        
        Singly_Linked_List.Node head_2 = list_2.head ;
        
        // sort_0_1_2_method_2(head_2);

        list_2.print();

        System.out.println("--------------------------------------");

        sort_0_1_2_method_1(head_2);

        list.print();
        list_2.print();

        Singly_Linked_List.Node merge_node = merge_sorted_list(head, head_2) ;
        print(merge_node);
       
    }

    
}
