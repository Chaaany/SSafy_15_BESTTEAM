import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] map = new int[N];
		ArrayList<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
			if(map[i] == 1) 
				list.add(i);
		}
				
		if(list.size() < K)
			System.out.println(-1);
		else if(list.size() == K) {
			System.out.println(list.get(list.size()) - list.get(0) + 1);
		}
		else {
			int min = Integer.MAX_VALUE;
			int left = 0;
			int right = K-1;
			while(true) {
				if(right >= list.size()) break;
				int size = list.get(right) - list.get(left) + 1;
				min = Math.min(min, size);
				left++;
				right++;
			}
			System.out.println(min);
		}
	}


}
