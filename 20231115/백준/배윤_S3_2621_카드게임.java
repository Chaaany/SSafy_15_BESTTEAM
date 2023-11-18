import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> color = new HashSet<>();
        List<Integer> num = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken());
            color.add(c);
            num.add(n);
        }
        num.sort(null);
        if (color.size() == 1 && seq(num)) {
            int score = num.get(4) + 900;
            max = Math.max(max, score);
        }
        if (four(num)) {
            int score = num.get(2) + 800;
            max = Math.max(max, score);
        }
        if (num.get(0) == num.get(1) && num.get(3) == num.get(4) && num.get(0) != num.get(4)) {
            if (num.get(1) == num.get(2)) {
                int score = num.get(1) * 10 + num.get(4) + 700;
                max = Math.max(max, score);
            } else if (num.get(3) == num.get(2)) {
                int score = num.get(4) * 10 + num.get(1) + 700;
                max = Math.max(max, score);
            }
        }
        if (color.size() == 1 && !seq(num)) {
            int score = num.get(4) + 600;
            max = Math.max(max, score);
        }
        if (color.size() != 1 && seq(num)) {
            int score = num.get(4) + 500;
            max = Math.max(max, score);
        }
        if (three(num)) {
            int score = num.get(2) + 400;
            max = Math.max(max, score);
        }
        int[] arr = new int[10];
        List<Integer> two = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr[num.get(i)]++;
        }
        for (int i = 1; i < 10; i++) {
            if (arr[i] == 2) {
                two.add(i);
            }
        }
        if (two.size() == 2) {
            int score = two.get(1) * 10 + two.get(0) + 300;
            max = Math.max(max, score);
        }
        if (two.size() == 1) {
            int score = two.get(0) + 200;
            max = Math.max(max, score);
        }
        int score = num.get(4) + 100;
        max = Math.max(max, score);
        System.out.println(max);
    }

    private static boolean three(List<Integer> num) {
        boolean check = false;
        for (int i = 0; i < 3; i++) {
            if (num.get(i) == num.get(i + 1) && num.get(i + 1) == num.get(i + 2)) {
                check = true;
                break;
            }
        }
        return check;
    }

    private static boolean four(List<Integer> num) {
        boolean check = false;
        if (num.get(1) == num.get(2) && num.get(2) == num.get(3)) {
            if (num.get(1) == num.get(0) || num.get(3) == num.get(4)) {
                check = true;
            }
        }
        return check;
    }

    private static boolean seq(List<Integer> num) {
        boolean check = true;
        for (int i = 0; i < 4; i++) {
            if (num.get(i) + 1 != num.get(i + 1)) {
                check = false;
                break;
            }
        }
        return check;
    }

}
