import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		long W = Long.parseLong(st.nextToken());
	    long tall = 0;
	    long[] tree = new long[N];
		for(int i=0; i<N; i++){
		    tree[i] = Integer.parseInt(br.readLine());
		    tall = Math.max(tall,tree[i]);
		}
		long max = 0;
		for (int i = 1; i <= tall; i++) {
			long money = 0;
			for (int j = 0; j < N; j++) {
				long cut = 0;
				if(tree[j] >= i) {
				    cut = tree[j] / i;
					if(tree[j] % i == 0) {
					    cut -= 1;
					}
					if(W * i * (tree[j] /i) - cut * C > 0) {
					    money += W * i * (tree[j] /i) - cut * C;
					}
				}
			}
			max = Math.max(max, money);
		}
		System.out.println(max);
	}
}
