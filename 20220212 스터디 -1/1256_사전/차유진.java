import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 차유진 {
	static int N,M,K;
	static char[] p;
	static char[] word;
	static boolean[] v;
	static int count;
	static String ans;
	static boolean flag;
	static Set<String> set = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		p = new char[N+M];
		word = new char[N+M];
		v = new boolean[N+M];
		
		for (int i = 0; i < N; i++) {
			p[i] = 'a';
		}
		for (int i = 0; i < M; i++) {
			p[N+i] = 'z';
		}
		go(0);
		if(ans == null) System.out.println(-1);
		sc.close();
	}
	private static void go(int cnt) {
		if(flag)return;
		if(cnt == N+M) {
			String st = String.valueOf(word);
			if(!set.contains(st)) {
				set.add(st);
				count++;
				System.out.println(st);
			}
			if(count == K) {
				ans = String.valueOf(word);
				System.out.println(ans);
				flag = true;
				return;
			}
			return;
		}
		for (int i = 0; i < N+M; i++) {
			if(v[i]) continue;
			v[i] = true;
			word[cnt] = p[i];
			if(!flag)go(cnt+1);
			v[i] = false;
			if(flag) {
				System.out.println("BREAK");
				break;
			}
		}
	}
}
