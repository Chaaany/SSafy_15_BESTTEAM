import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	List<Integer> ans = new ArrayList<>();
	int[] answer;
	//학생들 패턴 저장
	int[] student1 = {1,2,3,4,5}, student2= {2,1,2,3,2,4,2,5}, student3 = {3,3,1,1,2,2,4,4,5,5};

	//맞은 수 변수 선언
	int cnt1=0, cnt2=0, cnt3=0, max = -1;

	//맞은 수 구하기
	for (int i = 0; i < answers.length; i++) {
		if(answers[i] == student1[i%5]) cnt1++;
		if(answers[i] == student2[i%8]) cnt2++;
		if(answers[i] == student3[i%10]) cnt3++;
	}

	//제일 많이 문제 맞춘 수 구하기
	max = Math.max(max, cnt1);
	max = Math.max(max, cnt2);
	max = Math.max(max, cnt3);

	// 많이 맞춘 학생인지 확인
	if(max == cnt1) {
		ans.add(1);
	} 
	if(max == cnt2) {
		ans.add(2);
	} 

	if(max == cnt3) {
		ans.add(3);
	}

	//정답 배열 선언 및 입력
	answer = new int[ans.size()];
	int temp = 0;
	for (int i : ans) {
			answer[temp++] = i;
		}

	return answer;
}
