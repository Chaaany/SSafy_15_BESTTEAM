package algo0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class baekjoon_1715_카드정렬하기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long res = 0;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++)
			pq.offer(Long.parseLong(br.readLine()));
		
		while(pq.size() > 1) {
			long v1 = pq.poll();
			long v2 = pq.poll();
			
			pq.offer(v1+v2);
			res += v1+v2;
		}
		System.out.println(res);
	}

}
