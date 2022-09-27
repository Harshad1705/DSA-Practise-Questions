// Merge sort in linked list

// flatten the list

public class Question_08 {

    public static void print(Singly_Linked_List.Node head){
        Singly_Linked_List.Node curNode = head;
        while(curNode!=null){
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static Singly_Linked_List.Node mergeSort(Singly_Linked_List.Node head){

        // Time complexity = O(NlogN)
        // Space complexity = O(logN)

        //Steps
        // find mid
        // breake into two halves
        // recursive sort the two halves
        // merge both the halves


        // base case
        if(head==null || head.next==null){
            return head;
        }

        // break list into 2 lists
        Singly_Linked_List.Node mid = findMid(head);

        Singly_Linked_List.Node first = head; 
        Singly_Linked_List.Node second = mid.next;

        mid.next = null;
        
        // recursion calls
        first = mergeSort(first);
        second = mergeSort(second);

        // merge both the list
        Singly_Linked_List.Node result = merge(first,second);

        return result;
    }
    private static Singly_Linked_List.Node merge(Singly_Linked_List.Node first, Singly_Linked_List.Node second) {

        if(first==null){
            return second;
        }
        if(second==null){
            return first; 
        }

        Singly_Linked_List ll = new Singly_Linked_List();
        Singly_Linked_List.Node head = ll.new Node(-1);
        Singly_Linked_List.Node tail = head;

        while(first!=null && second!=null){
            if(first.data < second.data){
                tail.next = first;
                tail = first;
                first = first.next;
            }else{
                tail.next = second;
                tail = second;
                second = second.next;
            }
        }
        while(first!=null){
            tail.next = first;
            tail = first;
            first = first.next;
        }
        while(second!=null){
            tail.next = second;
            tail = second;
            second = second.next;
        }

        return head.next;
    }
    private static Singly_Linked_List.Node findMid(Singly_Linked_List.Node head) {

        if(head == null || head.next == null){
            return head;
        }
        Singly_Linked_List.Node fast = head;
        Singly_Linked_List.Node slow = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // public static Singly_Linked_List.Node flatten(Singly_Linked_List.Node head){

    //     Singly_Linked_List.Node down = head.down;
    //     Singly_Linked_List.Node right = head.next;

    //     head.next = null;

    //     down = mergeSort(down);

    //     right = flatten(right);

    //     down = merge(head, down);

    //     Singly_Linked_List.Node result = merge(down,right);

    //     return result;


    // }
    public static void main(String[] args) {

        Singly_Linked_List list = new Singly_Linked_List();

            list.addFirst(60);
            list.addFirst(80);
            list.addFirst(40);
            list.addFirst(90);
            list.addFirst(30);
            list.addFirst(10);

            list.print();

            Singly_Linked_List.Node result = mergeSort(list.head);

            print(result);

    }
}
