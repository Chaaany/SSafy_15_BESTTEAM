import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[] arr;
	static List<Integer> list;
	static int[][] q;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		list = new ArrayList<Integer>();
		q = new int[m][k];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				q[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		arr = new int[n * 2 + 1];
		for (int i = 0; i < n * 2 + 1; i++) {
			arr[i] = i;
		}
		choose(0, 1); // 스킬 선택
		System.out.print(max);
	}

	private static void choose(int count, int temp) {
		if (count == n) {
			check();
			return;
		}
		for (int i = temp; i < arr.length; i++) {
			list.add(arr[i]);
			choose(count + 1, i + 1);
			list.remove(count);
		}

	}

	private static void check() {
		int clear = 0;
		for (int i = 0; i < m; i++) {
			boolean check = true;
			for (int j = 0; j < k; j++) {
				if (!list.contains(q[i][j])) {
					check = false;
					break;
				}
			}
			if (check) {
				clear++;
			}
		}
		max = Math.max(max, clear);

	}

}
