import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];
        int garo = 0;
        int sero = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            int cont = 0;
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.') {
                    cont++;
                } else {
                    if(cont > 1) garo++;
                    cont = 0;
                }
            }
            if(cont > 1) garo++;
        }
        for (int i = 0; i < N; i++) {
            int cont = 0;
            for (int j = 0; j < N; j++) {
                if (room[j][i] == '.') {
                    cont++;
                } else {
                    if(cont > 1) sero++;
                    cont = 0;
                }
            }
            if(cont > 1) sero++;
        }
        System.out.println(garo+" "+sero);
    }
}
