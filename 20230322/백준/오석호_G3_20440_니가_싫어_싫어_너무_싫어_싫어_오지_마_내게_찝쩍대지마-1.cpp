#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 20440 니가 싫어 싫어 너무 싫어 싫어 오지 마 내게 찝쩍대지마-1
	// 누적합
	int n, e, x;
	vector<int> v; // 입력값
	vector<pair<int, int>> v2; // 범위
	// 정답용 변수
	int ans = 0;
	int ansStart = -1;
	int ansEnd = -1;
	cin >> n;

	for (int i = 0; i < n; ++i){
		cin >> e >> x;
		v.push_back(e);
		v.push_back(x);
		v2.push_back({ e, x });
	}

	// 정렬
	sort(v.begin(), v.end());
	// 중복제거 (좌표압축)
	v.erase(unique(v.begin(), v.end()), v.end());
	// 좌표압축한 시간대에 시간의 합을 저장해두기 위한 벡터
	vector<int> time(v.size());
	for (int i = 0; i < v2.size(); ++i) {
		// 좌표압축한 요소의 위치 추적
		int start = lower_bound(v.begin(), v.end(), v2[i].first) - v.begin();
		int end = lower_bound(v.begin(), v.end(), v2[i].second) - v.begin();
		// 누적합을 위한 시작점과 끝점 처리
		++time[start];
		--time[end];
	}
	
	// 누적합 처리하기, 가장 모기가 많을 때의 마릿수 처리하기
	ans = time[0];
	for (int i = 1; i < time.size(); ++i) {
		time[i] += time[i - 1];
		ans = max(ans, time[i]);
	}

	// 범위찾기
	bool chk = false;
	for (int i = 0; i < time.size(); ++i) {
		if (!chk && time[i] == ans) {
			chk = true;
			ansStart = v[i]; // 좌표압축 복구
		}
		if (chk && time[i] != ans) {
			ansEnd = v[i]; // 좌표압축 복구
			break;
		}
	}

	// 출력
	cout << ans << '\n' << ansStart << " " << ansEnd;
	
	return 0;
}
