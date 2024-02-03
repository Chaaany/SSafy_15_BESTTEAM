import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int zero = 0;
        int one = 0;
        for (char c : arr) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }
        zero /= 2;
        one /= 2;
        for (int i = 0; i < arr.length; i++) {
            if (one == 0)
                break;
            if (arr[i] == '1') {
                arr[i] = '2';
                one--;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (zero == 0)
                break;
            if (arr[i] == '0') {
                arr[i] = '2';
                zero--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '2') {
                sb.append(arr[i]);
            }
        }
        System.out.println(sb);
    }

}
