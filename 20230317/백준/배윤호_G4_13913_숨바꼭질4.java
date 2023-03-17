import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] time = new int[400000];
		Arrays.fill(time, 1000000);
		time[N] = 0;
		int[] before = new int[400000];
		Arrays.fill(before, 1000000);
		before[N] = 0;
		Queue<Integer> que = new LinkedList<>();
		que.add(N);
		while (!que.isEmpty()) {
			int cur = que.poll();
			if (cur == K) {
				System.out.println(time[K]);
				StringBuilder sb = new StringBuilder();
				while (true) {
					sb.insert(0, K + " ");
					if (time[K] == 0)
						break;
					K = before[K];
				}
				System.out.println(sb);
				break;
			}
			if (cur + 1 <= 200000 && time[cur] + 1 < time[cur + 1]) {
				time[cur + 1] = time[cur] + 1;
				before[cur + 1] = cur;
				que.add(cur + 1);
			}
			if (cur - 1 >= 0 && time[cur] + 1 < time[cur - 1]) {
				time[cur - 1] = time[cur] + 1;
				before[cur - 1] = cur;
				que.add(cur - 1);
			}
			if (cur * 2 <= 200000 && time[cur] + 1 < time[cur * 2]) {
				time[cur * 2] = time[cur] + 1;
				before[cur * 2] = cur;
				que.add(cur * 2);
			}
		}

	}

}
