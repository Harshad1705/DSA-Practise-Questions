import java.util.Vector;

// merge 2 Binary max heap

public class Heap_05 {

    public static void heapify(Vector<Integer> arr , int n , int i){

        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if((left < n) && (arr.get(largest) < arr.get(left))){
            largest = left;
        }
        if((right < n) && (arr.get(largest) < arr.get(right))){
            largest = right;
        }

        if(largest != i){

            int temp = arr.elementAt(i);
            arr.set(i, arr.elementAt(largest));
            arr.set(largest, temp);

            heapify(arr, n, largest);
        }
        
    }
    
    public static Vector<Integer> mergeHeaps(Vector<Integer> a, Vector<Integer> b) {

        // Time complexity : O(n+m)
        // Space complexity : O(n+m)

        // merge both the arrays
        Vector<Integer> ans = new Vector<>();


        for(Integer i : a ){
            ans.add(i);
        }
        for(Integer i : b ){
            ans.add(i);
        }

    
       

        // build heap using merged arrays
        int size = ans.size();

        for(int i = (size/2) - 1 ; i>=0 ; i--){
            heapify(ans, size , i);
        }

        return ans;
    }

    public static void main(String[] args) {

        Vector<Integer> a =  new Vector<>();
        a.add(10);
        a.add(5);
        a.add(6);
        a.add(2);
        Vector<Integer> b = new Vector<>();
        b.add(12);
        b.add(7);
        b.add(9);

        Vector<Integer> ans = mergeHeaps(a, b);

        System.out.println(ans);     //  12 10 9 2 5 7 6

    }
}
