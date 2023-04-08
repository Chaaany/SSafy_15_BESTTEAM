import java.io.*;

public class BJ_1300_k번째수 {
	
	static int N,K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		int start = 1;
		int end = K;
		int answer = 0;
		
		while(start<=end){
			int mid = (start+end)/2;
			int sum = 0;
			
			// 구구단 중에서 mid보다 작거나 같은 수의 개수 count
			for (int i = 1; i <= N; i++) {
				sum += Math.min(N, mid/i);
			}
			
			// 개수가 K보다 많으면 답일 가능성이 있다
			if(sum>=K) {
				answer = mid;
				end = mid-1;
			}else start = mid+1;
		}
		System.out.println(answer);
	}
	
}
