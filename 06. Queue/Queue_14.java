import java.util.ArrayDeque;
import java.util.Deque;

// sum of maximum and minimum elemnet of all subarray of size K

public class Queue_14 {

    private static int solve(int[] arr , int k) {

        Deque<Integer> maxi =  new ArrayDeque<>();
        Deque<Integer> mini =  new ArrayDeque<>();

        // addition of firt k size window
        for(int i=0;i<k;i++){
            while(!maxi.isEmpty() && arr[maxi.peekLast()] >= arr[i])
                maxi.remove();
            while(!mini.isEmpty() && arr[mini.peekLast()] <= arr[i])
                mini.remove();

            maxi.addLast(i);
            mini.addLast(i);
        }

        int ans = 0;
        for(int i=k ; i<arr.length;i++){

            ans += arr[maxi.peekFirst()] + arr[mini.peekFirst()];

            // next window

            // removal
            while(!maxi.isEmpty() && i-maxi.peekFirst() >= k){
                maxi.removeFirst();
            }
            while(!mini.isEmpty() && i-mini.peekFirst() >= k){
                mini.removeFirst();
            }

            // addition
            while(!maxi.isEmpty() && arr[maxi.peekLast()] >= arr[i])
                maxi.removeLast();
            while(!mini.isEmpty() && arr[mini.peekLast()] <= arr[i])
                mini.removeLast();

            maxi.add(i);
            mini.add(i);
        }

        // make sure to consider last wali window
        ans += arr[maxi.peekFirst()] + arr[mini.peekFirst()];

        // return answer
        return ans;
    }
    public static void main(String[] args) {

        int arr[] = {2, 5, -1, 7, -3, -1, -2} ;
        int k = 4;
        int ans = solve(arr,k);

        System.out.println(ans );
    }

    
}
