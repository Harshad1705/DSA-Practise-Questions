#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>
using namespace std;



int main()
{
    int n;
    cin>>n;
    
    int ans = 0 ;
    vector<int> arr;
    
    while(n>0){
        arr.push_back(n%10);
        n = n/10;
    
    }

    for(int i = 0;i<arr.size();i++){
        ans = ans+ (arr[i]*pow(2,i));
    }
    
    cout<<ans<<endl;
    
    
    return 0;
}
