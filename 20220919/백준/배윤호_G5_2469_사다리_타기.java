import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		char[] Top = new char[k];
		char[] Bottom = new char[k];
		int b = 65;
		for (int i = 0; i < k; i++) {
			Top[i]= (char) b++;
		}
		for (int i = 0; i < k; i++) {
			Bottom[i] = s.charAt(i);
		}
		char[][] ladder = new char[n][k-1];
		int mid = 0;
		for (int i = 0; i < n; i++) {
			s = br.readLine();
			ladder[i] = s.toCharArray();
			if(ladder[i][0]=='?') {
				mid = i;
			}
		}
		for (int i = 0; i < mid; i++) {
			for (int j = 0; j < k-1; j++) {
				if(ladder[i][j]=='-') {
					char temp = Top[j];
					Top[j] = Top[j+1];
					Top[j+1] = temp;
				}
			}
		}
		for (int i = n-1; i > mid; i--) {
			for (int j = 0; j < k-1; j++) {
				if(ladder[i][j]=='-') {
					char temp = Bottom[j];
					Bottom[j] = Bottom[j+1];
					Bottom[j+1] = temp;
				}
			}
		}
		char answer[] = new char[k-1];
		boolean check = false;
		for (int i = 0; i < k-1; i++) {
			if(check) {
				check = false;
				continue;
			}
			if(Top[i]==Bottom[i]) {
				answer[i]='*';
			}
			else {
				if(Top[i]==Bottom[i+1] && Top[i+1]==Bottom[i]) {
					answer[i]='-';
					if(i+1<k-1) {
						answer[i+1] ='*';
					}
					check = true;
				}else {
					for (int j = 0; j < k-1; j++) {
						answer[j] = 'x';
					}
					break;
				}
			}
		}
		
		
		for (int i = 0; i < k-1; i++) {
			System.out.print(answer[i]);
		}
		
		
	}

}
//근본 넘치는 자바 풀이
