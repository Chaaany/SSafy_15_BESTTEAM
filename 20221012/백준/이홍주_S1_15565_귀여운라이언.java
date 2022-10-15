import java.io.*;
import java.util.*;

public class BJ_15565_라이언 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st=  new StringTokenizer(br.readLine());
		int count=0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x==1) {
				count++;
				list.add(i);			
			}
		}
		if(count<K) {
			System.out.println("-1");
			return;
		}
		int min  = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if(i+K-1>=list.size())break;
			int diff = list.get(i+K-1) - list.get(i)+1;
			min = Math.min(min, diff);
		}
		System.out.println(min);
	}

}
