import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<String> list = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int AlphabetLength = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			AlphabetLength += s.length();
			list.add(s);
		}
		int totalUnderBar = M - AlphabetLength;
		int maxUnder = 0;
		int maxUnderCount = 0;
		int minUnder = 0;
		int minUnderCount = 0;

		minUnder = totalUnderBar / (N - 1);
		maxUnderCount = totalUnderBar % (N - 1);
		maxUnder = minUnder + 1;
		minUnderCount = (N - 1) - maxUnderCount;

		StringBuilder sb = new StringBuilder();
		sb.append(list.get(0));
		for (int i = 1; i < N; i++) {
			String s = list.get(i);
			if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
				if (minUnderCount > 0) {
					for (int j = 0; j < minUnder; j++) {
						sb.append('_');
					}
					minUnderCount--;
					sb.append(s);
				} else {
					for (int j = 0; j < maxUnder; j++) {
						sb.append('_');
					}
					maxUnderCount--;
					sb.append(s);
				}
			} else {
				if (maxUnderCount > 0) {
					for (int j = 0; j < maxUnder; j++) {
						sb.append('_');
					}
					maxUnderCount--;
					sb.append(s);
				} else {
					for (int j = 0; j < minUnder; j++) {
						sb.append('_');
					}
					minUnderCount--;
					sb.append(s);
				}
			}

		}
		System.out.println(sb);

	}

}
