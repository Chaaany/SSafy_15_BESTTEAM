import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

public class Main_S2_5397_키로거 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			String log = br.readLine();
			int cur = 0;
			LinkedList<Character> pwd = new LinkedList<>();
			for (int j = 0; j < log.length(); j++) {
				char key = log.charAt(j);
				switch(key) {
				case '>':
					if(cur < pwd.size()) cur++;
					break;
				case '<':
					if(cur > 0) cur--;
					break;
				case '-':
					if(cur > 0) pwd.remove(--cur);
					break;
				default:
					pwd.add(cur, key);
					cur++;
				}
			}
			Iterator<Character> iterator = pwd.iterator();
			while(iterator.hasNext()) {
				sb.append(iterator.next());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
