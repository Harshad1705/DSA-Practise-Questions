
import java.util.Stack;

// next smaller element

public class Stack_11 {

    public static void next_smaller_element(int[] arr){

        // Time complexity = O(n)
        // Space complexity = O(n)
        
        Stack<Integer> s = new Stack<>();
        s.push(-1);

        int[] arr_2 = new int[arr.length];

        for(int i=arr.length-1; i>=0;i--){

            int num = arr[i];

            while(s.peek() >= num){
                s.pop();
            }

            arr_2[i] = s.peek();
            s.push(num);
             
        }

        for(int i : arr_2){
            System.out.println(i);
        }

    }
    

    public static void main(String[] args) {
        
        int[] arr =  {3 ,3 ,1 ,1};

        next_smaller_element(arr);

    }
}
