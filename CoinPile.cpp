#include<bits/stdc++.h>

using namespace std;

int main() {
    int t;
    freopen("a.in","r", stdin);
    freopen("a.out","w", stdout);
    cin >> t;
    for(int i = 0; i < t; i++){
        int a, b;
        cin >> a >> b;
        int c = min(a,b)-abs(a-b);
        if(c%3==0 && c>=0) cout << "YES \n";
        else cout << "NO \n";
    }
}