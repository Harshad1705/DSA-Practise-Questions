import java.util.Vector;

// add two numbers present in linked list

public class Question_06 {


    public static void print(Singly_Linked_List.Node head){
        Singly_Linked_List.Node cur = head;
        while(cur != null){
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();
    }


    public static void main(String[] args) {
        
        Singly_Linked_List list_1 = new Singly_Linked_List();   // 255
        list_1.addFirst(5);
        list_1.addFirst(5);
        list_1.addFirst(2);

        Singly_Linked_List list_2 = new Singly_Linked_List();  // 35
        list_2.addFirst(5);
        list_2.addFirst(3);

        Singly_Linked_List.Node ans = add_numbers(list_1,list_2);

        print(ans);


    }


    private static Singly_Linked_List.Node add_numbers(Singly_Linked_List list_1, Singly_Linked_List list_2) {
        
        // Time Complexity = O(m+n)
        // Space Complexity = O(max(m+n))

        // get head of both the list
        Singly_Linked_List.Node head_1 = list_1.head;
        Singly_Linked_List.Node head_2 = list_2.head;

        print(head_1);
        print(head_2);

        // reverse both the list
        Singly_Linked_List.Node reverse_head_1 = reverse(head_1);
        Singly_Linked_List.Node reverse_head_2 = reverse(head_2);

        print(reverse_head_1);
        print(reverse_head_2);

        // create pointer of both node to traverse
        Singly_Linked_List.Node curr_1 = reverse_head_1;
        Singly_Linked_List.Node curr_2 = reverse_head_2;

        int carry = 0;
        
        // create array in which sum stored
        Vector<Integer> answer = new Vector<>();

        // logic
        while(curr_1!=null || curr_2!=null || carry!=0){

            int val1 = 0;
            int val2 = 0;

            if(curr_1!=null){
                val1 = curr_1.data;
            }
            if(curr_2!=null){
                val2 = curr_2.data;
            }

            int ans = val1 + val2 + carry;
            int digit = ans%10;

            answer.add(digit);

            carry = ans/10;

            if(curr_1!=null)
                curr_1 = curr_1.next;
            if(curr_2!=null)
                curr_2 = curr_2.next;

        }

        Singly_Linked_List ll = new Singly_Linked_List();

        for(int x : answer){
            ll.addLast(x);
        }

        Singly_Linked_List.Node a = reverse(ll.head);   

        return a;
        
    }




    private static Singly_Linked_List.Node reverse(Singly_Linked_List.Node head) {
        
        if(head==null || head.next== null){
            return null;
        }
        Singly_Linked_List.Node prev = head;
        Singly_Linked_List.Node curr = head.next;
        Singly_Linked_List.Node next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = null;
        head = prev;

        return head;

    }

    
}
