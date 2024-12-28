class Solution {
public:
    string shortestPalindrome(string s) {
        int idx = 0;
        // 앞에서부터 팰린드롬인 영역 찾기
        for(int i = 0; i < s.size(); ++i) {
            if(s[idx] == s[s.size() - i - 1]) ++idx;
        }
        // 만약 그 자체로 팰린드롬이면 그대로 출력
        if(idx == s.size()) return s;

        // 팰린드롬이 아닌 영역 구하기
        string res = s.substr(idx, s.size());
        string reverse_res = res;
        reverse(reverse_res.begin(), reverse_res.end());
    
        return reverse_res + shortestPalindrome(s.substr(0, idx)) + res;
    }
};
