import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = -1;
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] parent = new int[n + 1];
		int[] parentA = new int[n + 1];
		int[] parentB = new int[n + 1];
		parentA[0] = a;
		parentB[0] = b;
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			parent[y] = x;
		}
		int indexA = 1;
		int indexB = 1;
		while (true) {
			if (parent[parentA[indexA - 1]] == 0)
				break;
			parentA[indexA] = parent[parentA[indexA - 1]];
			indexA++;
		}
		while (true) {
			if (parent[parentB[indexB - 1]] == 0)
				break;
			parentB[indexB] = parent[parentB[indexB - 1]];
			indexB++;
		}
//		System.out.println(Arrays.toString(parentA));
//		System.out.println(Arrays.toString(parentB));
//		System.out.println(indexA);
//		System.out.println(indexB);
		go: for (int i = 0; i < indexA; i++) {
			for (int j = 0; j < indexB; j++) {
				if (parentA[i] == parentB[j]) {
					answer = i + j;
					break go;
				}
			}
		}
		System.out.println(answer);
	}

}
