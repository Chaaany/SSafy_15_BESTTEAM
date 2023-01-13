import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_26652_SeongSeongBee {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long[] level = new long[N];
		long[] newLevel = new long[N];
		long minLv = Long.MAX_VALUE;
		long ans = -1;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			level[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long temp = Long.parseLong(st.nextToken());
			long lv = level[i];
			long maxLv = find(lv, temp);
			newLevel[i] = maxLv;
			minLv = Math.min(minLv, maxLv);
		}

		long start = minLv;
		long end = 1000000000000l;
		long mid = (start + end) / 2;
		while (start <= end) {
			boolean check = true;
			long sum = 0;
			for (long i : level) {
				if (i > mid) {
					check = false;
					break;
				}
			}
			for (long i : newLevel) {
				if (mid > i) {
					sum += mid - i;
				}
			}
			if (sum > M) {
				end = mid - 1;
				check = false;
			} else {
				start = mid + 1;
			}
			if (check) {
				ans = mid;
			}
			mid = (start + end) / 2;
		}
		System.out.println(ans);
	}

	private static long find(long lv, long temp) {
		if (lv > temp)
			return lv;
		long start = lv;
		long end = 5000000000l;
		long mid = (start + end) / 2;
		long exp = sum(lv) + temp;
		while (start <= end) {
			if (exp < sum(mid)) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			mid = (start + end) / 2;
		}
		return mid;
	}

	private static long sum(long temp) {
		long temp2 = temp - 1;
		long exp = 0;
		if (temp2 % 2 == 0) {
			exp = (temp2 + 1) * (temp2 / 2);
			return exp;
		}
		exp = (temp2 + 1) * (temp2 / 2) + ((temp2 / 2) + 1);
		return exp;
	}

}
