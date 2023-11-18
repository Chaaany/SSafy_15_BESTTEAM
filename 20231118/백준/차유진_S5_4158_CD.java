import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_4158_CD {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String NM = br.readLine();
			StringTokenizer stz = new StringTokenizer(NM);
			int N = Integer.parseInt(stz.nextToken());
			int M = Integer.parseInt(stz.nextToken());
			if(N == 0 && M == 0) break;
			int[] a = new int[N];
			int[] b = new int[M];
			for(int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(br.readLine());
			}
			for(int i = 0; i < M; i++) {
				b[i] = Integer.parseInt(br.readLine());
			}
			
			int idxA = 0;
			int idxB = 0;
			int cnt = 0;
			while(true) {
				if(idxA >= N || idxB >= M) break;
				if(a[idxA] == b[idxB]) {
					cnt++;
					idxA++;
					idxB++;
				} else if (a[idxA] > b[idxB]) {
					idxB++;
				} else {
					idxA++;
				}
			}
			System.out.println(cnt);
		}
	}

}
