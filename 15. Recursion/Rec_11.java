
// Bubble Sort

public class Rec_11 {

    public static void Bubble_Sort(int[] arr , int n){

        // base case
        if(n==0 || n==1){
            return;
        }

        // 1 case solve - largest element at last pahuch gaya
        for(int i=0 ; i < n-1 ; i++ ){
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        // recursive call
        Bubble_Sort(arr, n-1);

    }


    public static void main(String[] args) {
        
        int[] arr = {5,2,4,1,6,3};
        int n = 6;

        Bubble_Sort(arr, n);

        for(int i : arr){
            System.out.print(i + " ");
        }
        
    }
    
}
