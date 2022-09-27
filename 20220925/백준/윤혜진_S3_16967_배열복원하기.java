import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H, W, X, Y;
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		int[][] arrB = new int[H+X][W+Y];
		int[][] arrA = new int[H][W];
		
		for (int i = 0; i < H+X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W+Y; j++) {
				arrB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < H+X; i++) {
			for (int j = 0; j < W+Y; j++) {
				if(i<H && j<W) {
					if(i>=X && j>=Y)
						arrA[i][j] = arrB[i][j] - arrA[i-X][j-Y];
					else
						arrA[i][j] = arrB[i][j];
				}
				else
					if(i>=X && j>=Y)
						arrA[i-X][j-Y] = arrB[i][j];
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(arrA[i][j]+" ");
			}
			System.out.println();
		}

	}

}
