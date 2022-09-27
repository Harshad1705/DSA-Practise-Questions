import java.util.PriorityQueue;

// merge K sorted lists

// approach -1 
// store all element in vector by traversing
// sort the vector
// join all the list
// replace value in list using vector values

public class Heap_10 {

    static class LinkedListNode {
        int data;
        LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
        }
    }

    public static LinkedListNode mergeKLists(LinkedListNode[] listArray){

        // Time complexity = O(n*k logK )
        // Space complexity = O(K)

        PriorityQueue<LinkedListNode> pq = new PriorityQueue<>();

        int k = listArray.length;

        if(k==0){
            return null;
        }

        // step -1 : put first element in heap

        for(int i=0;i<k;i++){

            if(listArray[i] != null){
                pq.add(listArray[i]);
            }
        }

        LinkedListNode head = null;
        LinkedListNode tail = null;

        // step - 2 : element nikalana hai aur phir add krna hai

        while(!pq.isEmpty()){

            LinkedListNode top = pq.poll();

            if(top.next!=null){
                pq.add(top.next);
            }
        
            // list is empty
            if(head==null){
                head = top;
                tail = top;
            // insert at end    
            }else{
                tail.next = top;
                tail = top;
            }

        }

        return head;

    }
}
