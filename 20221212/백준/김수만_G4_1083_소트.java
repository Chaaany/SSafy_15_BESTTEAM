import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		int S = Integer.parseInt(br.readLine());
		int idx = 0;
		while(S > 0) {
			if(idx >= N-1) break;
			int max = -1, maxIdx = idx+1;
			for(int i=idx+1; i<=Math.min(idx+S, N-1); i++) {
				if(list.get(i) > list.get(idx)) {
					if(max < list.get(i)) {
						max = list.get(i);
						maxIdx = i;
					}
				}
			}
			
			if(max != -1) {
				for(int i=maxIdx; i>idx; i--) {
					swap(i, i-1);
					S--;
				}
			}
			idx++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++) {
			if(i == list.size()-1) sb.append(list.get(i));
			else sb.append(list.get(i)+" ");
		}
		System.out.println(sb.toString());
	}
	

	static void swap(int a, int b) {
		int tmp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, tmp);
	}
}
