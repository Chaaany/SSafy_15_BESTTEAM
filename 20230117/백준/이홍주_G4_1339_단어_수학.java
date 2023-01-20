import java.io.*;
import java.util.*;

public class BJ_1339_단어수학 {

	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 알파벳당 자리수 계산
		int[] arr = new int[26];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < str.length() ; j++) {
				arr[str.charAt(j)-'A'] += Math.pow(10, str.length()-j-1);
			}
		}
		Arrays.sort(arr);
		long answer = 0;
		// 높은 자리에 있는 알파벳 수가 많은 수대로 정렬 후 9부터 부여
		int count = 9;
		for (int i = arr.length-1; i >=0 ; i--) {
			if(arr[i]==0) break;
			answer += arr[i]*count--;
		}
		
		
		System.out.println(answer);
	}
}
