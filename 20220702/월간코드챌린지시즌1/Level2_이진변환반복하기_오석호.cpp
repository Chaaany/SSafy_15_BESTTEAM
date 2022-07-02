#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string toBinary(int n) {
    string r;
    while (n != 0) {
        r += ( n % 2 == 0 ? "0" : "1" );
        n /= 2;
    }
    reverse(r.begin(), r.end());
    return r;
}

vector<int> solution(string s) {
    vector<int> answer;
    // 초기값 넣어두기
    answer.push_back(0);
    answer.push_back(0);
    
    // 이진변환 반복하기
    while(s.size() != 1){
        ++answer[0];
        int cnt = 0;
        for (int i = 0; i < s.size(); ++i){
            if (s[i] == '1') ++cnt;
        }
        answer[1] += s.size() - cnt;
        s = toBinary(cnt);
    }
    
    return answer;
}
