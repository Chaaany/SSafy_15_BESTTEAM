import java.io.*;
import java.util.*;

public class BJ_15989_123더하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// 총개수, 1포함, 1미포함 & 2포함, 3만 있음
		int[][] number = new int[10001][4];
		number[1][1] = 1;
		number[2][1] = 1;
		number[3][1] = 2;
		
		number[1][2] = 0;
		number[2][2] = 1;
		number[3][2] = 0;
		
		number[1][3] = 0;
		number[2][3] = 0;
		number[3][3] = 1;
		
		for (int i = 1; i <= 3; i++) {
			number[i][0] = number[i][1] + number[i][2] + number[i][3];
		}
		
		for (int i = 4; i < number.length; i++) {
			// 뒤에 1만 추가하면 됨
			number[i][1] = number[i-1][1] + number[i-1][2] + number[i-1][3];
			number[i][2] = number[i-2][2] + number[i-2][3];
			number[i][3] = number[i-3][3];
			number[i][0] = number[i][1] + number[i][2] + number[i][3];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());			
			sb.append(number[N][0]+"\n");
		}
		
		System.out.print(sb.toString());
	}
	
}
