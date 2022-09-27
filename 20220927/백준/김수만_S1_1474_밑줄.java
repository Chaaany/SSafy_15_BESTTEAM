import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//밑 줄
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String words[] = new String[N]; //입력한 단어 배열
		int dash[] = new int[N]; //해당 위치의 단어 앞에 들어갈 _ 개수
		int length = 0;
		for(int i=0; i<N; i++) {
			words[i] = br.readLine();
			length += words[i].length();
		}
		
    //단어 사이에 _ 넣을 수 있는 만큼 넣기
		int val = M - length;
		int cnt = val/(N-1);
		Arrays.fill(dash, cnt);
		
    //소문자 알파벳으로 시작하는 단어 앞에 먼저 _넣기
    //그 다음에 뒤에서부터 빈 공간에 _ 넣기
		cnt = val - cnt*(N-1);
		boolean v[] = new boolean[N];
		for(int i=1; i<N; i++) {
			if(cnt == 0) break;
			if(words[i].charAt(0) >= 'a' && words[i].charAt(0) <= 'z') {
				v[i] = true;
				dash[i]++;
				cnt--;
			}
		}
		for(int i=N-1; i>0; i--) {
			if(cnt == 0) break;
			if(v[i]) continue;
			dash[i]++;
			cnt--;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			if(i != 0) {
				for(int k=0; k<dash[i]; k++)
					sb.append("_");
			}
			sb.append(words[i]);
		}
		System.out.println(sb.toString());
	}

}
