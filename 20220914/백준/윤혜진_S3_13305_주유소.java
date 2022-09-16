import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long[] road, price;
	static long cost = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());  //도시 개수
		road = new long[N-1];  //길
		price = new long[N];  //도시
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			road[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Long.parseLong(st.nextToken());
		}
		
		for (int i = 0; i < N;) {
			int minIdx = minPrice(i);
			if(i == minIdx) {  // 현재가 최저가일 경우
				long km = 0;
				for (int j = i; j < road.length; j++) {
					km += road[j];
				}
				cost += km*price[i];
				break;
			}
			else {
				long km = 0;
				int idx = low(i);  // 현재보다  낮은 인덱스 찾기
				for (int j = i; j < idx; j++) {
					km += road[j];
				}
				cost += km*price[i];
				
				i = idx;
			}
		}
		
		System.out.println(cost);

	}

	private static int low(int n) {
		for (int i = 0; i < N; i++) {
			if(price[n] > price[i])
				return i;
		}
		return -1;
		
	}

	private static int minPrice(int n) {
		long min = 987654321;
		int index = -1;
		
		for (int i = n; i < N; i++) {
			if(min > price[i]) {
				min = price[i];
				index = i;
			}
		}
		
		return index;
		
	}

}
