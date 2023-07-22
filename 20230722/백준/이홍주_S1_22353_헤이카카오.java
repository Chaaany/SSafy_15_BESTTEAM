import java.io.*;
import java.util.*;

public class BJ_22353_헤이카카오 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double a = Integer.parseInt(st.nextToken()); // 분
		double d = Integer.parseInt(st.nextToken()); // 첫 확률
		double k = Integer.parseInt(st.nextToken()); // 증가 확률
		
		d/=100;
		k/=100;
		
		double answer = 0; // 시간 기댓값
		double lose = 1; // 이전 판 모두 졌을 확률
		int count = 1; // 판수
		
		
		while(true) {
			answer += count * a * lose * d; // 판수 * 한판당 시간 * 이전판 모두졌을 확률 * 이번판 이길 확률
			
			count++; // 판 수 증가
			
			if(d==1) break;
			
			lose  = lose * (1-d); // 이전판 모두 진 확률
			d += d*k; // 현재 판 이길 확률
			
			if(d>=1) d = 1;
			
		}
		
		System.out.println(answer);
		
	}

}
