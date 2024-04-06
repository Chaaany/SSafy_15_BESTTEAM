import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 1; i < N; i++) {
            temp = b;
            b = (a + b) % 10;
            a = temp;
        }
        System.out.println(a);

    }

}
