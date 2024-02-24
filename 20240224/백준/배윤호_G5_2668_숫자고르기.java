import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	static int[] arr;
	static Set<Integer> ans = new TreeSet<>();
	static PriorityQueue<Integer> pqIndex;
	static PriorityQueue<Integer> pqValue;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i < N + 1; i++) {
			pqIndex = new PriorityQueue<Integer>();
			pqValue = new PriorityQueue<Integer>();
			v = new boolean[N + 1];
			find(i);
//			System.out.println("next!");
		}
		sb.append(ans.size()).append("\n");
		for (int a : ans) {
			sb.append(a + "\n");
		}
		System.out.println(sb);

	}

	private static void find(int i) {
		pqIndex.add(i);
		pqValue.add(arr[i]);
//		System.out.println("현재 인덱스 "+i+" 다음 갈 곳 "+arr[i]);
		if (v[arr[i]]) {
			check();
			return;
		}
		v[i] = true;
		find(arr[i]);

	}

	private static void check() {
		boolean same = true;
		List<Integer> temp = new ArrayList<>();
		while (!pqIndex.isEmpty()) {
			int cur1 = pqIndex.poll();
			int cur2 = pqValue.poll();
//			System.out.println("비교 " +cur1+" "+cur2);
			temp.add(cur1);
			if (cur1 != cur2) {
				same = false;
				break;
			}
		}
		if (same) {
//			System.out.println("같다!");
			for (int a : temp) {
//				System.out.println(a);
				ans.add(a);
			}
		}
	}

}
