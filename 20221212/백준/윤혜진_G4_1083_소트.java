import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int S = Integer.parseInt(br.readLine());
		int count = S;
		
		for (int i = 0; i < N; i++) {
			
			if(count <= 0 ) break;

			int cur = arr[i];
			
			int max = cur;
			int maxIdx = -1;
			for (int j = i + 1; j < N; j++) {
				if(j-i <= count && max < arr[j]) {
					max = arr[j];
					maxIdx = j;
				}
			}
			
			if(maxIdx==-1) continue;
			
			for (int j = maxIdx; j > i; j--) {
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			}
			
			count -= maxIdx-i;
			
		}
			
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i]+" ");			
		}
	}

}
