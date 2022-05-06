#include<bits/stdc++.h>
using namespace std;
#define MAXN 500
int N;
vector<int> adj[MAXN + 1];
bool reachable[MAXN + 1][MAXN+1];

void dfs(int src, int cur) {
	if (reachable[src][cur])
		return;
	reachable[src][cur] = true;
	for (int g : adj[cur])
		dfs(src, g);
}

int main() {
    cin >> N;
    for(int i = 1; i <= N; i++){
		adj[i].resize(N);
		for (int &g : adj[i])
			cin >> g;
		while (adj[i].back() != i)
			adj[i].pop_back();
    }
    for(int i = 1; i <=N; i++){
        dfs(i, i);
    }
    for(int i = 1; i <= N; i++){
        for(int j:adj[i]){
            if(reachable[j][i]){
                cout << j << "\n";
				break;
            }
        }
    }
}
