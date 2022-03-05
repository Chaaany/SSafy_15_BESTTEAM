import java.util.*;

class Solution {
    
    class Word{
        String name;
        int cnt;
        boolean v[];
        
        Word(String name, int cnt, boolean[] v){
            this.name = name;
            this.cnt = cnt;
            this.v = v;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        if(!isTarget(target, words)) 
            return 0;
        
        Queue<Word> q = new LinkedList<>();
        int N = words.length;
        q.offer(new Word(begin, 0, new boolean[N]));
        while(!q.isEmpty()){
            Word word = q.poll();
            String name = word.name;
            int cnt = word.cnt;
            boolean v[] = word.v;
            
            if(name.equals(target)){
                return cnt;
            }
            
            for(int i=0; i<N; i++){
                if(v[i] || !isChangeable(name, words[i])) continue;
                boolean nv[] = Arrays.copyOf(v, N);
                nv[i] = true;
                q.offer(new Word(words[i], cnt+1, nv));
            }
        }
        
        return 0;
    }
    
    //words에 target이 있는지 검사
    private boolean isTarget(String target, String[] words){
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)) return true;
        }
        return false;
    }
    
    //한 개의 알파벳만 다르면 true 리턴
    private boolean isChangeable(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        
        int cnt = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) cnt++;
            if(cnt > 1) return false;
        }
        if(cnt == 0)
            return false;
        return true;
    }
}