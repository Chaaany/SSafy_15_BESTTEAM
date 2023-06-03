import java.io.*;
import java.util.*;

public class BJ_1485_정사각형 {

	static int cnt, tmp1, tmp2;
	static double num1, num2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int[][] arr = new int[4][2];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0]= Integer.parseInt(st.nextToken());
				arr[i][1]= Integer.parseInt(st.nextToken());
			}
			
			HashMap<Double, Integer> map = new HashMap<>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < i; j++) {
					double tmp = Math.sqrt(Math.pow(Math.abs(arr[i][0]-arr[j][0]), 2)+Math.pow(Math.abs(arr[i][1]-arr[j][1]), 2));
					map.put(tmp, map.getOrDefault(tmp, 0)+1);
				}
			}
			
			if(map.size()==2) {
				cnt = 0;
				tmp1 = 0;
				num1 = 0;
				tmp2 = 0;
				num2 = 0;
				map.forEach((k,v)->{
					if(cnt++==0) {
						tmp1 = v;
						num1 = k;
					}
					else {
						tmp2 = v;
						num2 = k;
					}
				});
				
				if(tmp1==2 && tmp2 == 4 && num2 < num1 || tmp1 == 4 && tmp2 == 2  && num2 > num1) sb.append("1\n");
				else sb.append("0\n");
				
			}else {
				sb.append("0\n");
			}
			
		}
		System.out.print(sb.toString());
		
	}
}
