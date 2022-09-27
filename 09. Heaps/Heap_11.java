import java.util.PriorityQueue;

// smallest range in K list

public class Heap_11 {


    static class Nodes{

        int data;
        int row;
        int col;

        Nodes(int data , int row, int col){
            this.data = data;
            this.row = row;
            this.col = col;
        }
    }

    public static int findSmallestRange(int[][] arr,int n,int k){


        // Time complexity = O(n(k^2))
        // Space complexity = O(k)

	    // create min and max variable
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // create heap for getting smallest value
        PriorityQueue<Nodes> pq = new PriorityQueue<>();


        for(int i=0;i<k;i++){

            int element =  arr[i][0];

            // track of smallest and largest elemeent
            min = Math.min(min,element);
            max = Math.max(max,element);

            Nodes temp = new Nodes(element, i, 0);

            // add node in heap
            pq.add(temp);

        }

        // copy variable that are returned
        int start = min;
        int end = max;


        while(!pq.isEmpty()){

            Nodes top = pq.poll();

            // min value
            min = top.data;

            // range or answer updation
            // if this condition occur means the difference is less now and update start and end
            if(end - start > max-min){
                start = min;
                end = max;
            }

            // next element exists then push
            if((top.col + 1) < n ){
                // track of maximum value
                max = Math.max(max,arr[top.row][top.col+1]);
                // push value in heap
                pq.add(new Nodes(arr[top.row][top.col+1], top.row, top.col+1));

            }else{
                // next element not exist
                break;
            }
        }

        

        return end-start+1;

	}

    public static void main(String[] args) {

        int[][] arr = {{1,10,10},{2,3,20},{5,6,12}};
        int n = 3;
        int k = 3;

        findSmallestRange(arr, n, k);
        
    }
    
}

//  C ++ code


// #include<queue>
// #include <climits>
// class node{
//     public : 
//        int data;
//         int row;
//         int col;

//         node(int data , int row, int col){
//             this->data = data;
//             this->row = row;
//             this->col = col;
//         }
// };

// class compare{
//     public:
//     bool operator()(node* a , node*b){
//         return a->data > b->data;
//     }
// };

// int kSorted(vector<vector<int>> &arr, int k, int n) {
    
//     int mini = INT_MAX;
//     int maxi = INT_MIN;
    
//     priority_queue<node* , vector<node*> , compare> pq ;
    
//     for(int i=0;i<k;i++){
        
//         int ele = arr[i][0];
        
//         mini  = min(mini,ele);
//         maxi = max(maxi,ele);
        
//         pq.push(new node(ele, i ,0));
//     }
    
//     int start = mini;
//     int end = maxi;
    
//     while(!pq.empty()){
        
//         node* topi = pq.top();
//         pq.pop();
        
//         mini = topi->data;
        
//         if(maxi - mini < end-start){
//             start = mini;
//             end = maxi;
//         }
        
//         int r  = topi-> row;
//         int c = topi->col;
        
//         if(c+1 < n){
//             maxi = max(maxi , arr[r][c+1]);
//             pq.push(new node(arr[r][c+1],r,c+1));
//         }else{
//             break;
//         }
//     }
    
//     return end-start+1;
    
// }