import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String line = "";
		char[][] map = new char[3][3];
		while(!(line=br.readLine()).equals("end")) {
			boolean valid = true;
			
			int xCnt = 0;
			int oCnt = 0;
			int idx = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = line.charAt(idx++);
					if(map[i][j]=='X') xCnt++;
					else if(map[i][j]=='O') oCnt++;
				}
			}
			
			// X 먼저 시작하므로 O가 더 많을 수 없음
			if(oCnt > xCnt || xCnt-oCnt > 1) {
				sb.append("invalid\n");
				continue;
			}
			
			// 빙고 검사
			boolean xBingo = false;
			boolean oBingo = false;
			
			// 빙고 - 가로
			for (int i = 0; i < 3; i++) {
				int x = 0;
				int o = 0;
				for (int j = 0; j < 3; j++) {
					if(map[i][j] == 'X') x++;
					else if(map[i][j] == 'O') o++;
				}
				if(x==3) xBingo = true;
				if(o==3) oBingo = true;
			}
			
			// 빙고 - 세로
			for (int i = 0; i < 3; i++) {
				int x = 0;
				int o = 0;
				for (int j = 0; j < 3; j++) {
					if(map[j][i] == 'X') x++;
					else if(map[j][i] == 'O') o++;
				}
				if(x==3) xBingo = true;
				if(o==3) oBingo = true;
			}
			
			// 빙고 - 대각선
			if(map[0][0]==map[1][1] && map[1][1]==map[2][2]) {
				if(map[0][0] == 'X') xBingo = true;
				else if(map[0][0] == 'O') oBingo = true;
			}
			if(map[0][2]==map[1][1] && map[1][1]==map[2][0]) {
				if(map[0][2] == 'X') xBingo = true;
				else if(map[0][2] == 'O') oBingo = true;
			}
			
			// 둘 다 빙고일 수 없음. 한명이 빙고면 끝남
			if(xBingo && oBingo) valid = false;
			
			// 바둑판이 다 차지 않았는데 빙고도 없으면 안됨
			if(xCnt+oCnt != 9) {
				if(!xBingo && !oBingo) valid = false;
			}
			
            // X가 이긴 경우 X가 O보다 많아야함
			if(xBingo && xCnt<=oCnt) valid = false;
			
			// O가 이긴 경우 X와 O 수가 같아야함
			if(oBingo && xCnt!=oCnt) valid = false;
            
			sb.append(valid?"valid\n":"invalid\n");
		}
		
		System.out.println(sb);
	}

}
