import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] fib = new int[D+3];
		fib[0] = 0;
		fib[1] = 1;
		for(int i=2; i<D+3; i++) 
			fib[i] = fib[i-1] + fib[i-2];
		
		for(int A=1; A<=K; A++) {
			for(int B=A; B<=K; B++) {
				if(A*fib[D-2]+B*fib[D-1] == K) {
					System.out.println(A);
					System.out.println(B);
					return;
				}
			}
		}
	}

}
