import java.io.*;
import java.util.*;

public class Main_G5_5639_이진검색트리 {
	
	static class Node {
		Node left, right;
		int val;
		
		public Node(int val) {
			this.val = val;
		}
		
		public void addNode(int val) {
			if(this.val > val) { // 현 노드보다 작으면 왼쪽에 넣기
				if(this.left == null) {
					this.left = new Node(val);
				} else { // 왼쪽에 하위 트리가 있으면 재귀
					this.left.addNode(val);
				}
			} else { // 현 노드보다 크면 오른쪽에 넣기
				if(this.right == null) {
					this.right = new Node(val);
				} else { // 오른쪽에 하위 트리가 있으면 재귀
					this.right.addNode(val);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		while(true) {
			String input = br.readLine();
			if(input == null || input.equals("")) break;
			else {
				q.offer(Integer.parseInt(input));
			}
		}
		Node node = new Node(q.poll()); // 루트 노드 넣어주기
		while(!q.isEmpty()) {
			int newnode = q.poll();
			node.addNode(newnode);
		}
		
		printAnswer(node);
	
	}

	static void printAnswer(Node node) {
		
		if(node.left != null) {
			printAnswer(node.left);
			node.left = null;
		}
		if(node.right != null) {
			printAnswer(node.right);
			node.right = null;
		}
		System.out.println(node.val);
	}

}
