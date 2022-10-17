import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 더블 링크드리스트 구현
	static class Letter {
		boolean isHead;
		char c;
		Letter prev, next;

		Letter(boolean isHead, char c, Letter prev, Letter next) {
			this.isHead = isHead;
			this.c = c;
			this.prev = prev;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			String cmd = br.readLine();
			Letter cursor = new Letter(true, '0', null, null);
			Letter head = cursor;
			for (int i = 0; i < cmd.length(); i++) {
				char c = cmd.charAt(i);
				if (c == '<') {
					if (cursor.isHead) continue;
					cursor = cursor.prev;
				} else if (c == '>') {
					if (cursor.next == null) continue;
					cursor = cursor.next;
				} else if (c == '-') {
					if (cursor.isHead) continue;
					cursor.prev.next = cursor.next;
					if(cursor.next != null)
						cursor.next.prev = cursor.prev;
					cursor = cursor.prev;
				} else {
					Letter letter = new Letter(false, c, null, null);
					if (cursor.next == null) {
						letter.prev = cursor;
						cursor.next = letter;
					} else {
						letter.prev = cursor;
						letter.next = cursor.next;
						cursor.next.prev = letter;
						cursor.next = letter;
					}
					cursor = letter;
				}
			}
			
			while(head.next != null) {
				sb.append(head.next.c);
				head = head.next;
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}
