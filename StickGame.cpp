#include<bits/stdc++.h>

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    int moves[k];
    long long dp[n+1]={};
    dp[0] = 0;
    for(int i = 0; i < k; i++){
        cin >> moves[i]; 
    }
    for(int i = 1; i <= n; i++){
        for(int j = 0; j < k; j++){
            if(i-moves[j]>=0 && dp[i-moves[j]]==0) dp[i] = 1;
        }
    }
    for(int i = 1; i <= n; i++){
        if(dp[i]==1) cout<<"W";
        else cout<<"L";
    }
    
}