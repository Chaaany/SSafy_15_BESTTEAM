package 조이스틱;

import java.util.Deque;
import java.util.LinkedList;

class Solution {

	static int sSize, dSize, min = Integer.MAX_VALUE;

	public int solution(String name) {
		int answer = 0;
		sSize = 0;
		dSize = 0;
		min = Integer.MAX_VALUE;
		Deque<Integer> searchIndex = new LinkedList<>();

		for (int i = 0; i < name.length(); i++) { // A아닌 곳 찾기
			if (name.charAt(i) != 'A')
				searchIndex.add(i);
		}
		dSize = searchIndex.size();
		sSize = name.length();
		for (Integer index : searchIndex) {
			int min = Math.min(name.charAt(index) - 'A', 'Z' - name.charAt(index) + 1);
			answer += min;
		}

		choose(0, 0, searchIndex);
		answer += min;
		return answer;
	}

	private void choose(int curIndex, int moveCnt, Deque<Integer> searchIndex) {
		if (searchIndex.isEmpty()) {
			min = Math.min(min, moveCnt);
			return;
		}

		Deque<Integer> tempIndex = new LinkedList<Integer>();
		for (Integer index : searchIndex) {
			tempIndex.add(index);
		}

		// 앞쪽 인덱스 부터 확인
		int first = tempIndex.pollFirst();
		int tempCnt = moveCnt;
		if (first > curIndex) {
			moveCnt += Math.min(first - curIndex, curIndex + sSize - first);
		} else {
			moveCnt += Math.min(curIndex - first, first + sSize - curIndex);
		}
		choose(first, moveCnt, tempIndex);
		tempIndex.addFirst(first); // 다시 넣기
		moveCnt = tempCnt; // cnt 초기화
		int last = tempIndex.pollLast(); // 뒷쪽 인덱스 시작
		if (last > curIndex) {
			moveCnt += Math.min(last - curIndex, curIndex + sSize - last);
		} else {
			moveCnt += Math.min(curIndex - last, last + sSize - curIndex);
		}
		choose(last, moveCnt, tempIndex);

	}
}
