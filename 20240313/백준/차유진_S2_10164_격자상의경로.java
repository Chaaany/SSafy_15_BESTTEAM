import java.io.*;
import java.util.*;

public class Main_S2_10164_격자상의경로 {

	public static void main(String[] args) throws Exception {

		int N, M, K, ans;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		K = Integer.parseInt(stz.nextToken());
		
		if(K != 0) {
			int aM = K % M;
			int aN = K / M + 1;
			if(aM == 0) {
				aM = M;
				aN = aN-1;
			}
			int bM = M - aM + 1;
			int bN = N - aN + 1;
			int part1 = (int)(fact(aM+aN-2, Math.max(aM-1, aN-1)) / Math.max(fact(Math.min(aM-1,aN-1),0),1));
			int part2 = (int)(fact(bM+bN-2, Math.max(bM-1, bN-1)) / Math.max(fact(Math.min(bM-1,bN-1),0),1));
			ans = part1 * part2;
		} else {
			ans = (int)(fact(M+N-2, Math.max(M-1, N-1)) / Math.max(fact((Math.min(M-1, N-1)),0), 1));
		}
		System.out.println(ans);
	}

	private static long fact(int x, int y) {
		long r = 1;
		for(int i = x; i > y; i--) {
			r *= i;
		}
		return r;
	}
}
