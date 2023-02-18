import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10986_RemainSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long[] remain = new long[M+1];
		int sum = 0;
		//구간합을 더한 뒤 M으로 나눈 나머지 값을 구해서 해당 인덱스의 값을 ++ 해줘서 해당 나머지를 남기는 구간의 갯수 구해놓기
		for (int i = 0; i < N; i++) {
			sum = (sum+ Integer.parseInt(st.nextToken()))%M;
			remain[sum]++;
		}
		long count = 0;
		//와 이걸 누가 발견한거냐 대체
		//만약 0번째까지 구간합이랑 4번째 구간합이랑 M으로 나눈 나머지가 같으면 1~4번째 까지 더한 값은 M으로 나누어 떨어짐
		//그 나머지만큼의 앞부분을 빼버리니까 M으로 나누어 떨어져 버리는거다
		//그리고 이런 구간들이 2개 이상 존재하면 그 구간들을 이어붙인것도 다 M으로 나누어 떨어진다.
		for(int i = 0; i < M ; i++) {
			if(remain[i] > 1) { // 같은 나머지를 가지는 구간합이 2개 이상이면
				count += remain[i] * (remain[i] - 1) / 2; //그 부분집합들로 이어 붙일 수 있는 구간합 배열들을 구하는 공식
			}
		}
		count += remain[0]; //0으로 나누어 떨어지는건 굳이 이어붙이지 않아도 따로 존재할 수 있으므로 더해준다.
		System.out.println(count);
		
	}

}
