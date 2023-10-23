import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		Map<Character, Integer> hash = new HashMap<>();
		
		int max = 0;
		int left = 0;
		int right = 0;
		while(left <= right && right < S.length()) {
			char start = S.charAt(left);
			char end = S.charAt(right);
			
			// 개수 남았거나 인식 가능한 문자면 +1
			if(hash.size() < N || hash.containsKey(end)) {
				hash.put(end, hash.getOrDefault(end, 0)+1);
				right++;
			}
			// 새로운 문자인데 개수가 찼을 때
			else if(hash.size() == N) {
				// 시작 문자열이 여러개면 개수 -1
				if(hash.get(start) > 1) 
					hash.put(start, hash.get(start)-1);
				// 시작 문자열이 하나면 해시에서 삭제
				else 
					hash.remove(start);
				left++;
			}
			
			int sum = 0;
			for(char c : hash.keySet()) {
				sum += hash.get(c);
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

}
