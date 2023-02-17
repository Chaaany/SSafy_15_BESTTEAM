import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16637_GwalHoAdd {
	static int N;
	static int[] nums;
	static char[] oper;
	static boolean[] v;
	static int max = -Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N / 2 + 1];
		oper = new char[N / 2];
		v = new boolean[N / 2];
		String s = br.readLine();
		int nIndex = 0;
		int oIndex = 0;
		//입력받아서 nums와 oper에 넣는 과정
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) {
				nums[nIndex++] = s.charAt(i) - 48;
			} else {
				oper[oIndex++] = s.charAt(i);
			}
		}
		//괄호 갯수의 최댓값 구하기
		int temp = N / 2; // 연산자 갯수
		//짝수면 최대 (연산자 갯수/2)/2 개만큼 괄호 가능
		if (temp % 2 == 0) {
			temp /= 2;
		}
		//홀수면 최대 ((연산자 갯수/2)/2)+1 개만큼 괄호 가능
		else {
			temp = temp / 2 + 1;
		}
		//괄호로 묶을 연산자 반복문으로 돌리기 i= 괄호 갯수
		for (int i = 0; i <= temp; i++) {
			combi(0, 0, i);
		}
		System.out.println(max);
	}
	//괄호로 묶을 연산자를 선택하는 함수
	private static void combi(int start, int count, int choice) {
		//만약 괄호 다 썼으면 sum함수로 합 구하고 리턴
		if (count == choice) {
			sum();
			return;
		}
		for (int i = start; i < N / 2; i++) {
			if (v[i])
				continue;
			//괄호를 연속된 연산자에 씌울 수 없으므로 i-1에 이미 괄호 썼으면  i는 괄호 못 씀 (피연산자 중복되므로)
			if (i > 0) {
				if (v[i - 1])
					continue;
			}
			v[i] = true;
			combi(i + 2, count + 1, choice);
			v[i] = false;
		}

	}
	// 괄호로 묶을 연산자를 선택하고 그 합을 구하는 함수
	private static void sum() {
		//nums 첫 번째 값으로 시작
		int sum = nums[0];
		//연산자 숫자만큼 반복문
		for (int i = 0; i < N / 2; i++) {
			//만약 i 연산자가 마지막 연산자가 아닐 때
			if (i + 1 < N / 2) {
				//i+1 연산자가 true라면 뒤에꺼 먼저 계산 후 sum이랑 연산하기
				if (v[i + 1]) {
					sum = cal(sum, oper[i], cal(nums[i + 1], oper[i + 1], nums[i + 2]));
					i++;
				}
				//아니라면 그냥 순서대로 sum이랑 연산하기
				else {
					sum = cal(sum, oper[i], nums[i + 1]);
				}
			}
			//마지막 연산자면 그냥 순서대로 sum이랑 연산하기
			else {
				sum = cal(sum, oper[i], nums[i + 1]);
			}
		}
		//이렇게 더해진 값으로 max랑 비교해서 최댓값 갱신
		max = Math.max(sum, max);
	}
	//A,연산자,B 들어오면 연산해서 값을 return해주는 함수
	private static int cal(int sum1, char c, int sum2) {
		switch (c) {
		case '+':
			sum1 += sum2;
			break;
		case '-':
			sum1 -= sum2;
			break;
		case '*':
			sum1 *= sum2;
			break;
		}
		return sum1;
	}

}
