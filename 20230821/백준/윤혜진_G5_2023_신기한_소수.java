import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] num, prime;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		
		dfs(0, N);
		System.out.println(sb);
	}

	private static void dfs(int depth, int len) {
		String s = "";
		for (int i = 0; i < depth; i++) {
			s += num[i];
		}
		
		if(depth == len) {
			sb.append(s+"\n");
			return;
		}
		
		// 맨처음에는 1이 오면 안됨
		String copy = s;
		if(depth == 0) {
			for (int i = 2; i < 10; i++) {
				copy = s + Integer.toString(i);
				if(isPrime(Integer.parseInt(copy))) {
					num[depth] = i;
					dfs(depth+1, len);
				}
			}
		}
		else {
			for (int i = 0; i < 10; i++) {
				copy = s + Integer.toString(i);
				if(isPrime(Integer.parseInt(copy))) {
					num[depth] = i;
					dfs(depth+1, len);
				}
			}
		}
	}

	private static boolean isPrime(int n) {
		for (int i = 2; i <= n/2; i++) {
			if(n%i == 0) return false;
		}
		
		return true;
	}

}
