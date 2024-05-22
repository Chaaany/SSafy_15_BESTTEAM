#include <iostream>
#include <deque>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 18115 카드 놓기
	// 덱
	int n;
	int arr[1000001] = { 0 };
	int card = 1;
	deque<int> dq;
	
	cin >> n;
	for (int i = 0; i < n; ++i) cin >> arr[i];

	// 거꾸로 생각하자
	for (int i = n - 1; i >= 0; --i) {
		if (arr[i] == 1) dq.push_front(card);
		else if (arr[i] == 2) {
			int tmp = dq.front();
			dq.pop_front();
			dq.push_front(card);
			dq.push_front(tmp);
		}
		else if (arr[i] == 3) dq.push_back(card);
		++card;
	}

	for (int i = 0; i < n; ++i) cout << dq[i] << " ";

	return 0;
}
