import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;  // 최대 길이
		int cnt = 0;  // 삭제한 개수
		int left = 0;  // 수열 시작 인덱스
		int right = 0;  // 현재 인덱스
		
		// 처음 짝수가 시작되는 인덱스
		for (int i = 0; i < N; i++) {
			if(arr[i]%2 == 0) {
				left = i;
				right = i;
				break;
			}
		}
		
		while(right<N && left<=right) {
			// 현재가 짝수일 때
			if(arr[right]%2 == 0) {
				right++;
                max = Math.max(max, right-left-cnt);
			}
			
			// 현재가 홀수일 때
			else {
				// 삭제 기회가 남아있으면 삭제하고 다음 인덱스 확인
				if(cnt<K) {
					cnt++;
					right++;
				}
				// 삭제 기회 없으면 left를 이동
				else {
					if(arr[left]%2 == 1) cnt--;
					left++;
				}
			}			
		}
		
		System.out.println(max);
	}

}
