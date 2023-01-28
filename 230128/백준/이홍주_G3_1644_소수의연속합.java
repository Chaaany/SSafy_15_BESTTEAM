import java.io.*;
import java.util.*;

public class BJ_1644_소수의연속합 {

	static int N;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		boolean[] v = new boolean[N+1];
		// 소수를 구하는 방식
		for (int i = 2; i <= N; i++) {
			if(!v[i]) {
				v[i] = true;
				list.add(i);
				for (int j = 1; i*j <=N ; j++) {
					v[i*j] = true;
				}
			}
		}
		
		int size = list.size();
		int answer = 0;
		if(size>0) {
			int s = 0;
			int e = 0;
			int count = list.get(s);
			
			while(s<=e) {
				if(size==0 || e>=size || s>=size) break;
				
				if(count<=N || s==e) {
					if(count==N) answer++;				
					e++;
					if(e<size) count+=list.get(e);
				}else {
					if(s<size) count-=list.get(s++);
				}				
			}
			
		}
		System.out.println(answer);
	}

}
