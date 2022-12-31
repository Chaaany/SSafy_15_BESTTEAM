import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> start = new HashMap<String, Integer>();
//		HashMap<String, Integer> end = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			start.put(br.readLine(), i);
		}
		int[] rank = new int[N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			rank[i] = start.get(temp);
		}
//		System.out.println(Arrays.toString(rank));
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (rank[i] > rank[j]) {
					answer++;
					break;
				}
			}
		}

		System.out.println(answer);
	}

}
