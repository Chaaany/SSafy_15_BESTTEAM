import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        List<price> nums = new ArrayList<>();
        List<number> nums2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            map.put(i, p);
            nums.add(new price(i, p));
            nums2.add(new number(i, p));
        }
        Collections.sort(nums);
        Collections.sort(nums2);
        int M = Integer.parseInt(br.readLine());

        String s = "";
        if (N == 1) {
            System.out.println(0);
            return;
        }
        if (nums.get(0).n == 0) {
            if (M - nums.get(1).p >= 0) {
                s += nums.get(1).n;
                M -= nums.get(1).p;
            } else {
                System.out.println(0);
                return;
            }
        }

        while (true) {
            if (M - nums.get(0).p >= 0) {
                s += nums.get(0).n;
                M -= nums.get(0).p;
            } else {
                break;
            }

        }
        int leng = s.length();
        for (int i = 0; i < leng; i++) {
            boolean can = false;
            int curP = map.get(s.charAt(i) - 48);
            for (int j = 0; j < nums2.size(); j++) {

                if (M + curP - nums2.get(j).p >= 0) {
                    M = M + curP - nums2.get(j).p;
                    s = s.substring(0, i) + nums2.get(j).n + s.substring(i + 1);
                    can = true;
                    break;
                }
            }
            // System.out.println(M);
            if (!can) {
                break;
            }
        }
        System.out.println(s);
    }

    public static class price implements Comparable<price> {
        int n;
        int p;

        price(int n, int p) {
            this.n = n;
            this.p = p;
        }

        @Override
        public int compareTo(price o) {
            if (this.p == o.p) {
                return o.n - this.n;
            }
            return this.p - o.p;
        }
    }

    public static class number implements Comparable<number> {
        int n;
        int p;

        number(int n, int p) {
            this.n = n;
            this.p = p;
        }

        @Override
        public int compareTo(number o) {
            return o.n - this.n;
        }
    }
}
