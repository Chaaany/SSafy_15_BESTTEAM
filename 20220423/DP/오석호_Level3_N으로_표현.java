import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // 8개 썼을 때 까지만 구하면 되지 않을까?
        // DP니까 1개~7개 썼을때를 이용해서 8개를 구한다
        // 정렬이 필요한가? 어짜피 완탐 조질거니 HashSet을 쓰자
        ArrayList<Set<Integer>> hsList = new ArrayList<>();
        int answer = -1;
        
        for(int i = 0; i < 9; i++) {
            hsList.add(new HashSet<>());
        }
        
        // 각 리스트에 N, NN, NNN 넣어주기
        int mul = 0;
        for (int i = 1; i < 9; ++i){
            mul = mul * 10 + N;
            hsList.get(i).add(mul);
        }
        
        // 이전 요소를 바탕으로 다음 요소 연산값 구하기
        for (int i = 2; i < 9; ++i){
            Set<Integer> cntSet = hsList.get(i);
            for (int j = 1; j < i; ++j){
                Set<Integer> preSet = hsList.get(j);
                Set<Integer> postSet = hsList.get(i-j);
                for (int k : preSet){
                    for (int l : postSet){
                        cntSet.add(k+l);
                        cntSet.add(k-l);
                        cntSet.add(k*l);
                        if (l != 0) cntSet.add(k/l);
                    }
                }
            }
        }
        
        // 정답 찾기
        for (int i = 1; i < 9; ++i){
            if (hsList.get(i).contains(number)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
