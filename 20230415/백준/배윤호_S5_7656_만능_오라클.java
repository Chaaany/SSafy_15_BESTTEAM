import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		List<String> list = new ArrayList<>();
		String temp = s.charAt(0) + "";
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '?' || s.charAt(i) == '.') {
				temp += s.charAt(i);
				list.add(temp.trim());
				temp = "";
			} else {
				temp += s.charAt(i);
			}
		}
//		list.add(temp);
//		System.out.println(list);
		for (String q : list) {
			if (q.length() < 8 || q.charAt(q.length() - 1) != '?') {
				continue;
			}
			sb.append("Forty-two");
			sb.append(q.substring(4, q.length() - 1));
			sb.append(".");
			sb.append("\n");
//			sb.append(q.substring(,1));
		}
		System.out.println(sb);
	}

}
