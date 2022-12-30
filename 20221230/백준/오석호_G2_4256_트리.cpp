#include <iostream>
using namespace std;

int preorder[1001];
int inorder[1001];

void postOrder(int s, int e, int pivot) {
	for (int i = s; i < e; ++i) {
		// inorder를 순서대로 뒤져서 preorder[pivot]를 찾는다
		// root(pivot이 0인 경우)를 기준으로 나누고 왼쪽부터 처리한다
		// 이걸 재귀로 반복한다
		if (preorder[pivot] == inorder[i]) {
			// inorder에서 pivot 기준 왼쪽
			postOrder(s, i, pivot + 1);
			// inorder에서 pivot 기준 오른쪽
			postOrder(i + 1, e, pivot + (i - s) + 1);
			// 기준은 마지막에 출력
			cout << preorder[pivot] << " ";
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 4256 트리
	// 재귀
	int t, n;
	cin >> t;
	for (int i = 0; i < t; ++i) {
		cin >> n;

		// preorder inorder 채우기
		for (int j = 0; j < n; ++j) cin >> preorder[j];
		for (int j = 0; j < n; ++j) cin >> inorder[j];

		postOrder(0, n, 0);

		// preorder, inorder 초기화
		for (int j = 0; j < n; ++j) {
			preorder[j] = 0;
			inorder[j] = 0;
		}

		cout << '\n';
	}

	return 0;
}    
