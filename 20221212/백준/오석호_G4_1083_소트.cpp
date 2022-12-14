#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 1083 소트
	// 그리디
	// targetIdx가 허락하는 선에서 가장 큰 수를 앞으로 보내면 됨
	int n, s, input;
	cin >> n;
	vector<int> v;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		v.push_back(input);
	}
	cin >> s;
	
	int targetIdx = 0;
	while (s > 0 && targetIdx < n) {
		// max값 찾기
		int maxValue = -1;
		int maxIdx = -1;
		for (int i = targetIdx; i < n; ++i) {
			if (s - (i - targetIdx) >= 0) {
				if (maxValue < v[i]) {
					maxValue = v[i];
					maxIdx = i;
				}
			}
		}

		for (int i = maxIdx; i > targetIdx; --i) {
			int tmp = maxValue;
			v[i] = v[i - 1];
			v[i - 1] = tmp;
			--s;
			if (s <= 0) break;
		}

		++targetIdx;
	}

	for (int i = 0; i < v.size(); ++i) {
		cout << v[i] << " ";
	}

	return 0;
}
