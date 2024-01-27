import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] arr = new int[N];
			Map<Integer, Integer> map = new HashMap<>();
			Map<Integer, Integer> five = new HashMap<>();
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
				if (map.get(arr[i]) == 5) {
					five.put(arr[i], i);
				}
			}
			List<Integer> list = new ArrayList<>();
			for (int i : map.keySet()) {
				if (map.get(i) == 6) {
					list.add(i);
				}
			}
			int[] points = new int[201];
			int point = 1;
//			System.out.println(list.toString());
//			System.out.println(Arrays.toString(arr));
//			System.out.println(map.toString());
			for (int i = 0; i < N; i++) {
				if (!list.contains(arr[i]))
					continue;
				if (map.get(arr[i]) > 2) {
					points[arr[i]] += point;
					map.put(arr[i], map.get(arr[i]) - 1);
				}
				point++;
//				System.out.println(Arrays.toString(points));
			}
//			System.out.println(Arrays.toString(points));
			int minPoint = Integer.MAX_VALUE;
			int first = 0;
			for (int i = 1; i < 201; i++) {
				if (points[i] == 0)
					continue;
				if (!list.contains(i))
					continue;
				if (points[i] < minPoint) {
					first = i;
					minPoint = points[i];
				} else if (points[i] == minPoint) {
					if (five.get(i) < five.get(first)) {
						first = i;
						minPoint = points[i];
					}
				}
			}
			sb.append(first + "\n");
		}
		System.out.println(sb);

	}

}
