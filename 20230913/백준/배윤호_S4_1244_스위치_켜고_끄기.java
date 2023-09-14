import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244_SwitchOnAndOff {

	static boolean[] switches;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		switches = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			switches[i] = Integer.parseInt(st.nextToken()) == 0 ? false : true;
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			switch (gender) {
			case 1:
				boy(num);
				break;
			case 2:
				girl(num);
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			if (i > 20 && i % 20 == 1) {
				sb.append("\n");
			}
			sb.append(switches[i] ? 1 : 0).append(" ");
		}
		System.out.println(sb);
	}

	private static void boy(int num) {
		for (int i = num; i < N + 1; i += num) {
			switches[i] = !switches[i];
		}
	}

	private static void girl(int num) {
		switches[num] = !switches[num];
		int left = num - 1;
		int right = num + 1;
		while (left >= 1 && right < N + 1) {
			if (switches[left] == switches[right]) {
				switches[left] = !switches[left];
				switches[right] = !switches[right];
			} else {
				break;
			}
			left--;
			right++;
		}

	}

}
