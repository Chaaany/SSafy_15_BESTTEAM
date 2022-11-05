import java.util.Scanner;

public class Main_G3_23295_스터디시간정하기1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		int[] timeline = new int[100001];
		int latest = 0;
		for (int i = 0; i < N; i++) {
			int K = sc.nextInt();
			for (int j = 0; j < K; j++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				latest = Math.max(latest, e);
				for (int k = s; k < e; k++) {
					timeline[k]++;
				}
				
			}
		}
		int al = 0;
		int ar = al+T;
		int l = 0;
		int r = l+T;
		int happiness = 0;
		for(int i = l; i < r; i++) {
			happiness += timeline[i];
		}
		int t = happiness;
		while (r < latest) {
			t = t - timeline[l] + timeline[r];
			if(t > happiness) {
				happiness = t;
				al = l+1;
				ar = r+1;
			}
			l++;
			r++;
			
		}
		System.out.println(al+" "+ar);
	}
}
