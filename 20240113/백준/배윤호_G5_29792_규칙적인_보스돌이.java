import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long max = 0;
	static long ans = 0;
	static int N, M, K;
	static long[] hp, meso;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		long[] damages = new long[N];

		for (int i = 0; i < N; i++) {
			damages[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(damages);
		hp = new long[K];
		meso = new long[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			long P = Long.parseLong(st.nextToken());
			long Q = Long.parseLong(st.nextToken());
			hp[i] = P;
			meso[i] = Q;
		}
		for (int i = N - 1; i > N - 1 - M; i--) {
			max = 0;
			find(damages[i], 900, 0, 0);
			ans += max;
//			System.out.println(max);
		}
		System.out.println(ans);

	}

	private static void find(long damage, long time, long profit, int start) {
		max = Math.max(max, profit);
		for (int i = start; i < K; i++) {
			long curHp = hp[i];
			long curMeso = meso[i];
			if (damage * time >= curHp) {
				long useTime = curHp / damage;
				if (curHp % damage != 0) {
					useTime++;
				}
				find(damage, time - useTime, profit + curMeso, i + 1);// 보스 잡을 경우
			}
			find(damage, time, profit, i + 1);// 보스 안잡을 경우
		}

	}

}
