#include<bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cin >> n;
    int cubes[n]; 
    for(int i = 0; i < n; i++){
        cin >> cubes[i];
    }
    multiset<int> towers;
    for(int i = 0; i < n; i++){
        if(towers.size() == 0){
            towers.insert(cubes[i]);
        }
        else{
            auto base = towers.upper_bound(cubes[i]); //vec.upper_bound returns first element greater than passed element
            if(base == towers.end()){ // if such a base does not exist
                towers.insert(cubes[i]);
            }
            else{
                towers.insert(cubes[i]);
                towers.erase(base); //replacing the base with the cube above since the base is now irrelevant
            }
        }
    }
    cout << towers.size();


}