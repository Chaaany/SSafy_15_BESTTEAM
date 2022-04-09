package prog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {
	public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<List<int[]>> li = new ArrayList<>();
        List<List<Integer>> distanceList = new ArrayList<>();
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i <= n; i++) { // 0번째 인덱스 더미
			li.add(new ArrayList<int[]>());
			distanceList.add(new ArrayList<Integer>());
		}
        
        for (int i = 0; i < edge.length; i++) {
			int from = edge[i][0];
			int to = edge[i][1];
			
			li.get(from).add(new int[] {to, 0});
			li.get(to).add(new int[] {from, 0});
        }
        
        boolean visited[] = new boolean[n+1];
        for (int i = 0; i < li.get(1).size(); i++) {
        	int to = li.get(1).get(i)[0];
        	int distance = li.get(1).get(i)[1]+1;
        	visited[to] = true;
			q.offer(new int[] {to, distance});
		}
        
        visited[1] = true;
        int max = -1;
        while(!q.isEmpty()) {
        	int[] temp = q.poll();
        	int from = temp[0];
        	int distance = temp[1]+1;
        	
        	for (int i = 0; i < li.get(from).size(); i++) {
				int to = li.get(from).get(i)[0];
				
				if(visited[to])continue;
				visited[to] = true;
				max = Math.max(max, distance);
				distanceList.get(distance).add(new Integer(to));
				q.add(new int[] {to, distance});
			}
        }
        
        answer = distanceList.get(max).size();
        
        return answer;
    }
	public static void main(String[] args) {
		가장먼노드 a = new 가장먼노드();
		
		
		System.out.println(a.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
	}
}
