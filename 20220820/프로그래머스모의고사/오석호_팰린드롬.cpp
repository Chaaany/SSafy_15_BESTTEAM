#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(int n, int m) {
    int answer = 0;

    for (int i = n; i <= m; ++i){
        string s = to_string(i);
        reverse(s.begin(), s.end());
        if(to_string(i) == s) ++answer;
    }

    return answer;
}
