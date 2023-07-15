import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num = new int[4];
		int clock = Integer.MAX_VALUE;  // 시계수
		
		for (int i = 0; i < 4; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		clock = findClock(num);
		
		int cnt = 1;
		for (int i = 1111; i < clock; i++) {			
			String n = Integer.toString(i);
			if(n.contains("0")) continue;
			
			int[] sort = new int[4];
			for (int j = 0; j < 4; j++) {
				sort[j] = Character.getNumericValue(n.charAt(j));
			}
			
			if(findClock(sort) == i) cnt++;
		}
		
		System.out.println(cnt);
	}

	private static int findClock(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			String s = "";
			for (int j = i; j < i+4; j++) {
				int idx = j%4;
				s += arr[idx];
			}
			min = Math.min(min, Integer.parseInt(s));
		}
		return min;
	}
	
}
