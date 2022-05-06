#include<bits/stdc++.h>

using namespace std;

struct SusPairs{
    int left, right;
};

bool comparator(SusPairs a, SusPairs b){
    if(a.left==b.left){
        return a.right > b.right;
    }
    return a.left < b.left;
}

int main() {
    freopen("mountains.in", "r", stdin);
	freopen("mountains.out", "w", stdout);
    int N; cin >> N;
    vector<SusPairs> a(N);
    for(int i = 0; i < N; i++){
        int x, y; cin >> x >> y;
        int l = x-y; int r = x+y;
        a[i] = {l, r};
    }
    sort(begin(a), end(a), comparator);
    int ans = 0;
    int maxr=-1;
    for(int i = 0; i < N; i++){
        if(a[i].right > maxr){
            ans++;
            maxr = a[i].right;
        }   
    }
    cout << ans;

}
