import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1062_Teaching {
	static List<Integer> alphabets = new ArrayList<>();
	static int ans;
	static int N, K;
	static int[] letters;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 26; i++) {
			if (i == 0 || i == 2 || i == 8 || i == 13 || i == 19) // anta로 시작 tica로 끝, acint 은 무조건 필요함
				continue;
			alphabets.add(i);
		}
//		System.out.println(alphabets);
		letters = new int[N];
		for (int i = 0; i < N; i++) {
			String letter = br.readLine();
			for (int j = 0; j < letter.length(); j++) {
//				System.out.println("단어 알파벳 하나씩" + letter.charAt(j));
				letters[i] |= (1 << (letter.charAt(j) - 'a'));
//				System.out.println(letters[i] + " " + Integer.toBinaryString(letters[i]));
			}
		}

		if (K < 5) { // acint 는 무조건 들어가는데 5개가 안되면 애초에 못 만듦
			System.out.println(0);
			return;
		}
		int teach = 0;
		teach += ((1 << 0) + (1 << 2) + (1 << 8) + (1 << 13) + (1 << 19)); // acint 마스킹해놓기
		comb(teach, 0, 0);
		System.out.println(ans);

	}

	public static void comb(int teach, int start, int cnt) {
		if (cnt == K - 5) { // 재귀 탈출 조건 가르친 알파벳 수가 K-5 일 때, 5개는 acint니까 무조건 가르쳐야함 거기에 cnt만큼 가르쳐서 K가 된 상황
			int temp = 0;
			for (int i = 0; i < N; i++) {
				if ((teach & letters[i]) == letters[i]) {
					temp++;
				}
			}
			ans = Math.max(ans, temp);
			return;
		}

		for (int i = start; i < alphabets.size(); i++) {
			teach ^= (1 << alphabets.get(i)); // ^= 는 xor 연산 둘이 다르면 1 아니면 0
			comb(teach, i + 1, cnt + 1);
			teach ^= (1 << alphabets.get(i)); // teach로 원상 복구
		}
	}

}
