import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] p;
    static Set<String> set = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        p = new int[M];
        perm(0);
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next().replace(",", " ")).append("\n");
        }
        System.out.println(sb);

    }

    private static void perm(int count) {
        if (count == M) {
            String s = "";
            for (int i : p) {
                s += i;
                s += ',';
            }
            s = s.substring(0, s.length() - 1);
            set.add(s);
            return;
        }
        for (int i = 0; i < N; i++) {
            p[count] = arr[i];
            perm(count + 1);
        }

    }

}
