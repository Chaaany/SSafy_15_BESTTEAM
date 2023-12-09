import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int[] weight;
    static boolean[] v;
    static boolean[] sosu = new boolean[9001];
    static int N, M;
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        sosu[1] = true;
        for (int i = 2; i < 4500; i++) {
            if (!sosu[i]) {
                for (int j = i + i; j < 9001; j += i) {
                    sosu[j] = true;
                }
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        weight = new int[N];
        v = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        find(0, 0, 0);
        if (ans.size() == 0) {
            System.out.println(-1);
            return;
        }
        ans.sort(null);
        TreeSet<Integer> set = new TreeSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            set.add(i);
        }
        for (int i : set) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }

    private static void find(int start, int cnt, int sum) {
        if (cnt == M) {
            if (!sosu[sum]) {
                ans.add(sum);
            }
            return;
        }
        for (int i = start; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                find(i + 1, cnt + 1, sum + weight[i]);
                v[i] = false;
            }
        }

    }

}
