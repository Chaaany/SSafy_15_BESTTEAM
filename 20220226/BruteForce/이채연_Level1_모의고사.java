import java.util.*;

class Solution {
    static int[] num1={1, 2, 3, 4, 5};  //찍는 패턴 배열에 저장
    static int[] num2={2, 1, 2, 3, 2, 4, 2, 5};
    static int[] num3={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public int[] solution(int[] answers) {
        List<Integer> li=new ArrayList<>();
        int[] peoples=new int[3];
        int max=Integer.MIN_VALUE;
        for (int i=0; i<answers.length; i++){
            if (answers[i]==num1[i%num1.length]) peoples[0]++;  //문제와 각각 비교(% 연산 사용)
            if (answers[i]==num2[i%num2.length]) peoples[1]++;
            if (answers[i]==num3[i%num3.length]) peoples[2]++;
        }
        for (int i=0; i<3; i++){    //가장 많이 맞춘 점수 뽑음
            if (max<peoples[i]){
                 max=peoples[i];     
            }
        }
        for (int i=0; i<3; i++){    //가장 많이 맞춘 점수를 가진 사람의 번호를 list에 넣음
            if (max==peoples[i]){
                 li.add(i);     
            }
        }
        Collections.sort(li);   //list 오름차순 정렬
        int[] ans=new int[li.size()];   //list=>int array 로 변환
        for (int i=0; i<li.size(); i++){
            ans[i]=li.get(i)+1;
        }
        return ans;
    }
}
