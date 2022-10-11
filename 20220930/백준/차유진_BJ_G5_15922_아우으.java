import java.util.Scanner;

public class Main_15922 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long x,y;
		long total = 0;
		long last = -1000000001;
		for (int i = 0; i < N; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			if (x >= last) {
				total += y-x;
			} else if(x<last && y>=last){
				total += y-last;
			}
			last = Math.max(last, y);
		}
		System.out.println(total);
		sc.close();
	}

}
