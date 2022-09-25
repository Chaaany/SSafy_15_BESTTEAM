import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] A = new int[H][W];
		int[][] sum = new int[H+X][W+Y];
		
		for (int i = 0; i < H+X; i++) {
			 st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W+Y; j++) {
				sum[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < H+X; i++) {
			for (int j = 0; j < W+Y; j++) {
				if(i>=X && j>=Y && i<H && j<W) A[i][j] = sum[i][j] - A[i-X][j-Y];
				else if(i<H && j<W && sum[i][j]!=0) A[i][j] = sum[i][j];
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(j==W-1)System.out.print(A[i][j]);
				else System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
