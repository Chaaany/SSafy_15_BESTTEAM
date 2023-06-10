import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static double[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new double[N+1][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		arr[N][0] = arr[0][0];
		arr[N][1] = arr[0][1];
		double sum_x = 0.0;
		double sum_y = 0.0;
		
		for (int i = 0; i < N; i++) {
			sum_x += arr[i][0] * arr[i+1][1];
			sum_y += arr[i+1][0] * arr[i][1];
		}
		
	
		System.out.printf("%.1f",Math.abs(sum_x-sum_y)/2.0);
	}

}
