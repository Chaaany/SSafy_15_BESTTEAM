import java.io.*;
import java.util.*;

public class BJ_2143_두배열의합 {

	static int N, M;
	static long answer, T;
	static int[] A, B;
	static long[] sumA, sumB;
	static HashMap<Long, Long> mapA, mapB;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		N = Integer.parseInt(br.readLine());				
		A = new int[N+1];
		sumA = new long[N+1];
		st = new StringTokenizer(br.readLine());
		init(N, A,sumA, st);
				
		M = Integer.parseInt(br.readLine());
		B = new int[M+1];
		sumB = new long[M+1];
		st = new StringTokenizer(br.readLine());
		init(M, B,sumB, st);
			
		mapA = new HashMap<>();
		mapB = new HashMap<>();
		
		add(sumA, mapA);
		add(sumB, mapB);
		
		answer = 0;		
		mapA.forEach((k,v)->{
			if(mapB.containsKey(T-k)) {
				answer +=  v*mapB.get(T-k);
			}
		});
				
		System.out.println(answer);
	}

	private static void init(int len, int[] arr, long[] sum, StringTokenizer st) throws IOException {
		for (int i = 1; i <= len; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + arr[i];
		}
	}

	private static void add(long[] sum, HashMap<Long, Long> map) {
		for (int i = 1; i < sum.length; i++) {
			for (int j = i; j < sum.length; j++) {
				long key = sum[j]-sum[i-1];
				//** long 처리 해줘야 함
				map.put(key, map.getOrDefault(key, (long) 0)+1);
			}
		}
	}
	
}
