import java.util.Stack;

// largest rectangle in histogram

public class Stack_12 {

    public static int[] smallest_element_in_left(int[] arr){

        Stack<Integer> answer = new Stack<>();
        answer.push(-1);

        int[] new_arr = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            int num = arr[i];

            while((answer.peek()!=-1) && (arr[answer.peek()]>=num)){
                answer.pop();
            }
            new_arr[i] = answer.peek(); 
            answer.push(i);
        }
    
        return new_arr;

    }
    public static int[] smallest_element_in_right(int[] arr){

        Stack<Integer> answer = new Stack<>();
        answer.push(-1);

        int[] new_arr = new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){
            
            int num = arr[i];

            while((answer.peek()!=-1) && (arr[answer.peek()]>=num)){
                answer.pop();
            }
            new_arr[i] = answer.peek(); 
            answer.push(i);
        }
        
        return new_arr;

    }

    public static int largest_rectangle_in_histogram(int arr[]){

        // Time complexity = O(n)

        int[] left = smallest_element_in_left(arr);
        for(int i : left){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] right = smallest_element_in_right(arr);
        for(int i : right){
            System.out.print(i+" ");
        }
        System.out.println();

        int area_max = Integer.MIN_VALUE;

        for(int i=0 ; i<arr.length ;i++){

            int l = arr[i];

            if(right[i]==-1){
                right[i] = arr.length;
            }

            int b = right[i] - left[i] - 1;


            int newArea = l*b;
            area_max = area_max > newArea ? area_max : newArea;

            
        }
        return area_max;  
    }

    public static void brute_force(int[] arr){

        // Time complexity = O(n^2)

        int[] arr_2 = new int[arr.length];

        // left corner case
        int num = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=arr[0]){
                num++;
            }else{
                break;
            }
        }
        arr_2[0] = num*arr[0];

        // middle case
        for(int i=1 ; i<arr.length-1 ; i++){
            int n = 1;
            for(int j = i-1;j>=0 ; j--){
                if(arr[j]>=arr[i]){
                    n++;
                }else{
                    break;
                }
            }        
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]>=arr[i]){
                    n++;
                }else{
                    break;
                }
            }
            arr_2[i] = arr_2[i] + n * arr[i] ;
        }

        // right corner case
        int right = 1;
        for(int i=arr.length-2 ; i>=0;i--){
            if(arr[i]>= arr[arr.length-1]){
                right++;
            }else{
                break;
            }
        }
        arr_2[arr.length-1] = right*arr[arr.length-1];

        for(int i  : arr_2){
            System.out.print(i + " ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        
        int[] arr = {2,1,5,6,2,3}; 

        brute_force(arr);

        System.out.println();

        int answer = largest_rectangle_in_histogram(arr);
        System.out.println(answer);
    }
    
}
