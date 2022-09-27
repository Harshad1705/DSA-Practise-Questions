
// subsets

public class Rec_14 {
    
}



// class Solution
// {
//     public:
    
//     void func(vector<int>& A , int N , int index , vector<int>& temp , vector<vector<int>>& ans){
        
//         if(index == N){
//             ans.push_back(temp);
//             return;
//         }
        
//         // exclude
//         func(A,N,index+1,temp,ans);
        
//         // include
//         temp.push_back(A[index]);
//         func(A,N,index+1,temp,ans);
//         temp.pop_back();
        
//     }

//     vector<vector<int> > subsets(vector<int>& A)
//     {
//         vector<vector<int>> ans;
//         vector<int> temp;
        
//         func(A , A.size() , 0 , temp , ans);
        
//         sort(ans.begin() , ans.end());
        
//         return ans;
//     }
// };