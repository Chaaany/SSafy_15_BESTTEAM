import java.util.ArrayList;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        ArrayList<Integer> al = new ArrayList<>();
        
        // 약수 구하기 (절반만 구해도 됨)
        int total = brown + yellow;
        for (int i = 3; i * i <= total; ++i){
            if (total % i == 0) al.add(i);
        }
        
        // 경우의 수 확인 (사실상 완탐 x 반탐)
        for (int a : al) {
            if ((a - 2) * ((total / a) - 2) == yellow) {
                answer[0] = total / a;
                answer[1] = a;
                break;
            }
        }
        return answer;
    }
}
