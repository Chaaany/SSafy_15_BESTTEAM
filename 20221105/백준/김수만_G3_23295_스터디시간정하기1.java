import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int time[] = new int[100000];
		int maxT = 0;
		for(int i=0; i<N; i++) {
			int K = Integer.parseInt(br.readLine());
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
				if(j == K-1)
					maxT = Math.max(maxT, e);
				for(int k=s; k<e; k++)
					time[k]++;
			}
		}
		
		int l = 0, r = T;
		int sum = 0;
		for(int i=0; i<T; i++)
			sum += time[i];
		int ans = sum;
		int al = l;
		while(r < maxT) {
			sum -= time[l];
			sum += time[r];
			l++;
			r++;
			if(ans < sum) {
				ans = sum;
				al = l;
			}
		}
		
		System.out.println(al+" "+(al+T));
	}

}
