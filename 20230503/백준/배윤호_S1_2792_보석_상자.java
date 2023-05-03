import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int[] gems = new int[M];
	    int left = 1;
	    int right =0;
	    int mid = 0;
	    int ans = 0;
	    for(int i=0; i<M; i++){
	        gems[i] = Integer.parseInt(br.readLine());
	        right = Math.max(right,gems[i]);
	    }
	    
	    while (left <= right) {
    		mid = (left + right) / 2;
    		int temp = 0; //나누어 줄 수 있는 아이들 수
    		for (int i = 0; i < M; i++) {
    			temp += gems[i] / mid;
    			if (gems[i] % mid != 0) {
    				temp++;
    			}
    		}
    		if (temp > N) { //나누어줄 수 있는 아이들 수가 실제 아이들보다 많으면
    			left = mid + 1;  // 더 많은 갯수로 나누어주어야 하므로 레프트 증가
    		}
    		else { // 못 받는 아이가 있어도 되므로 ans 갱신
    		    ans = mid;
    			right = mid - 1; // 더 작은 값이 있나 찾기 위해 right 감소
    		}
	    }
	    System.out.println(ans);
	}
}
