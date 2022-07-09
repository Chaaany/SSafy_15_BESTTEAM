class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] count = new int[a.length];
        
        for(int i = 0; i < a.length;i++){
           count[a[i]]++;  
        } 
            
        for(int i=0 ; i<a.length ; i++) {
        	if(count[i] == 0 || count[i] == 1count[i]<=answer) continue; // 프루닝(i가 배열에 없거나, answer 적은 갯수일 경우)
        	
        	int size = 0;
            
        	for(int j=0 ; j<a.length-1 ; j++) {
                if(a[j]==a[j+1]) continue; // 수가 같니?
                
        		if(!(a[j] ==i || a[j+1] ==i)) continue; // 교집합 있니?
        		size++;
        		j++;
        	}
            
        	answer = Math.max(answer, size);
        }
        answer *= 2;
        
        return answer;
    }
}
