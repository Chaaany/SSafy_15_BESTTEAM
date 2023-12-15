import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ_1431_SerialNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<serialNumber> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.add(new serialNumber(br.readLine()));
		}
		while (!pq.isEmpty()) {
			sb.append(pq.poll().sn).append("\n");
		}
		System.out.println(sb);
	}

	static class serialNumber implements Comparable<serialNumber> {
		String sn;

		public serialNumber(String sn) {
			this.sn = sn;
		}

		@Override
		public int compareTo(serialNumber o) {
			if (this.sn.length() > o.sn.length()) {
				return 1;
			} else if (this.sn.length() < o.sn.length()) {
				return -1;
			} else {
				int a = 0;
				int b = 0;
				for (int i = 0; i < this.sn.length(); i++) {
					if (this.sn.charAt(i) >= '0' && this.sn.charAt(i) <= '9') {
						a += this.sn.charAt(i) - 48;
					}
				}
				for (int i = 0; i < o.sn.length(); i++) {
					if (o.sn.charAt(i) >= '0' && o.sn.charAt(i) <= '9') {
						b += o.sn.charAt(i) - 48;
					}
				}
				if (a > b) {
					return 1;
				} else if (a < b) {
					return -1;
				} else {
					String[] s = new String[2];
					s[0] = this.sn;
					s[1] = o.sn;
					Arrays.sort(s);
					if (s[0] == this.sn) {
						return -1;
					} else if (s[0] == o.sn) {
						return 1;
					}
				}
			}
			return 1;
		}

	}
}
