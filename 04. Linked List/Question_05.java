// palindrome

public class Question_05 {

    public static void print(Singly_Linked_List.Node head){
        Singly_Linked_List.Node cur = head;
        while(cur.next != null){
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();
    }

    

    public static Boolean is_palindorome(Singly_Linked_List.Node head){

        if(head==null || head.next==null){
            return true;
        }

        // finding middle node
        Singly_Linked_List.Node middle = find_middle(head);
        // reverse nodes after middle node
        middle.next = reverse_from_middle(middle.next);

        // comparing both halfes of node
        Singly_Linked_List.Node first_half = head;
        Singly_Linked_List.Node second_hald = middle.next;

        while(second_hald != null){
            if(first_half.data != second_hald.data){
                return false;
            }
            first_half = first_half.next;
            second_hald = second_hald.next;
        }

        

        return true;

    }

    
    private static Singly_Linked_List.Node reverse_from_middle(Singly_Linked_List.Node head) {
        
        Singly_Linked_List.Node prev = null;
        Singly_Linked_List.Node curr = head;
        Singly_Linked_List.Node next = null;

        while(curr!=null){
            next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        return prev;

    }



    private static Singly_Linked_List.Node find_middle(Singly_Linked_List.Node head) {

        Singly_Linked_List.Node fast = head;
        Singly_Linked_List.Node slow = head;

        while(fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }



    public static void main(String[] args) {
        
        Singly_Linked_List list = new Singly_Linked_List();


        list.addFirst(5);
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(10);
        list.addFirst(5);

        Singly_Linked_List.Node head = list.head;

        list.print();

        System.out.println(is_palindorome(head));

    }
}
