import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] == 1) list.add(i); // 1의 인덱스들을 리스트에 저장한다.
		}
		
		if(list.size() < K) {
			System.out.println(-1);
			return;
		}
		
		// 순서대로 나열되어 있는 K개의 1중에서 양끝의 거리가 최소인 것을 구한다.
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<=list.size()-K; i++) {
			ans = Math.min(ans, list.get(i+K-1)-list.get(i)+1);
		}
		System.out.println(ans);
	}

}
