
import java.util.Vector;

// find first negative integer in every window of size K

public class Queue_08 {

    static Vector<Integer> vec = new Vector<>();

    public static Object[] reverse_vector(Vector<Integer> v){
        
        Object[] arr = vec.toArray();
        // System.out.println(arr[0]);
        int start = 0;
        int last = arr.length-1;

        while(start<=last){
            int temp =(int) arr[start];
            arr[start] = arr[last];
            arr[last] = temp;

            
            start++;
            last--;
        }
        return  arr;

    }

    static void printFirstNegativeInteger( int A[],int N,  int K) {

        if(N<K){
            return;
        }
        
        int[] arr = new int[K];
        int i = 1;
        while(i<=K){
            arr[i-1] = A[N-i];
            i++;
        }

        int neg = arr.length-1 ;
        while(neg>=0){
            if(arr[neg]<0){
                vec.add(arr[neg]);
                break;
            }
            neg--;

        }
        if(neg<0){
            vec.add(0);
        }
        printFirstNegativeInteger(A, N-1, K);
    }
     
    public static void main(String[] args) {
        int K = 2;
        int N = 5;
        int A[] = {-8, 2, 3, -6, 10};

        printFirstNegativeInteger(A,N,K);
        Object[] arr = reverse_vector(vec);
        for(Object i : arr){
            System.out.print(i + " ");
        }
    }
}
