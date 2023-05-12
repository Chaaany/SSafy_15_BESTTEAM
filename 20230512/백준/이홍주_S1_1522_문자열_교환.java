import java.io.*;
import java.util.*;

public class BJ_1522_문자열교환 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(str.charAt(i)=='a') count++;
		}
		
		int now = 0;
		for (int i = 0; i < count; i++) {
			if(str.charAt(i)=='b') now++;
		}
		
		
		int answer = now;
		
		for (int i = 0; i < N; i++) {
			if(str.charAt((i+count)%N)=='b' && str.charAt(i) == 'a') now++;
			else if(str.charAt((i+count)%N)=='a' && str.charAt(i) == 'b') now--;

			answer = Math.min(answer, now);
		}
		
		System.out.println(answer);
	}
	

}
