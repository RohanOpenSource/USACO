#include<bits/stdc++.h>

using namespace std;
const int MAX = 1e5+1;
int N, M;
int x[MAX], y[MAX];
int maxx, maxy, minx, miny;
vector<int> adj[MAX];
bool visited[MAX];

void dfs(int n){
    visited[n] = true;
    maxx = max(maxx, x[n]);
    maxy = max(maxy, y[n]);
    minx = min(minx, x[n]);
    miny = min(miny, y[n]);
    for(int u:adj[n])if(!visited[u])dfs(u);
}

int main() {
    freopen("fenceplan.in", "r", stdin);
	freopen("fenceplan.out", "w", stdout); 
    cin >> N >> M;
    for(int i = 0; i < N; i++)cin >> x[i] >> y[i];
    for(int i = 0; i < M; i++){
        int a, b; 
        cin >> a >> b; 
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    int ans = -1;
    for(int i=1;i<=N;i++){
        if(!visited[i])
        maxx = -INT_MAX;
        maxy = -INT_MAX;
        minx = INT_MAX;
        miny = INT_MAX;
        dfs(i);
        ans = max(ans,2*(maxx-minx)+2*(maxy-miny));
    }
    cout << ans;
}