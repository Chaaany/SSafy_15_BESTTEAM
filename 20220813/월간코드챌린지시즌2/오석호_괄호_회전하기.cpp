#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

int solution(string s) {
    int answer = 0;
    for (int i = 0; i < s.size(); ++i){
        stack<char> st;
        bool chk = false;
        for (int j = 0; j < s.size(); ++j) {
            if (s[j] == '[' || s[j] == '{' || s[j] == '(') {
                st.push(s[j]);
                chk = true;
            }
            else {
                if (s[j] == ']' && st.top() == '[') st.pop();
                if (s[j] == '}' && st.top() == '{') st.pop();
                if (s[j] == ')' && st.top() == '(') st.pop();
            }
        }
        if (st.empty() && chk) ++answer;
        s += s[0]; // 맨 앞을 맨 뒤로 보내기
        s.erase(s.begin()); // 맨 앞에꺼 빼기
    }
    return answer;
}
