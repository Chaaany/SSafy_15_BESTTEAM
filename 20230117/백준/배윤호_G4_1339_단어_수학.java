import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_1339_WordMath {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int[] a = new int[26];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int zari = s.length() - 1;
			for (int j = 0; j < s.length(); j++) {

				char temp = s.charAt(j);
				a[temp - 65] += 1 * Math.pow(10, zari);
				zari--;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (a[i] != 0) {
				pq.add(a[i]);
			}
		}
		int number = 9;
		while (!pq.isEmpty()) {
			int c = pq.poll();
			answer += c * number;
			number--;
		}
		System.out.println(answer);
	}

}
