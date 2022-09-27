

// Linear Search


public class Rec_06 {


    public static int linear_search(int[] arr ,  int element , int index){

        if(index==arr.length){
            return -1;
        }

        if(arr[index]==element){
            return index;
        }else{
            return linear_search(arr, element, index+1);
        }
    }

    public static void main(String[] args) {
        
        int[] arr = {5,2,8,9,6,3,7,9,5,6,9};
        int element = 8;

        System.out.println(linear_search(arr, element, 0));

    }
    
}
