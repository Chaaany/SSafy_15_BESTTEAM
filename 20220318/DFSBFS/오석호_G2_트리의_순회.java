import java.util.Scanner;

public class Main {
	
	static int n;
	static int[] inorder, postorder;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		inorder = new int[100001];
		postorder = new int[100001];
		
		n = sc.nextInt();
		
		for (int i = 0; i < n; ++i) {
			inorder[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; ++i) {
			postorder[i] = sc.nextInt();
		}
		
		getPreorder(0, n-1, 0, n-1);
	}

	private static void getPreorder(int in1, int in2, int post1, int post2) {
		// 종료 조건
		if (in2 < in1 || post2 < post1) return;
		
		// 루트 찾기
		int root = postorder[post2];
		
		// 중간 위치 저장해둘 변수
		int middle = -1;
		
		// inorder에서 root 위치 찾기
		for (int i = in1; i <= in2; ++i) {
			if (inorder[i] == root) {
				middle = i;
				break;
			}
		}
		
		// 루트를 기준으로 양 옆에 몇개의 요소들이 있는지 (왼쪽만 있으면 된다!)
		int Lcnt = middle - in1;
		
		// 루트 출력
		System.out.print(root + " ");
		
		// 재귀 돌리기
		
		// 왼쪽 재귀
		getPreorder(in1, middle-1, post1, post1 + Lcnt - 1);
		
		// 오른쪽 재귀
		getPreorder(middle+1, in2, post1+Lcnt, post2 -1);
	}
}
