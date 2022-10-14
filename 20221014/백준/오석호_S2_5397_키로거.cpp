#include <iostream>
#include <string>
#include <list>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 5397 키로거
    // 스택
    int n;
    string s;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        list<char> ans;
        auto cursor = ans.end();
        cin >> s;
        for (int j = 0; j < s.size(); ++j) {
            if (s[j] == '<') {
                if (cursor != ans.begin()) --cursor;
            }
            else if (s[j] == '>') {
                if (cursor != ans.end()) ++cursor;
            }
            else if (s[j] == '-') {
                if (cursor != ans.begin()) {
                    --cursor;
                    cursor = ans.erase(cursor);
                }
            }
            else {
                ans.insert(cursor, s[j]);
            }
        }

        for (auto j = ans.begin(); j != ans.end(); ++j) {
            cout << *j;
        }
        cout << '\n';
    }

    return 0;
}
