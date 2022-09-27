
// isSorted 
// sum of array

public class Rec_05 {
    
    public static Boolean isSorted(int[] arr , int first , int second){

        if(first==arr.length-1){
            return true;
        }

        boolean ans = arr[first] <= arr[second];

        if(ans==false){
            return false;
        }

        boolean rec = isSorted(arr, second, second + 1);

        return ans && rec ;

    }

    public static int sum(int arr[] , int index){

        if(index == arr.length){
            return 0;
        }

        return arr[index] + sum(arr, index + 1);
    }

    public static void main(String[] args) {
        
        int[] arr = {2,4,6,6,11,13};

        System.out.println(isSorted(arr, 0, 1));

        System.out.println(sum(arr, 0));


    }
}
