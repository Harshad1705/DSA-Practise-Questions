
// quick sort

class Solution
{
    static void quickSort(int arr[], int low, int high)
    {
        if(low>=high){
            return;
        }
        
        int index = partition(arr,low,high);
 
        
        quickSort(arr , low , index-1);
        quickSort(arr , index+1 , high);
        
    }
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[low];
        
        int count = 0;
        
        for(int i=low+1 ; i<=high ; i++){
            if(arr[i] <= pivot){
                count++;
            }
        }
        
        int pivotindex = low + count;
        
        swap(arr,low , pivotindex);
        
        int i = low;
        int j = high;
        
        while( i < pivotindex && j > pivotindex){
            
            while(arr[i] <= pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            
            if(i < pivotindex && j > pivotindex){
                swap(arr,i,j);
                i++;
                j--;
            }
            
        }
        
        return pivotindex;
    } 
    
    public static void swap(int[] arr,int l,int h){
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
    }
}
