import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        int N = Integer.parseInt(br.readLine());
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int solve1 = Integer.parseInt(st.nextToken());
        int solve2 = Integer.parseInt(st.nextToken());
        int solve3 = Integer.parseInt(st.nextToken());
        int solve4 = Integer.parseInt(st.nextToken());
        int solve5 = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            switch (level) {
                case 1:
                    list1.add(time);
                    break;
                case 2:
                    list2.add(time);
                    break;
                case 3:
                    list3.add(time);
                    break;
                case 4:
                    list4.add(time);
                    break;
                case 5:
                    list5.add(time);
                    break;
                default:
                    break;
            }
        }
        list1.sort(null);
        list2.sort(null);
        list3.sort(null);
        list4.sort(null);
        list5.sort(null);
        for (int i = 0; i < solve1; i++) {
            ans += list1.get(i);
            if (i == solve1 - 1) {
                break;
            }
            ans += list1.get(i + 1) - list1.get(i);
        }
        for (int i = 0; i < solve2; i++) {
            ans += list2.get(i);
            if (i == solve2 - 1) {
                break;
            }
            ans += list2.get(i + 1) - list2.get(i);
        }
        for (int i = 0; i < solve3; i++) {
            ans += list3.get(i);
            if (i == solve3 - 1) {
                break;
            }
            ans += list3.get(i + 1) - list3.get(i);
        }
        for (int i = 0; i < solve4; i++) {
            ans += list4.get(i);
            if (i == solve4 - 1) {
                break;
            }
            ans += list4.get(i + 1) - list4.get(i);
        }
        for (int i = 0; i < solve5; i++) {
            ans += list5.get(i);
            if (i == solve5 - 1) {
                break;
            }
            ans += list5.get(i + 1) - list5.get(i);
        }
        System.out.println(ans + 240);
    }

}
