#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool desc(int a, int b) {
    return a > b;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 1026 보물
    // 정렬

    int n, input;
    vector<int> v1;
    vector<int> v2;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> input;
        v1.push_back(input);
    }
    for (int i = 0; i < n; ++i) {
        cin >> input;
        v2.push_back(input);
    }

    sort(v1.begin(), v1.end());
    sort(v2.begin(), v2.end(), desc);

    int result = 0; 

    for (int i = 0; i < n; ++i) {
        result += v1[i] * v2[i];
    }

    cout << result;

    return 0;
}
