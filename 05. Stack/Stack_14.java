import java.util.Stack;

// max rectangle in binary matrix with all 0's and 1's

public class Stack_14 {

    public static int largest_area(int[] arr){

        int[] left = preSmallerElement(arr);
        int[] right = nextSmallerElement(arr);

        int area_max = Integer.MIN_VALUE;
        
        for(int i=0 ;i<arr.length;i++){
            if(right[i]==-1){
                right[i] = arr.length;
            }
            int height = arr[i];
            int length = right[i] - left[i] - 1;
            int area = height*length;
            area_max = area_max > area ? area_max : area;
        }
        return area_max;
    }
    private static int[] nextSmallerElement(int[] arr) {
        
        Stack<Integer> left = new Stack<>();
        left.push(-1);

        int[] ans = new int[arr.length];   

        for(int i=arr.length-1;i>=0;i--){
            int num = arr[i];
            while(left.peek()!=-1 && arr[left.peek()]>=num){
                left.pop();
            }
            ans[i] = left.peek();
            left.push(i);
        }

        return ans;

    }
    private static int[] preSmallerElement(int[] arr) {
        
        Stack<Integer> left = new Stack<>();
        left.push(-1);

        int[] ans = new int[arr.length];   

        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            while(left.peek()!=-1 && arr[left.peek()]>=num){
                left.pop();
            }
            ans[i] = left.peek();
            left.push(i);
        }

        return ans;

    }

    public static int max_area(int[][] arr,int n,int m){

        // Time complexity = O(n*m)
        // Space complexity = O(m)


        // compute area for first row
        int answer = largest_area(arr[0]);

        int[] a = new int[m];

        // for remaining rows
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                a[j] = arr[i][j] + arr[i-1][j];
                if(arr[i][j]==0){
                    a[j] = 0;
                }
                int area = largest_area(a);
                answer = answer>area ? answer : area;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] arr = {
            {0,1,1,0},
            {1,1,1,1},
            {1,1,1,1},
            {1,1,0,0}
        };

        System.out.println(max_area(arr,4,4));
    }   
}
