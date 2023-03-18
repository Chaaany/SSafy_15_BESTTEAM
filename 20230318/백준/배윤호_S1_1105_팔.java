import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1105_Arm {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String L = st.nextToken();
		int R = Integer.parseInt(st.nextToken());
		int zari = L.length();
		int index = 0;
		int temp = 0;
		while (index < zari) {
			int a = L.charAt(index) - 48;
			if (a == 8) {
				a = 9;
				int plus = a * (int) Math.pow(10, zari - index - 1);
				if (temp + plus <= R) {
					temp += plus;
					break;
				} else {
					a--;
					plus = a * (int) Math.pow(10, zari - index - 1);
					temp += plus;
				}
			} else {
				int plus = a * (int) Math.pow(10, zari - index - 1);
				temp += plus;
			}
			index++;
		}
		String s = temp + "";
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '8')
				ans++;
		}
		System.out.println(ans);
	}

}
