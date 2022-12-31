import java.io.*;
import java.util.*;

public class BJ_4256_트리 {

	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			int [] preorder = new int[N];
			int[] inorder = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				preorder[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				inorder[i] = Integer.parseInt(st.nextToken());
			}
			
			buildTree(preorder, inorder);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void buildTree(int[] preorder, int[] inorder) {
		if(preorder.length>0) {
			int root = preorder[0];
			int mid = 0;
			for (int i = 0; i < inorder.length; i++) {
				if(inorder[i]==root) {
					mid = i;
					break;
				}
			}
			buildTree(Arrays.copyOfRange(preorder, 1, mid+1), Arrays.copyOfRange(inorder, 0, mid));
			buildTree(Arrays.copyOfRange(preorder, mid+1, preorder.length),Arrays.copyOfRange(inorder, mid+1, inorder.length));
			sb.append(root+" ");
		}
	}

}
