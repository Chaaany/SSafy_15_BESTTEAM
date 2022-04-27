import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    
    	static class Node {
		int index, cost;

		Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
	}

    public int solution(int n, int[][] edge) {
		int answer = 0;
		int E = edge.length;
		int max = 0;
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<Node>());
		}
		for (int i = 0; i < E; i++) {
			int s = edge[i][0];
			int e = edge[i][1];
			int c = 1;
			graph.get(s).add(new Node(e, c));
			graph.get(e).add(new Node(s, c));
		}

		int[] dist = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.offer(new Node(1, 0));
		dist[1] = 0;
		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			if (dist[curNode.index] < curNode.cost) {
				continue;
			}

			for (int i = 0; i < graph.get(curNode.index).size(); i++) {
				Node nextNode = graph.get(curNode.index).get(i);
				if(dist[nextNode.index] > curNode.cost+nextNode.cost) {
					dist[nextNode.index] = curNode.cost+nextNode.cost;
					pq.offer(new Node(nextNode.index, dist[nextNode.index]));
				}
			}
		}
		Arrays.sort(dist);
		max=dist[n-1];
		answer++;
		for (int i = n-2; i >=1; i--) {
			if(dist[i]!=max) break;
			answer++;
		}
		System.out.println(answer);

		return answer;
}
}
