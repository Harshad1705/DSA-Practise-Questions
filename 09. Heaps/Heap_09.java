import java.util.ArrayList;
import java.util.PriorityQueue;

// Merge K Sorted Arrays

public class Heap_09 {


    // approach - 1
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> arr, int k){

        // Time complexity - O(n^2)
        // Space complexity - O(n*k)
		
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<arr.size();i++){
            for(int j=0 ; j<arr.get(i).size();j++){
                pq.add(arr.get(i).get(j));
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!pq.isEmpty()){
            ans.add(pq.peek());
            pq.poll();
        }
        
        return ans;
	}

    // approach - 2
    static class Node{
        int data;
        int row;
        int col;

        Node(int data , int row ,int col){
            this.data = data;
            this.row = row;
            this.col = col;
        }
    }

    public static ArrayList<Integer> mergeKSortedArrays_2(ArrayList<ArrayList<Integer>> arr, int k){

        // Time complexity = O(k*n)
        // Space complexity = O(n*k)

        PriorityQueue<Node> pq = new PriorityQueue<>();

        ArrayList<Integer> ans = new ArrayList<>();

        // place first element of all the arrays in heap
        for(int i=0;i<k;i++){
            Node temp = new Node(arr.get(i).get(0), 1, 0);
            pq.add(temp);
        }

        // upto heap become empty , pop the element and place next element in heap
        // jab tak heap khali na hoo jaye , pehle top elemnet nikalo , phir uska next element heap mai dalo
        while(!pq.isEmpty()){

            Node top = pq.poll();
            
            ans.add(top.data);

            int row = top.row;
            int col =  top.col;

            if(col+1 < arr.get(row).size()){
                Node newNode = new Node(arr.get(row).get(col+1), row, col+1);
                pq.add(newNode);
            }

        }

        return ans;

    }
    
}
