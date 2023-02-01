import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Tree root = new Tree("");
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			Tree parent = root;
			for (int j = 0; j < K; j++) {
				String temp = st.nextToken();
				boolean check = false;
				for (Tree next : parent.child) {
					if (next.data.equals(temp)) {
						parent = next;
						check = true;
						break;
					}
				}
				if (!check) {
					Tree newTree = new Tree(temp);
					parent.child.add(newTree);
					parent = newTree;
				}
			}
		}
		find(root, 0);
		System.out.println(sb);
	}

	private static void find(Tree tree, int depth) {
		Collections.sort(tree.child);
		for (Tree child : tree.child) {
			for (int j = 0; j < depth; j++) {
				sb.append("--");
			}
			sb.append(child.data).append("\n");
			find(child, depth + 1);
		}

	}

	public static class Tree implements Comparable<Tree> {
		String data;
		ArrayList<Tree> child;

		Tree(String data) {
			this.data = data;
			child = new ArrayList<>();
		}

		@Override
		public int compareTo(Tree t) {
			return this.data.compareTo(t.data);
		}
	}

}
