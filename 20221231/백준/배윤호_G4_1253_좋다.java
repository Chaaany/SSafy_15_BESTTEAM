import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		Set<Integer> set = new HashSet<>();
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (N == 1 || N == 2) {
			answer = 0;
			System.out.println(answer);
		} else {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] value = new int[N];
			for (int i = 0; i < N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				value[i] = temp;
				if (map.get(temp) == null) {
					map.put(temp, 1);
				} else {
					map.put(temp, map.get(temp) + 1);
				}

			}
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (value[i] == 0 && value[j] == 0) {
						if (map.get(0) < 3) {
							continue;
						}
					}
					if (value[i] == 0) {
						if (map.get(value[j]) < 2) {
							continue;
						}
					}
					if (value[j] == 0) {
						if (map.get(value[i]) < 2) {
							continue;
						}
					}
					set.add(value[i] + value[j]);
				}
			}
			for (int i = 0; i < N; i++) {
				if (set.contains(value[i])) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}
