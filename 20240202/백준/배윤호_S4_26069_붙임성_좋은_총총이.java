import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("ChongChong", true);
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			if (map.get(a) != null && map.get(a)) {
				map.put(b, map.getOrDefault(true, true));
			}
			if (map.get(b) != null && map.get(b)) {
				map.put(a, map.getOrDefault(true, true));
			}
		}
		int ans = 0;
		for (String a : map.keySet()) {
			if (map.get(a)) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
