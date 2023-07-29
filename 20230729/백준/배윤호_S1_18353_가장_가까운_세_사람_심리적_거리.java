import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_20529_NearestThreePersonsMindDistance {
	static List<String> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Set<String> set = new HashSet<>();
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < N; i++) {
				String temp = st.nextToken();
				set.add(temp);
				if (map.get(temp) != null) {
					if (map.get(temp) < 3) {
						map.put(temp, map.get(temp) + 1);
					}
				} else {
					map.put(temp, 1);
				}
			}
			Iterator<String> iter = set.iterator();
			list = new ArrayList<>();
			while (iter.hasNext()) {
				list.add(iter.next());
			}
			int size = list.size();
			for (int i = 0; i < size; i++) {
				if (map.get(list.get(i)) == 2) {
					list.add(list.get(i));
				} else if (map.get(list.get(i)) == 3) {
					list.add(list.get(i));
					list.add(list.get(i));
				}
			}
			int min = 100001;
			for (int i = 0; i < list.size() - 2; i++) {
				for (int j = i + 1; j < list.size() - 1; j++) {
					for (int k = j + 1; k < list.size(); k++) {
						min = Math.min(min, find(i, j, k));
					}
				}
			}
			sb.append(min + "\n");
		}
		System.out.println(sb);
	}

	private static int find(int i, int j, int k) {
		int distance = 0;
		String A = list.get(i);
		String B = list.get(j);
		String C = list.get(k);
		distance = diff(A, B) + diff(B, C) + diff(A, C);
		return distance;
	}

	private static int diff(String a, String b) {
		int diff = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				diff++;
			}
		}
		return diff;
	}

}
