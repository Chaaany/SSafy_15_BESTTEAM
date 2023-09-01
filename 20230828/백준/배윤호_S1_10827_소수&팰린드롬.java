import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(2);
            return;
        }
        while (true) {
            if (sosu(N) && pd(N)) {
                System.out.println(N);
                return;
            }
            N++;
        }
    }

    private static boolean pd(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean sosu(int n) {
        char[] arr = (n + "").toCharArray();
        int back = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[back--]) {
                return false;
            }
        }
        return true;
    }

}
