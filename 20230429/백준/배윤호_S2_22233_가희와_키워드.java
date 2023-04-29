import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_22233_GaheeAndKeyword {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> text = new HashMap<>();
		for (int i = 0; i < N; i++) {
			text.put(br.readLine(), 1);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String[] keyword = br.readLine().split(",");
			for (String s : keyword) {
				if (text.get(s) != null) {
					text.remove(s);
				}
			}
			sb.append(text.size()).append("\n");
		}
		System.out.println(sb);
	}

}
