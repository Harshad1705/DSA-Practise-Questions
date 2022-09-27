import java.util.ArrayList;
import java.util.Collections;

// Binary Search

public class Rec_07 {

    public static int binary_search(ArrayList<Integer> arr, int key , int top , int bottom){

        if(top > bottom){
            return -1;
        }

        int index = (top + bottom) /  2 ;

        if(arr.get(index)==key){

            return index;

        }else if(arr.get(index) < key){

            return binary_search(arr, key, index + 1, bottom);

        }else{

            return binary_search(arr, key, top, index -1 );

        }
    }

    public static void main(String[] args) {
        
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(5);
        arr.add(4);
        arr.add(7);
        arr.add(6);

        Collections.sort(arr);

        int top = 0;
        int bottom = arr.size()-1;
        int key = 5;

        System.out.println(binary_search(arr, key,top , bottom));
        

    }
    
}
