import java.util.Scanner;

public class BJ_2520_떡먹는호랑이 {

	public static int first, second;
	public static boolean fin;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int D = in.nextInt();
		int K = in.nextInt();
		
		first = 0;
		second = 0;
		fin = false;
		int[] arr = new int[D];
		dfs(D,K,1,1,arr,0);
		
		System.out.println(first);
		System.out.println(second);
	}

	private static void dfs(int maxDay, int maxTtok, int nowDay, int start, int[] arr, int cnt) {
		if(cnt==2) {			 
			arr[2] = arr[0]+arr[1];
			for (int i = 3; i < maxDay; i++) {
				arr[i] = arr[i-1]+arr[i-2];
			}
			if(arr[arr.length-1]==maxTtok) {
				first = arr[0];
				second = arr[1];
				fin = true;
			}
			return;
		}
		for (int i = start; i <= maxTtok; i++) {
			if(fin) return;
			arr[cnt]  = i;
			dfs(maxDay,maxTtok,nowDay+1,i,arr, cnt+1);
		}
	}

}
