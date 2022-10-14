import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		List<Character> list;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			list = new LinkedList<>();
			int cursor = 0;
			int length = 0;
			for (int j = 0; j < s.length(); j++) {
				char temp = s.charAt(j);
				if (temp == '<') {
					if (cursor > 0) {
						cursor--;
					}
				} else if (temp == '>') {
					if (length > cursor) {
						cursor++;
					}
				} else if (temp == '-') {
					if (cursor > 0) {
						list.remove(cursor - 1);
						cursor--;
						length--;
					}
				} else {
					list.add(cursor, temp);
					cursor++;
					length++;
				}

			}
			Iterator<Character> iterator = list.iterator();
			while (iterator.hasNext()) {
				sb.append(iterator.next());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
