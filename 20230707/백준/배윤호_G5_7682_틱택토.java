2import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("end"))
                break;
            char[][] map = new char[3][3];
            int index = 0;
            int x = 0;
            int o = 0;
            int xbingo = 0;
            int obingo = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = s.charAt(index++);
                    if (map[i][j] == 'X')
                        x++;
                    else if (map[i][j] == 'O')
                        o++;
                }
            }
            if (o > x) {
                sb.append("invalid\n");
                continue;
            }
            // 빙고체크
            // 가로
            for (int i = 0; i < 3; i++) {
                boolean check = true;
                for (int j = 0; j < 2; j++) {
                    if (map[i][j] != map[i][j + 1]) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    if (map[i][0] == 'X')
                        xbingo++;
                    else if (map[i][0] == 'O')
                        obingo++;

                }
            }
            // 세로
            for (int j = 0; j < 3; j++) {
                boolean check = true;
                for (int i = 0; i < 2; i++) {
                    if (map[i][j] != map[i + 1][j]) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    if (map[0][j] == 'X')
                        xbingo++;
                    else if (map[0][j] == 'O')
                        obingo++;
                }
            }
            // 대각선
            if (map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
                if (map[0][0] == 'X')
                    xbingo++;
                else
                    obingo++;
            }
            // 역대각선
            if (map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
                if (map[0][2] == 'X')
                    xbingo++;
                else
                    obingo++;
            }
            // x 투 빙고 일때 갯수 x = 5, o = 4면 valid
            // 둘이 합해서 원빙고 나올때, 원빙고 일 때는 x=o+1 o 원빙고일때는 x=o
            if (xbingo == 2 && x == 5 && o == 4) {
                sb.append("valid\n");
                continue;
            } else if (xbingo == 1 && obingo == 0 && x == o + 1) {
                sb.append("valid\n");
                continue;
            } else if (xbingo == 0 && obingo == 1 && x == o) {
                sb.append("valid\n");
                continue;
            } else if (xbingo == 0 && obingo == 0 && x == 5 && o == 4) {
                sb.append("valid\n");
                continue;
            } else {
                sb.append("invalid\n");
                continue;
            }

        }
        System.out.println(sb);
    }

}
