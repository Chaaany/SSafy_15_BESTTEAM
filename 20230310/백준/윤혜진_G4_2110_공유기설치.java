import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] houses = new int[N];
		
		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(houses);
		
		int maxDistance = 0;
		int min = 1;
		int max = houses[N-1] - houses[0];
		while(min <= max) {
			// 공유기 간 최소 거리!!
			int mid = (min + max) / 2;
			
			int count = 1; // 첫번째는 무조건 설치함
			int prevIdx = 0; // 가장 최근에 설치한 공유기 인덱스
			for (int i = 1; i < N; i++) {
				if(houses[i]-houses[prevIdx] >= mid) {
					count++;
					prevIdx = i;
				}
			}
			
			if(count >= C) {
				maxDistance = Math.max(maxDistance, mid);
				min = mid + 1;  // 최소거리 늘려야 함
			}
			else max = mid - 1;  // 최소거리 줄여야 함	
			
		}
		
		System.out.println(maxDistance);
		
	}

}
