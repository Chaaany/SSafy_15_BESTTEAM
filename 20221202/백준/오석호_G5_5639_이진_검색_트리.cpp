#include <iostream>
using namespace std;

int arr[10001];

void postOrder(int s, int e) {
	if (s >= e) return;
	int i;
	for (i = s; i < e; ++i) {
		if (arr[s] < arr[i]) break;
	}
	// 전
	postOrder(s + 1, i);
	// 후
	postOrder(i, e);
	// 자신
	cout << arr[s] << '\n';
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	// 5639 이진 검색 트리
	// 그래프
	int input;
	int idx = 0;
	while (cin >> input) {
		arr[idx] = input;
		++idx;
	}
	postOrder(0, idx);

	return 0;
}
