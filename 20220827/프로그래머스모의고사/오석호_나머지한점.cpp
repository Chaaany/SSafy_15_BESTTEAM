#include <iostream>
#include <vector>
#include <map>
using namespace std;

vector<int> solution(vector<vector<int> > v) {
    vector<int> ans;
    map<int, int> m1;
    map<int, int> m2;

    for (int i = 0; i < 3; ++i){
        ++m1[v[i][0]];
        ++m2[v[i][1]];
    }

    for (auto iter = m1.begin(); iter != m1.end(); ++iter) {
        if (iter->second % 2 != 0) {
            ans.push_back(iter->first);
            break;
        }
    }

    for (auto iter = m2.begin(); iter != m2.end(); ++iter) {
        if (iter->second % 2 != 0) {
            ans.push_back(iter->first);
            break;
        }
    }

    return ans;
}
