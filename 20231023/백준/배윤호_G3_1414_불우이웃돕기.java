import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // int[][] connect = new int[N][N];
        boolean[] v = new boolean[N];
        int total = 0;
        ArrayList<Node>[] connect = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            connect[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                int num = 0;
                if (s.charAt(j) >= 'a' && s.charAt(j) <= 'z') {
                    num = s.charAt(j) - 96;
                } else if (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') {
                    num = s.charAt(j) - 38;
                } else
                    continue;
                connect[i].add(new Node(j, num));
                connect[j].add(new Node(i, num));
                total += num;
            }
        }
        int count = 0; // 선택한 길의 수 (N-1 이어야 모든 전선 연결)
        int sum = 0; // 선택한 길의 전선 합
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.line, n2.line));
        count++;
        for (int i = 0; i < connect[0].size(); i++) {
            pq.add(connect[0].get(i));
        }
        v[0] = true;
        while (!pq.isEmpty()) {
            Node next = pq.poll();
            if (v[next.index])
                continue;
            sum += next.line;
            v[next.index] = true;
            count++;
            if (count == N)
                break;
            for (int i = 0; i < connect[next.index].size(); i++) {
                pq.add(connect[next.index].get(i));
            }

        }
        int answer = total - sum;
        if (count < N) {
            answer = -1;
        }
        System.out.println(answer);
    }

    static class Node {
        int index;
        int line;

        Node(int index, int line) {
            this.index = index;
            this.line = line;
        }
    }

}
