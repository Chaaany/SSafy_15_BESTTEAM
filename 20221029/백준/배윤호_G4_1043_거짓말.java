import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Set<Integer> set = new HashSet<>(); // 진실을 아는 자들을 담을 셋
		List<List<Integer>> list = new LinkedList<>(); // 파티 구성원을 담을 리스트
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 총 인원 수
		int M = Integer.parseInt(st.nextToken()); // 파티 수
		int answer = M; // 정답 우선 파티 수로 해놓고 파티에 진실 아는 자가 있으면 -- 할거임
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // 진실을 아는 자의 수
		while (st.hasMoreTokens()) {
			int p = Integer.parseInt(st.nextToken()); // 진실을 아는 자 셋에 추가
			set.add(p);
		}
		for (int i = 0; i < M; i++) { // 파티 수만큼
			List<Integer> party = new LinkedList<Integer>(); // 파티 구성원 담을 리스트
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken()); // 파티원 수만큼
			while (st.hasMoreTokens()) { // 파티 리스트에 구성원 담기
				party.add(Integer.parseInt(st.nextToken()));
			}
			list.add(party); // 그렇게 만들어진 파티를 리스트에 담기
		}
		for (int l = 0; l < list.size(); l++) { //리스트 파티 숫자만큼 반복 -->진실을 아는 사람이 나중에 나올수도 있으므로
			for (int i = 0; i < list.size(); i++) { // 리스트 파티 숫자만큼 반복
				for (int j = 0; j < list.get(i).size(); j++) { // 파티 구성원 숫자만큼 반복
					if (set.contains(list.get(i).get(j))) { // 만약 파티 구성원 중 진실을 아는자가 있으면
						for (int k = 0; k < list.get(i).size(); k++) {
							set.add(list.get(i).get(k)); // 그 파티 구성원 모두 진실을 아는자 셋에 넣는다
						}
						break; // 다 넣었으니까 break
					}
				}
			}
		}

		// 이제 set에 진실을 아는 자가 모두 들어있다.
		for (int i = 0; i < list.size(); i++) { // 파티 숫자만큼 반복
			for (int j = 0; j < list.get(i).size(); j++) { // 파티 구성원 수만큼 반복
				if (set.contains(list.get(i).get(j))) { // 만약 파티원중 진실을 아는자가 있으면
					answer--; // 그 파티는 거짓말을 못치므로 --
					break; // 파티가 박살났다 다음 파티 탐색하자
				}
			}
		}
		System.out.println(answer); // 거짓말을 칠 수 있는 파티 출력

	}

}
