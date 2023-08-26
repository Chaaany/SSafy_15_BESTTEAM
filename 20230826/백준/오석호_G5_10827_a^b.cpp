#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>
using namespace std;

string multiple(string& a, string& b) { // 일반적인 계산방식은 이중 for문이라 O(n^2), 카라츠바 알고리즘을 쓰면 O(n^log3)까지 단축할 수 있다. 이건 일반 방식!
	int r[100000] = { 0 }; // 배열 0으로 초기화
	bool chk = false; // 0 체크용 부울변수

	// 우리가 초등학교때 곱셈계산하듯이 각 자리별로 곱해서 배열에 더해준다.
	// 현실에서는 일반적으로 이 알고리즘과는 반대로 1의 자리부터 A에다가 곱한 후 더해주기 때문에 헷갈릴 순 있지만, 결과적으로 값은 똑같다.)
	for (int i = 0; i < a.size(); ++i) {
		for (int j = 0; j < b.size(); ++j) {
			r[i + j] += (a[i] - '0') * (b[j] - '0'); // a와 b에서 각각 0의 아스키코드를 뺀다음 둘을 곱해서 더해준다. (문자열이니 아스키코드계산, 여러번 더해야 하므로 =이 아니라 +=임에 주의!!)
		}
	}

	for (int i = a.size() + b.size() - 1; i > 0; --i) { // 첫항 빼고는 10으로 나눈 나머지만 남긴다. 몫은 이전항으로 넘겨버린다. (첫항은 2자리까지 나올 수 있다!!)
		// n자리*n자리는 최대 2n자리까지 나올 수 있으니까 n+n-1만큼의 자리로 2n자리를 표기하기 위해서는 어딘가에는 2자리를 적어야하는데 그게 첫항!!)
		r[i - 1] += r[i] / 10; // 몫(carry값)
		r[i] = r[i] % 10; // 나머지
	}

	for (int i = 0; i < a.size(); i++) { // r 내의 모든 요소가 0이라면, chk는 false로 남아있게 된다.
		if (r[i] != 0)
			chk = true;
	}

	if (!chk) { // 만약 이 chk가 false면 0을 반환한다.
		return 0;
	}

	else {
		// strlen 두개를 더한 값의 -1만큼만 출력해야 값이 있는 부분만 반환할 수 있다.
		// 첫항에서 1자리와 2자리 모두 나올 수 있기 때문에 배열 요소는 항상 같은 갯수만큼 출력해도 된다.
		string s;
		for (int i = 0; i < a.size() + b.size() - 1; i++) s += to_string(r[i]);

		return s;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 10827 a^b
	// 수학
	string a;
	int b;
	string ans = "1";
	cin >> a >> b;
	
	// 소숫점 찾기
	auto dotIdx = find(a.begin(), a.end(), '.'); // 점의 위치를 iterator형태로 나타낸 요소
	int idx = a.end() - dotIdx - 1; // 점의 위치이자 나중에 들어갈 점의 위치가 될 요소
	a.erase(dotIdx);
	
	// 맨 앞 0 제거
	while(1) {
		if (a[0] == '0') a.erase(a.begin());
		else break;
	}

	idx *= b; // 최종 정답의 . 위치
	
	for (int i = 0; i < b; ++i) ans = multiple(a, ans);
	
	// . 붙이기
	if (ans.size() <= idx) {
		for (int i = 0; i < idx; ++i) ans = '0' + ans;
	}
	ans.insert(ans.end() - idx, '.');

	// 맨 앞 0 지우기
	while (1) {
		if (ans[0] == '0' && ans[1] == '0') ans.erase(ans.begin());
		else break;
	}

	// 출력
	cout << ans;

	return 0;
}
