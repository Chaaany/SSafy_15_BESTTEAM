package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_1715 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		int sum = 0;
		int temp = 0;
		while(pq.size()!= 1) {
			temp = pq.poll() + pq.poll();
			sum += temp;
			pq.add(temp);
		}
		System.out.println(sum);
	}
}
