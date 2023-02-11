#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 20437 문자열 게임 2
	// 문자열
    int t;
    cin >> t;
    vector<int> v[26]; // 알파벳 아스키코드

    for (int tc = 0; tc < t; ++tc) {
        string w;
        int k;
        cin >> w >> k;

        int minValue = 10001;
        int maxValue = 0;

        // 테케별 초기화
        for (int i = 0; i < 26; ++i) v[i].clear();

        // 해당 알파벳을 가진 인덱스 저장
        for (int i = 0; i < w.size(); ++i) {
            int tmp = w[i] - 97; // 소문자 a 빼서 계산
            v[tmp].push_back(i);
        }

        // 인덱스를 확인해서 파악하기
        for (int i = 0; i < 26; ++i) {
            int vsize = v[i].size();
            if (vsize >= k) { // 해당 알파벳을 k개 포함한 친구들만 처리
                for (int j = 0; j <= vsize - k; ++j) { // vsize - k만큼만 해도 처리 가능 (어짜피 k개만큼 포함해야 하므로 vsize - k 이후는 해당 알파벳을 k개 포함시킬 수 없음)
                    minValue = min(minValue, v[i][j + k - 1] - v[i][j] + 1);
                    maxValue = max(maxValue, v[i][j + k - 1] - v[i][j] + 1);
                }
            }
        }

        // 출력
        if (minValue == 10001 || maxValue == 0) cout << -1 << '\n';
        else cout << minValue << " " << maxValue << '\n';
    }

	return 0;
}
