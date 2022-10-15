import java.io.*;
import java.util.*;

public class BJ_5397_키로거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String str = br.readLine().trim();
			LinkedList<Character> lnkList = new LinkedList<>();
			ListIterator<Character> list = lnkList.listIterator();
			
			for (int i = 0; i < str.length(); i++) {
				char cs = str.charAt(i);
				if(cs=='-') {
					if(list.hasPrevious()) {
						list.previous();
						list.remove();
					}
				}else if(cs=='<') {
					if(list.hasPrevious()) list.previous();
				}else if(cs=='>') {
					if(list.hasNext()) list.next();
				}else {
					list.add(cs);
				}
			}
			StringBuilder sb = new StringBuilder();
			for(char cs : lnkList) {
				sb.append(cs);
			}
			System.out.println(sb.toString());
		}
	}

}
