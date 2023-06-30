import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int K = Integer.parseInt(br.readLine());
        boolean zzak = false; // 짝수 홀수
        if (K % 2 == 0) {
            zzak = true;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = "";
            int zero = 0;
            for (int j = 0; j < M; j++) {
                s += arr[i][j];
                if (arr[i][j] == '0') {
                    zero++;
                }
            }
            if (zzak) {
                if (zero % 2 != 0 || zero > K)
                    continue;
                if (map.get(s) == null) {
                    map.put(s, 1);
                } else {
                    map.put(s, map.get(s) + 1);
                }
            } else {
                if (zero % 2 == 0 || zero > K)
                    continue;
                if (map.get(s) == null) {
                    map.put(s, 1);
                } else {
                    map.put(s, map.get(s) + 1);
                }
            }
        }
        if (map.size() == 0) {
            System.out.println(0);
            return;
        }
        List<Map.Entry<String, Integer>> entries = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).collect(Collectors.toList());
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getValue());
            break;
        }
    }

}
