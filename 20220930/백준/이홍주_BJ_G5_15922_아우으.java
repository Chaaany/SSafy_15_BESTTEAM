import java.io.*;
import java.util.*;

public class BJ_15922_아우으 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int first_number=0;
		int last_number = Integer.MIN_VALUE;
		long sum=0;
		for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken());
			 int y = Integer.parseInt(st.nextToken());
			 if(x>last_number) {
				 if(last_number != Integer.MIN_VALUE) sum += (last_number-first_number);
				 first_number = x;
			 }
			 if(i==N-1) {
				 sum += (Math.max(last_number, y)-first_number);
			 }else if(last_number<y) last_number = y;
		}
		
		System.out.println(sum);

	}

}
