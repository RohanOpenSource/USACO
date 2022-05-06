#include<bits/stdc++.h>
#include <utility>

using namespace std;


int main() {
    int n;
    cin >> n;
    pair<int, int> a[n];
    for(int i = 0; i < n; i++){
        int b, c;
        cin >> b >> c;
        a[i].first = c;
        a[i].second = b; 
    }
    sort(a, a+n);
    int count = 0;
    int curr = -1;
    for(int i = 0; i < n-1; i++){
        if(curr == -1){
            curr = a[i].first;
            count++;
        }
        if(a[i+1].second >= curr){
            curr = a[i+1].first;
            count++;
        }
    }
    cout << count;

}