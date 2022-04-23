import java.util.*;

class Solution {
    static Map<Integer, Integer> map=new HashMap<>();
    static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    public int solution(int N, int number) {
        int answer = 0;
        list.add(new ArrayList<>());
        for (int i=1; i<=8; i++){     //1개 이용 ~8개 이용해서 구할 수 있는 수를 모두 구해줌
            list.add(new ArrayList<>()); 
            int num=makeNum(i, N);
            if (!map.containsKey(num)){
                map.put(num, i);
                list.get(i).add(num);
            }
            for (int j=1; j<i; j++){
                int a=j;        //a번(j개 이용)+b번(i-j개 이용)=i번
                int b=i-j;
                check(a, b, i);
            }
        }
        return map.containsKey(number)? map.get(number):-1;   //그 수가 map에 있으면 답 리턴, 아니면 -1
    }
    private void check(int a, int b, int tot){
        int res;
        for (int i=0; i<list.get(a).size(); i++){
            for (int j=0; j<list.get(b).size(); j++){
                int num1=list.get(a).get(i);
                int num2=list.get(b).get(j);
                res=num1+num2;
                insert(res, tot);
                res=num1-num2;
                insert(res, tot);
                res=num1*num2;
                insert(res, tot);
                if (num1%num2==0){
                    insert(num1/num2, tot);
                }
            }
        }
    }
    private void insert(int res, int tot){
        if (res>0 && !map.containsKey(res)){
            map.put(res, tot);
            list.get(tot).add(res);
        }
    }
    
    private int makeNum(int it, int N){
        int num=0;
        int mul=1;
        for (int i=0; i<it; i++){
            num+=(N*mul);
            mul*=10;
        }
        return num;
    }
}
