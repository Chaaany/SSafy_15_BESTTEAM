import java.util.Scanner;

public class Main {

	static int [][] dp = new int [101][101];
	static StringBuilder sb = new StringBuilder();
	static int n, m, k;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		if(comb(n, m) < k) System.out.println(-1);
		else {
			makeString(n, m, k);
			System.out.println(sb);
		}
		
	}

	// makeString : string을 저장하는 함수
	private static void makeString(int a, int z, int k) {
		// 남은 a랑 z가 없으면 다 넣어주기
		if (a == 0) {
			for (int i = 0; i < z; ++i) sb.append("z");
				return;
		}
		if (z == 0) {
			for (int i = 0; i < a; ++i) sb.append("a");
				return;
		}
		
		// comb 구해서 맨 앞에 a 넣을지 z 넣을지 결정하기
		int remainder = comb(a-1, z);
		if (k <= remainder){
			sb.append("a");
			makeString(a-1, z, k);
		}
		else {
			sb.append("z");
			makeString(a, z-1, k-remainder);
		} 
	}

	// comb : dp에 aCz 조합 횟수를 저장하고 가져오거나, 바로 가져오는 함수
	private static int comb(int a, int z) {
		if (a == 0 || z == 0) return 1;
		else if(dp[a][z] == 0) dp[a][z] = Math.min(comb(a-1, z) + comb(a, z-1), 1000000000);
		return dp[a][z];
	}
}
