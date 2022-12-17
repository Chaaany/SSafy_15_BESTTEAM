import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1083_소트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer stz = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stz.nextToken());
		}
		int S = Integer.parseInt(br.readLine());
		for(int i = 0; i < S; i++) {
			arr = sort(arr, N);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(arr[i]+" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static int[] sort(int[] arr, int n) {
		for(int i = 0; i < n-1; i++) {
			if(arr[i] < arr[i+1]) {
				int t = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = t;
				break;
			}
		}
		return arr;
		
	}

}
