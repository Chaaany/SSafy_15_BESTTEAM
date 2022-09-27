import java.io.*;
import java.util.*;

public class BJ_1474_밑줄 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[N];
		int len = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().trim();
			len += arr[i].length();
		}
		int underbar = M-len;
		int maxUnder = 0;
		int maxUnderCount = 0;
		int minUnder = 0;
		int minUnderCount = 0;
		
		minUnder = underbar/(N-1);
		maxUnderCount = underbar % (N-1);
		maxUnder = minUnder + 1;
		minUnderCount = N-1 - maxUnderCount; 
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]);
		for (int i = 1; i < N; i++) {
			if(Character.isUpperCase(arr[i].charAt(0))) {
				if(minUnderCount>0) {
					for (int j = 0; j < minUnder; j++) {
						sb.append("_");
					}
					--minUnderCount;
				}else {
					for (int j = 0; j < maxUnder; j++) {
						sb.append("_");
					}
					--maxUnderCount;
				}
			}else {
				if(maxUnderCount>0) {
					for (int j = 0; j < maxUnder; j++) {
						sb.append("_");
					}
					--maxUnderCount;
				}else {
					for (int j = 0; j < minUnder; j++) {
						sb.append("_");
					}
					--minUnderCount;
				}
			}
			sb.append(arr[i]);
		}
		System.out.println(sb.toString());
	}

}
