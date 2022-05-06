#include<bits/stdc++.h>

using namespace std;

int main() {
    freopen("paintbarn.in", "r", stdin);
	freopen("paintbarn.out", "w", stdout);
    int N, K; cin >> N >> K;
    int ps[1001][1001];
    for(int i = 0; i < N; i++){
        int x1, y1, x2, y2; 
        cin >> x1 >> y1 >> x2 >> y2;
        ps[x1][y1]++;
        ps[x1][y2]--;
        ps[x2][y1]--;
        ps[x2][y2]++;
    }
    int ans = 0;
    for(int x = 0; x < 1000; x++){
        for(int y = 0; y < 1000; y++){
            if(x) ps[x][y] += ps[x-1][y];
            if(y) ps[x][y] += ps[x][y-1];
            if(x && y) ps[x][y] -= ps[x-1][y-1];
            if(ps[x][y]==K) ans++;
        }
    }
    cout << ans;
}