import java.io.*;
import java.util.*;

public class BJ_3078_좋은친구 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] len = new int[N];
		// 길이, 개수
		HashMap<Integer, Integer> map = new HashMap<>();
		long answer = 0;
		
		for (int i = 0; i < N; i++) {
			len[i] = br.readLine().trim().length();
			map.put(len[i], map.getOrDefault(len[i], 0)+1);
			
			// K넘는 친구 list에서 삭제
			if(i>=K+1) {
				int key = len[i-K-1];
				map.put(key, map.get(key)-1);
				if(map.get(key)==0) map.remove(key);
			}
			// 자기 포함 쌍 찾기
			answer += map.get(len[i])-1;
		}
		
		System.out.println(answer);
	}

}
