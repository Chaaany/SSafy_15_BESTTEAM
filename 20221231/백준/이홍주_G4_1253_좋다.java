import java.io.*;
import java.util.*;

public class BJ_1253_좋다 {

	// 투포인터
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
				
		int count = 0;
		// 최소 3개는 되어야 답이 나온다
		if(arr.length<=2) {
			System.out.println(count);
			return;
		}else {
			// 투포인터를 위한 정렬
			Arrays.sort(arr);
			
			// 배열을 돌면서 해당 숫자(arr[i])가 다른 두 수의 합인지 판별하는 반복문
			for (int i = 0; i < N; i++) {
				// 양 끝단에서 start_idx는 증가 end_idx는 감소하면서 투 포인터 시작
				int start_idx = 0;
				int end_idx = N-1;
				
				// 투포인터를 옮기다가 start_idx end_idx 순서가 반전되면 해당 값 arr[i]는 두 수의 합이 아님
				// start_idx와 end_idx 위치의 배열 값의 합을 증가, 감소 시키면서 arr[i]와 동일한지 판별
				while(start_idx<end_idx) {
					
					// 서로 다른 두수의 합으로 만들어져야 함으로 arr[i]와 idx가 겹치면 pass
					if(start_idx == i) { 
						start_idx++;
						continue;
					}
					
					// 이하동문
					if(end_idx == i) {
						end_idx--;
						continue;
					}
					
					// 두 수의 합이 배열에 존재하면 count 올리고 답을 찾았으니 break;
					if(arr[i] == arr[start_idx]+arr[end_idx]) {
						count++;
						break;
					}
					// 두 수의 합이 찾으려는 값(arr[i]) 보다 작다면 오름차순 정렬된 배열 기준으로 start_idx를 올려야 합이 커진다.
					else if(arr[i] > arr[start_idx]+arr[end_idx]) {
						start_idx++;
					// 반대로 찾으려는 값보다 크다면 end_idx를 내려야 합이 작아진다	
					}else { 
						end_idx--;
					}
					
				}
			}			
		}
		System.out.println(count);
	}

}
