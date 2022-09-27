import java.util.Stack;
import java.util.Vector;


// celebrity problem

// everyone knows celebrity
// celebrity knows no one

// brute force
// celebrity row -> all 0
// celebrity col -> all 1 except diagonal element

public class Stack_13 {

    public static void brute_force(int[][] arr , int n){

        // Time Complexity = O(n^2)

        Vector<Integer> ans = new Vector<>();
        
        // cheking : celebrity knows no one condition
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    count++;
                }
            }
            if(count==n){
                ans.add(i);
            }
        }

        for(int i : ans){
            int count = 0;
            for(int j = 0 ;j<n;j++){
                if(i==j){
                    continue;
                }
                if(arr[j][i]==1){
                    count++;
                }
            }
            if(count==(n-1)){
                System.out.println("Celebrity is : " + i);
            }
        }

        
    }

    public static void celebrity_problem(int[][] arr,int n){

        // Time Complexity = O(n)
        // Space Complexity = O(n)

        Stack<Integer> s = new Stack<>();

        // push all element in stack
        for(int i=0;i<n;i++){
            s.push(i);
        }

        // get two element and check them
        while(s.size()>1){
            int A = s.pop();
            int B = s.pop();

            if(arr[A][B]==1){
                s.push(B);
            }else{
                s.push(A);
            }
        }
        
        // single element in stack
        // verify it

        boolean rowCheck = false;
        int count = 0;
        for(int i=0;i<n;i++){
            if(arr[s.peek()][i]==0){
                count++;
            }
        }
        if(count==n){
            rowCheck = true;
        }

        boolean colCheck = false;
        int count_2 = 0;
        for(int i=0;i<n;i++){
            if(arr[i][s.peek()]==1){
                count_2++;
            }
        }
        if(count_2==(n-1)){
            colCheck= true;
        }

        if(colCheck==true && rowCheck==true){
            System.out.println("Celebrity : " + s.peek());
        }


    }
    
    public static void main(String[] args) {

        int[][] arr = {
            {0,1,0},
            {0,0,0},
            {0,1,0}
        };

        brute_force(arr,3);

        celebrity_problem(arr, 3);

    }
}

// Algorithm
// put all element in stack
// jab tak stack.size()!=1
// A = s.top() s.pop()
// B = s.top() s.pop()
// if(A knows B) -> A celebrity nhi ho skta , B ko wapas dal do stack mai
// if(B knows A) -> B celebrity nhi ho skta , A ko wapas dal do stack mai
// jab ek single element bach jaye woh ek potential celebrity candidat ho skta hai

// verify kar lo