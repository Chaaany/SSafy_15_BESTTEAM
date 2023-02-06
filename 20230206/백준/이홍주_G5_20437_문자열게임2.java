import java.io.*;
import java.util.*;

public class BJ_20437_문자열게임2 {
	static int K, min, max;
	static String str;
	static ArrayList<ArrayList<Integer>> alpha;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			str = br.readLine().trim();
			K = Integer.parseInt(br.readLine());
			
			min = Integer.MAX_VALUE;
			max = 0;
			
			alpha = new ArrayList<>();
			for (int i = 0; i < 26; i++) {
				alpha.add(new ArrayList<>());
			}
			
			for (int i = 0; i < str.length(); i++) {
				char cs = str.charAt(i);
				alpha.get(cs-'a').add(i);
			}
			
			for (int i = 0; i < alpha.size(); i++) {
				int size = alpha.get(i).size();
				if(size>=K) {
					ArrayList<Integer> list = alpha.get(i);
					for (int j = 0; j+K-1 < size; j++) {
						int diff = list.get(j+K-1)-list.get(j)+1;
						min = Math.min(min, diff);
						max = Math.max(max, diff);
					}
				}
			}
			
			sb.append(min == Integer.MAX_VALUE && max == 0 ? (-1):(min+" "+max));
			sb.append("\n");			
		}
		System.out.print(sb.toString());
	}
}
