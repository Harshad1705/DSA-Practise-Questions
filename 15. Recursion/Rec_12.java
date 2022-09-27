
// merge sort

class Solution
{
    void merge(int arr[], int l, int mid, int r)
    {
        int len1 = mid - l +1;
        int len2 = r - mid;
        
        int arr1[] = new int[len1];
        int arr2[] = new int[len2];
        
        int k = l ; 
        
        for(int i=0 ; i<len1 ; i++){
            arr1[i] = arr[k];
            k++;
        }
        for(int i = 0 ; i<len2 ; i++){
            arr2[i] = arr[k];
            k++;
        }
        

        int index1 = 0;
        int index2 = 0;
        int index = l;
        
        while(index1 < len1 && index2 < len2){
            
            if(arr1[index1]<=arr2[index2]){
                arr[index] = arr1[index1];
                index1++;
                index++;
            }else{
                arr[index] = arr2[index2];
                index2++;
                index++;
            }  
        }
        while(index1 < len1){
            arr[index] = arr1[index1];
            index1++;
            index++;
        }
        while(index2 < len2){
            arr[index] = arr2[index2];
            index2++;
            index++;
        }
        
        
        
    }
    
    void mergeSort(int arr[], int l, int r)
    {
        if(l>=r){
            return;
        }
        
        int mid = (l + r) /2;
        
        mergeSort(arr , l , mid);
        mergeSort(arr , mid+1 , r);
        
        merge(arr,l,mid,r);
    }
}
