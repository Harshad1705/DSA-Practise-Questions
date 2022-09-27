#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin>>n;
    
    vector<int> arr;
    int j = 0;
    while(n!=0){
        arr.push_back(n%2);
        n = n/2 ;
        j++;
    }
    
    reverse(arr.begin(),arr.end());
    for(int i : arr){
        cout<<i;
    }
    
    return 0;
}
