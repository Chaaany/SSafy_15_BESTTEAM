import java.io.*;
import java.util.*;

public class BJ_14725_개미굴 {

	static int N;
	public static class Node implements Comparable<Node>{ 
		
		int idx;
		String now;
		ArrayList<Node> children;
		
		public Node(int idx, String now, ArrayList<Node> children) {
			super();
			this.idx = idx;
			this.now = now;
			this.children = children;
		}

		// 사전순 나열
		@Override
		public int compareTo(Node o1) {
			return this.now.compareTo(o1.now);
		}		
	}
	
	public static void makeTree(Node node, int idx, ArrayList<String> strList) {	
		String now = strList.get(idx);
		// 형제 노드가 될 후보들
		ArrayList<Node> children = node.children;
		
		for (int i = 0; i < children.size(); i++) {
			Node child = children.get(i);
			// 같은 level 상에서 같은 이름이 있으면 똑같은 노드 취급
			if(child.now.equals(now) && child.idx == idx) {
				if(idx<strList.size()-1) makeTree(child, idx+1, strList);
				return;
			}
		}
		
		// 같은 이름 없으면 단순하게 children에 추가
		ArrayList<Node> newList = new ArrayList<>();
		Node nowNode = new Node(idx, now, newList);
		children.add(nowNode);
		if(idx<strList.size()-1) makeTree(nowNode, idx+1, strList);
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	
		ArrayList<Node> newList = new ArrayList<>();
		Node root = new Node(0, null, newList);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			ArrayList<String> strList = new ArrayList<>();			
			int K = Integer.parseInt(st.nextToken());
			
			for (int k = 0; k < K; k++) {
				strList.add(st.nextToken().trim());
			}
			
			makeTree(root, 0, strList);
		}
		
		
		StringBuilder sb = new StringBuilder();
		// 출력
		go(root,sb);
		System.out.println(sb.toString());
	}


	private static void go(Node node, StringBuilder sb) {
		// 자식 노드들 사전순 정렬
		Collections.sort(node.children);
		for (int i = 0; i < node.children.size(); i++) {
			Node child = node.children.get(i);
			for (int j = 0; j < child.idx; j++) {
				sb.append("--");
			}
			
			sb.append(child.now+"\n");
			if(child.children.size()>0) go(child, sb);
		}
	}

}
