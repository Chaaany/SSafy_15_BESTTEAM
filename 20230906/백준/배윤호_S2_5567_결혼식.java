import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] friends = new ArrayList[n + 1];
        boolean[] v = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            friends[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        v[1] = true;
        int index = 0;
        int ans = 0;
        while (!que.isEmpty()) {
            if (index == 2)
                break;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int cur = que.poll();
                for (int j = 0; j < friends[cur].size(); j++) {
                    int curFriend = friends[cur].get(j);
                    if (v[curFriend])
                        continue;
                    ans++;
                    que.add(curFriend);
                    v[curFriend] = true;
                }
            }
            index++;
        }
        System.out.println(ans);

    }

}
