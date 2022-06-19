import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String original=br.readLine();
		String explode=br.readLine();
		int len=explode.length();
		int cnt=0;
		ArrayList<Character> li=new ArrayList<>();
		for (int i=0; i<original.length(); i++) {
			li.add(original.charAt(i));
			cnt++;
			if (li.get(li.size()-1)==explode.charAt(len-1) && li.size()>=len) {
				int idx=li.size()-1;
				int eidx=len-1;
				boolean flag=false;
				for (int j=0; j<len; j++) {
					if (li.get(idx-j)!=explode.charAt(eidx-j)) {
						flag=true;
						break;
					}
				}
				if (!flag) {		//일치하는 경우 빼주기
					for (int j=0; j<len; j++) {
						li.remove(li.size()-1);
						cnt--;
					}
				}
			}
		}
		if (li.size()==0) {
			System.out.println("FRULA");
		}
		else {
			StringBuilder sb=new StringBuilder();
			for (int i=0; i<cnt; i++) {
				sb.append(li.get(i));
			}
			System.out.println(new String(sb));
		}
		

	}

}
