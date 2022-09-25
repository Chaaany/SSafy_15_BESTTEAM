import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] A = new int[H][W];
		int[][] B = new int[H + X][W + Y];
		for (int i = 0; i < H + X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W + Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				A[i][j] = B[i + X][j + Y];
			}
		}

		for (int i = H - X - 1; i >= 0; i--) {
			for (int j = W - Y - 1; j >= 0; j--) {
				A[i][j] = B[i + X][j + Y] - B[i + X + X][j + Y + Y];
				B[i + X][j + Y] = B[i + X][j + Y] - B[i + X + X][j + Y + Y];
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}

	}

}
//사실 왜 맞는지 모르겠음
