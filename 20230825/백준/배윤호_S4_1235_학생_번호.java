import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		int ans = 0;
		for (int i = 1; i < list.get(0).length(); i++) {
			boolean check = true;
			Map<String, Boolean> map = new HashMap<>();
			for (int j = 0; j < list.size(); j++) {
				String s = list.get(j);
				String temp = s.substring(s.length() - i, s.length());
				if (map.get(temp) != null) {
					check = false;
					break;
				}
				map.put(temp, true);

			}
			if (check) {
				ans = i;
				break;
			}

		}
		ans = (ans == 0) ? list.get(0).length() : ans;
		System.out.println(ans);
	}

}
