import java.util.Scanner;

public class BJ_1193_분수찾기 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int X = in.nextInt();
		
		int sum = 0;
		int num = 1;
		while(true) {
			sum += num;
			if(sum >= X) {
				sum -= num;
				break;
			}
			num++;
		}
		
		// 위에서부터
		int idx = 0;
		if(num%2==0) idx = X-sum;
		// 왼쪽부터
		else idx = num - (X-sum)+1;
		
		System.out.println(idx+"/"+((num+1)-idx));
	}

}
