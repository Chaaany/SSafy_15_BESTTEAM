import java.util.Arrays;
import java.util.Scanner;

public class Main_2469 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		char[][] ladder = new char[n][k-1];
		String result = sc.next();
		int hiddenRow = 0;
		for (int i = 0; i < n; i++) {
			ladder[i] = sc.next().toCharArray();
			if(ladder[i][0] == '?') hiddenRow = i;
		}
		
		char[] beforeHiddenRow = new char[k];
		for (int i = 0; i < k; i++) {
			char who = (char) (65 + i);
			int line = i;
			for (int j = 0; j < hiddenRow; j++) {
				 if(line-1 >= 0) { // 왼쪽 줄 확인
					 if(ladder[j][line-1] == '-') {
						 line--;
						 continue;
					 }
				 }
				 if(line < k-1) { // 오른쪽 줄 확인
					 if(ladder[j][line] == '-') line++;
				 }
			}
			beforeHiddenRow[line] = who;
		}
		
		char[] afterHiddenRow = new char[k];
		for (int i = 0; i < k; i++) {
			char who = result.charAt(i);
			int line = i;
			for (int j = n-1; j > hiddenRow; j--) {
				 if(line-1 >= 0) { // 왼쪽 줄 확인
					 if(ladder[j][line-1] == '-') {
						 line--;
						 continue;
					 }
				 }
				 if(line < k-1) { // 오른쪽 줄 확인
					 if(ladder[j][line] == '-') line++;
				 }
			}
			afterHiddenRow[line] = who;
		}
		
		char[] answer = new char[k-1];
		Arrays.fill(answer, 'x');
		for (int i = 0; i < k-1; i++) {
			if(beforeHiddenRow[i] == afterHiddenRow[i]) answer[i] = '*';
			else {
				if(beforeHiddenRow[i] == afterHiddenRow[i+1] && beforeHiddenRow[i+1] == afterHiddenRow[i]) {
					answer[i] = '-';
					if(i+1 < k-1) answer[++i] = '*';
				}
			}
		}
		for (int i = 0; i < answer.length; i++) {
			if(answer[i]=='x') {
				Arrays.fill(answer, 'x');
				break;
			}
		}
		System.out.println(String.valueOf(answer));
	}

}
