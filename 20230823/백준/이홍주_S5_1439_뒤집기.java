import java.io.*;
import java.util.*;

public class BJ_1489_뒤집기 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		boolean zero = false;
		int zero_cnt=0;
		int one_cnt=0;
		
		if(s.charAt(0)=='0') {
			zero= true;
			zero_cnt++;
		}else one_cnt++;
		
		
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i)=='0' && !zero) {
				zero = true;
				zero_cnt++;
			}else if(s.charAt(i)=='1' && zero) {
				zero = false;
				one_cnt++;
			}
		}
		
		System.out.println(Math.min(zero_cnt,one_cnt));
	}


}
