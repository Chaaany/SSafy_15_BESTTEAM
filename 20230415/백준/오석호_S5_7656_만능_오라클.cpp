#include <iostream>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);	
	cout.tie(NULL);

	// 7656 만능 오라클
	// 문자열
	string s;
	int start = -1;
	int end = -1;
	getline(cin, s);
	// What을 연속해서 찾음
	while (s.find("What", end + 1) != -1) {
		// what이랑 ? 찾기
		start = s.find("What", end + 1);
		end = s.find("?", start + 1);

		// 필요한 문자열 자르기
		string tmp = s.substr(start, end - start + 1);

		// 중간에 .이 있으면 그 문장은 생략
		while (tmp.find(".") != -1) {
			int dotIdx = tmp.find(".");
			tmp = tmp.substr(dotIdx + 1, string::npos);
			start += dotIdx;
		}

		// 공백 제거
		int tmpIdx = tmp.find_first_not_of(' ');
		tmp.erase(0, tmpIdx);

		// 맨앞 맨뒤 바꾸기
		tmp.replace(0, 4, "Forty-two");
		tmp.pop_back();
		tmp += ".";
		cout << tmp << '\n';
	}

	return 0;
}
