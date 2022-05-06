#include<bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cin >> n;
    int c[n];
    for(int i = 0; i < n; i++){
        cin >> c[i];
    }
    sort(c, c+n); //weird syntax should remember
    long ans = 1;
    for(int i = 0; i < n; i++){
        if(ans < c[i]) break; //this means that ans is not a possible sum
        else ans+=c[i];
    }
    cout << ans;

}