import java.io.*;

public class BJ_20437_StringGame2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			int K = Integer.parseInt(br.readLine());
			// K가1이면 1,1임
			if (K == 1) {
				sb.append("1 1").append("\n");
				continue;
			}
			// 알파벳 갯수를 세서 저장해둘 배열
			int[] alpha = new int[26];
			for (int j = 0; j < s.length(); j++) {
				alpha[s.charAt(j) - 'a']++;
			}

			int min = Integer.MAX_VALUE;
			int max = 0;
			// 문자열 한 글자씩 탐색
			for (int j = 0; j < s.length(); j++) {
				// 만약 지금 알파벳이 K보다 작으면 아무리 끝까지 늘려도 안되니까 깐띠뉴
				if (alpha[s.charAt(j) - 'a'] < K) {
					continue;
				}

				int count = 1;
				// 시작 다음점부터 탐색
				for (int l = j + 1; l < s.length(); l++) {
					// 시작점과 같은 알파벳이면 카운트 증가
					if (s.charAt(j) == s.charAt(l)) {
						count++;
					}
					// 카운트가 K랑 같다면 최소값과 최대값 갱신
					if (count == K) {
						min = Math.min(min, l - j + 1);
						max = Math.max(max, l - j + 1);
						break;
					}
				}
			}
			if (min == Integer.MAX_VALUE || max == 0) {
				sb.append("-1").append("\n");
			} else {
				sb.append(min + " " + max + "\n");
			}
		}
		System.out.println(sb);

	}

}
