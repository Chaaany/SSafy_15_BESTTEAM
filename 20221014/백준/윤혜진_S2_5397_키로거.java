import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		int N = Integer.parseInt(br.readLine());
		LinkedList<Character> list = new LinkedList<>();
        
		for (int i = 0; i < N; i++) {
			ListIterator<Character> iter = list.listIterator();
			String pwd = br.readLine();
						
			for (int j = 0; j < pwd.length(); j++) {				
				char cur = pwd.charAt(j);
				
				if(cur =='<') {
					if(iter.hasPrevious()) {
						iter.previous();
					}
				}
				else if(cur =='>') {
					if(iter.hasNext()) {
						iter.next();
					}
				}
				else if(cur =='-') {
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
				}
				else {
					iter.add(cur);
				}
			}
			
			sb = new StringBuilder();
			for (Character c: list) {
				sb.append(c);
			}
			
			System.out.println(sb);
            list.clear();
		}

	}

}
