import java.io.*;
import java.util.*;

public class BJ_7682_틱택토 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new  StringBuilder();
		
		while(true) {
			String line = br.readLine();
			if(line.equals("end")) break;
			
			char[][] map = new char[3][3];
			
			int x = 0;
			int o = 0;
			char X = 'X';
			char O = 'O';
			
			for (int i = 0; i < line.length(); i++) {
				map[i/3][i%3] = line.charAt(i);
				if(map[i/3][i%3] == X) x++;
				else if(map[i/3][i%3] == O) o++;
			}
			
			boolean finish = true;
			
			// invalid case 			
			// x, o 개수 차이가 1넘는 상황
			if(x-o > 1 || x-o < 0) finish = false;
			else {
				boolean xbin = false;
				boolean obin = false;
				
				// 가로, 세로
				if(check(X,map,0))  xbin = true;
				if(check(O,map,0))  obin = true;
								
				// 대각선
				if(check(X,map,1)) xbin = true;
				if(check(O,map,1)) obin = true;
				
				if(obin && xbin) finish = false;
				if(x+o != 9) {
					if(obin && x!=o || xbin && x<=o || !xbin && !obin) finish = false;
				}else {
					if(obin) finish = false;
				}
			}

			if(finish) sb.append("valid\n");
			else sb.append("invalid\n");
		}
		System.out.print(sb.toString());
	}

	private static boolean check(char c, char[][] map, int idx) {
		if(idx == 0) {
			for (int i = 0; i < 3; i++) {
				// 가로
				if(map[i][0]==c && map[i][1]==c && map[i][2]==c) return true;
				
				//세로
				if(map[0][i]==c && map[1][i]==c && map[2][i]==c) return true;									
			}
		}else {
			if(map[0][0]==c && map[1][1]==c && map[2][2]==c) return true;
			if(map[0][2]==c && map[1][1]==c && map[2][0]==c) return true;
		}
		return false;
	}

}
