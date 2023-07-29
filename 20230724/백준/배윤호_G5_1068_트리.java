import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;
    static ArrayList<Integer>[] sons;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // int[] parents = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        sons = new ArrayList[N];
        Map<Integer, Integer> map = new HashMap<>(); // KEY = 자식 , VALUE = 부모
        for (int i = 0; i < N; i++) {
            sons[i] = new ArrayList<Integer>();
        }
        int root = 0;
        for (int i = 0; i < N; i++) {
            int node = Integer.parseInt(st.nextToken());
            if (node == -1) {
                root = i;
                continue;
            }
            sons[node].add(i);
            map.put(i, node);
        }
        int D = Integer.parseInt(br.readLine()); // 삭제할 노드
        if (D == root) {
            System.out.println(0);
            return;
        }
        sons[map.get(D)].remove(Integer.valueOf(D));

        find(root);
        System.out.println(ans);
    }

    private static void find(int root) {
        if (sons[root].size() == 0) {
            ans++;
            return;
        }
        for (int i = 0; i < sons[root].size(); i++) {
            find(sons[root].get(i));
        }
    }

}
