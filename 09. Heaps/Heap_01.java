
public class Heap_01{
    
    static class Heap{
        int[] arr = new int[100];
        int size;

        Heap(){
            arr[0] = -1;
            size = 0;
        }


        public void insert(int val){

            // Time complexity = O(logN)

            // Algorithm -
            // insert element at last
            // check that element to its parent
            // if it larger than parent , swap 
            // else return

            size = size + 1;
            arr[size] = val;
            
            int index = size;
            
            while(index > 1){
                int parent = index/2;

                if(arr[parent] < arr[index]){

                    int temp = arr[parent];
                    arr[parent ] = arr[index];
                    arr[index] = temp;

                    index = parent;

                }else{
                    return;
                }
            }
        }

        public void delete(){

            // Time complexity = O(logN)

            // Algorithm - 
            // swap root with last element , arr[1] = arr[size]
            // remove last node , size--
            // propogare root node to its correct position

            if(size == 0){
                System.out.println("nothing to delete");
                return;
            }

            arr[1] = arr[size];
            size = size - 1;

            int i = 1;

            while(i<size){
                int left = 2*i;
                int right = 2*i + 1;

                if((left <= size) && (arr[i] < arr[left])){
                    
                    int temp = arr[i];
                    arr[i] = arr[left];
                    arr[left] = temp;

                    i = left;

                }else if((right <=  size) && (arr[i] < arr[right])){

                    int temp = arr[i];
                    arr[i] = arr[right];
                    arr[right] = temp;

                    i = right;

                }else{
                    return;
                }
            }
        }

        public void heapify(int[] arr , int n , int i){

            // Time complexity of heapify = O(logN)
            // Time complexity of buildHeap = O(N)

            // ek node ko useke sahi position par le jane ka kaam heapify krta hai

            int largest = i;
            int left = 2*i;
            int right = 2*i + 1;

            if((left <= n) && (arr[largest] < arr[left])){
                largest = left;
            }
            if((right <= n) && (arr[largest] < arr[right])){
                largest = right;
            }

            if(largest != i){

                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;

                heapify(arr, n, largest);
            }
            
        }
        public void heap_Sort(int[] arr ,int n){

            // Time complexity = O(NlogN)

            // Algo :
            // swap first element with last position , swap(arr[1],arr[n]) , size--
            // heapify root node 
            // continue until heap size > 1

            int size = n;

            while(size > 1){

                int temp = arr[1];
                arr[1] = arr[size];
                arr[size] = temp;

                size--;

                heapify(arr, size, 1);
            }
        }

        public void print(){
            for(int i=1;i<=size;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Heap h = new Heap();

        h.insert(50);
        h.insert(55);
        h.insert(53);
        h.insert(52);
        h.insert(54);

        h.print();

        h.delete();
        h.print();

        System.out.println("---------------------");


        Heap h1 = new Heap();

        int[] arr2 = {-1 , 4,1,3,9,7};
        int  n = 5;

        // heap creation
        for(int i = n/2 ; i>0 ; i--){
            h1.heapify(arr2,n,i); 
        }
        for(int i=1;i<=n;i++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        System.out.println("-------------------------");

        // heap sort
        h1.heap_Sort(arr2, n);

        for(int i=1;i<=n;i++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

    }
}



/*
void insert(int val);
void delete();
void heapify(int[] arr , int n , int i); 
void heap_Sort(int[] arr ,int n);
void print();
 */