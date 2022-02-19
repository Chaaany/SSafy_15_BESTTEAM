import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int boat=0;
        Arrays.sort(people);		//오름차순으로 정렬
        int q=limit;
        int start=0;				//최소값부터 시작하는 포인터
        int end=people.length-1;    //최대값부터 시작하는 포인터
        while (start<end){	//두 포인터가 겹치지 않을 때까지
            if (people[start]+people[end]<=limit){	//최소 포인터, 최대 포인터의 합이 limit 넘지 않으면 
                boat++;		//보트 수 증가
                start+=1;	//최소 포인터 오른쪽으로 1 이동
                end-=1;		//최대 포인터 왼쪽으로 1 이동
            }
            else{			//두 합이 limit 넘으면
                end-=1;		//최대 포인터 왼쪽으로 이동시켜주기
            }
        }
        return boat+(people.length-boat*2);	//보트 수+남은 사람들의 합
    }
}
