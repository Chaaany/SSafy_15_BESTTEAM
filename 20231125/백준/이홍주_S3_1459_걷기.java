import java.io.*;
import java.util.*;

public class BJ_1459_걷기 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long W = Long.parseLong(st.nextToken());
		long S = Long.parseLong(st.nextToken());
		
		long answer = 0;
		
		if(W*2 < S) {
			// 그냥 가는게 빠름
			answer = (X+Y)*W;
		}else {
			// 대각선이 빠름
			long min = Long.MAX_VALUE;
			
			if(X>Y) min = Y;
			else min = X;
			
			long tmp1 = 0;
			long tmp2 = 0;
			
			tmp1 = min*S;
			tmp1 += (X-min + Y-min)*W;
			
			tmp2 = min*S;
			X -= min;
			Y -= min;
			
			if(X==0 && Y%2==0) {
				tmp2 += Y*S;
			}else if(Y==0 && X%2==0) {
				tmp2 += X*S;
			}else if(X==0 && Y%2==1) {
				tmp2 += (Y-1)*S + W;
			}else if(Y==0 && X%2==1) {
				tmp2 += (X-1)*S + W;
			}
			
			
			answer = Math.min(tmp2, tmp1);
		}
		
		System.out.println(answer);
	}


}
