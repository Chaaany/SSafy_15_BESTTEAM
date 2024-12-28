#include <iostream>
using namespace std;

class Solution {
public:
    string shortestPalindrome(string s) {
        // s의 역순 문자열을 생성
        string rev = s;
        reverse(rev.begin(), rev.end());

        for (int i = 0; i < rev.size(); ++i) {
            // s의 0번 인덱스부터 (s.size() - i)번 인덱스 전까지랑
            // rev의 i번 인덱스부터 끝까지랑 비교해서 같으면
            // rev의 0번 인덱스부터 i번 인덱스까지랑 s를 더한 값을 반환한다.
            if (s.compare(0, s.size() - i, rev, i) == 0) {
                return rev.substr(0, i) + s;
            }
        }

        // for문에서 return이 안되는 케이스는 s가 공백인 케이스밖에 없다
        // 이 때는 그대로 반환한다.
        return "";
    }
};
