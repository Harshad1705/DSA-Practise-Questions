import java.util.LinkedHashMap;
import java.util.Map;


// Maximim frequency number

public class HashMap_02 {

    public static int maxFrequencyNumber(int n, int[] arr) {

        // Time complexity = O(N)
        // Space complexity = O(N)

        // LinkedHashMap is used to maintain order
        Map<Integer,Integer> map = new LinkedHashMap<>();

        int max_freq = 0;
        int max_ans = 0;


        for(int i=0 ; i<n ; i++){

            int num = arr[i];

            if(map.containsKey(num)){
                int value = map.get(num);
                map.put(num, value + 1);
            }else{
                map.put(num, 1);
            }
            max_freq = Math.max(max_freq, map.get(num));
        }


        for(Map.Entry<Integer,Integer> m : map.entrySet()){

            if(m.getValue()==max_freq){
                max_ans = m.getKey();
                break;
            }
        }
        
        return max_ans;

	}

    public static void main(String[] args) {

        int n = 3 ; 
        int arr[] = {4,5,-1 };

        int ans = maxFrequencyNumber(n, arr);

        System.out.println("Ans : " + ans);

        
    }
}
