import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2110_RouterInstall {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] house = new int[N];
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		// 공유기 사이의 최대 거리 범위 min~max
		int min = 1;
		int max = house[N - 1] - house[0];
		int result = 0;

		while (min <= max) {
			int mid = (min + max) / 2; // 중간 값부터 시작해서 찾아가기
			int left = house[0];
			int cnt = 1;// 공유기 갯수 첫 번째 집에는 무조건 설치하고 시작
			for (int i = 1; i < N; i++) {
				if (house[i] - left >= mid) { // 간격이 mid 이상이면
					cnt++; // 공유기 설치
					left = house[i]; // 다음 간격을 찾기 위해 left 값 이동
				}
			}
			// 설치할 공유기보다 많이 설치했으면 더 큰 간격을 찾기 위해 오른쪽에서 탐색
			if (cnt >= C) {
				result = mid;
				min = mid + 1;
			}
			// 공유기보다 적게 설치했으면 간격을 줄여야 하므로 왼쪽에서 탐색
			else {
				max = mid - 1;
			}
		}

		System.out.println(result);
	}

}
