import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] preOrder, inOrder;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			preOrder = new int[N];
			inOrder = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				preOrder[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				inOrder[i] = Integer.parseInt(st.nextToken());
			}
			
			postOrder(0, N, 0);
			
			sb.setLength(sb.length()-1);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

	private static void postOrder(int start, int end, int preIdx) {
		for (int i = start; i < end; i++) {
			if(preOrder[preIdx] == inOrder[i]) {
				// 왼
				postOrder(start, i, preIdx+1);
				
				// 오
				int count = 0;
				for (int j = start; j < i; j++) {
					count++;
				}
				
				// 자신
				postOrder(i+1, end, preIdx+1+count);
				
				sb.append(inOrder[i]+" ");
			}
		}
		
	}

}
