import java.io.*;

public class BJ_1344_축구 {

	static boolean[] sosu;
	static double A,B;
	static int num = 19;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		nC3*p*3*(1-p)*15 => A 3 확률
		
		
		A = Integer.parseInt(br.readLine())*0.01;
		B = Integer.parseInt(br.readLine())*0.01;
		sosu = new boolean[num];
		
		for (int i = 2; i < num; i++) {
			sosu[i] = true;
		}
		
		for (int i = 2; i < num; i++) {
			for (int j = 2; j < num; j++) {
				if(i*j>=num) break;
				sosu[i*j] = false;
			}
		}
		
		double sumA = 0;
		double sumB = 0;
		
		for (int i = 0; i < num; i++) {
			if(sosu[i]) {
				sumA += (double) ncr(num-1,i) * Math.pow(A, i)* Math.pow(1-A,num-1-i);
				sumB += (double) ncr(num-1,i) * Math.pow(B, i)* Math.pow(1-B,num-1-i);
			}
		}
		
		
		System.out.println(sumA+sumB-sumA*sumB);
		
	}

	private static long ncr(int n, int r) {
		long up = 1;
		long down = 1;
		
		for (int i = n; i > n-r; i--) {
			up *= i;
			down *= (n-i+1);
		}
		return up/down;
	}

}
