import java.io.*;
import java.util.*;

public class Main_13305 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] distance = new long[N-1];
		long[] gasPrice = new long[N];
		long total = 0;
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			distance[i] = Long.parseLong(stz.nextToken());
		}
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			gasPrice[i] = Long.parseLong(stz.nextToken());
		}
		
		int src = 0; 
		while(true) {
			int dest = N-1; // 그 뒤로 현재보다 저렴한 곳이 없으면 끝까지 가야지 뭐
			long gas = gasPrice[src]; // 현재 도시의 가격
			for (int i = src+1; i < N-1; i++) { // 가격이 현재 도시보다 저렴한 곳을 찾자
				if(gas > gasPrice[i]) {
					dest = i;
					break; // 여기보다 저렴한 곳을 찾으면 일단 거기까지 가자
				}
			}
			for(int i = src; i < dest; i++) {
				total += gas * distance[i];
			}
			if(dest == N-1) break;
			src = dest;
		}
		System.out.println(total);
	}

}
