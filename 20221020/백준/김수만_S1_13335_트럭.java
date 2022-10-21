import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int truck[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			truck[i] = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> bridge = new LinkedList<>();
		for(int i=0; i<w; i++) 
			bridge.add(0);
		int sum = 0; // 다리 위의 트럭 무게
		int ans = 0, i = 0;
		while(!bridge.isEmpty()) {
			ans++;
			sum -= bridge.poll();
			
			if(i < n) {
				if(sum + truck[i] > L) {
					bridge.add(0);
				}
				else {
					sum += truck[i];
					bridge.add(truck[i++]);
				}
			}
		}
		System.out.println(ans);
	}

}
