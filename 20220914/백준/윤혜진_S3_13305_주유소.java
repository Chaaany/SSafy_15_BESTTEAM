import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());  //도시 개수
		long[] road = new long[N-1];  //길
		long[] price = new long[N];  //도시
		long cost = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			road[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Long.parseLong(st.nextToken());
		}
		
		for (int i = 0; i < N-1;) {
			long km = 0;
			int idx = N-1;
			for (int j = 0; j < N; j++) {
				if(price[i] > price[j]) {
					idx = j;
					break;
				}
			}
			for (int j = i; j < idx; j++) {
				km += road[j];
			}
			cost += km * price[i];
			i = idx;

		}

		System.out.println(cost);
	}

}
