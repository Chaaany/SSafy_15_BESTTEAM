import java.util.*;
import java.util.Map.*;

class Solution {
    static class Song implements Comparable<Song>{
        int no;
        int played;
        Song(int no, int played){
            this.no=no;
            this.played=played;
        }
        @Override
        public int compareTo(Song s){
            if (played==s.played){
                return no-s.no;
            }
            return s.played-played;
        }
        
    }
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer=new ArrayList<>();
        HashMap<String, Integer> gmap=new HashMap<>();  //key: 장르의 이름, value: 장르가 재생된 총 횟수
        HashMap<String, ArrayList<Song>> smap=new HashMap<>();  //key: 장르의 이름, value: 각 장르에 속한 음악의 고유번호, 재생횟수
        for (int i=0; i<genres.length; i++){
            int cnt=gmap.containsKey(genres[i]) ? gmap.get(genres[i]): 0;
            gmap.put(genres[i], cnt+plays[i]);      //장르의 총 재생 횟수를 저장
            if (!smap.containsKey(genres[i])) smap.put(genres[i], new ArrayList<>());
            smap.get(genres[i]).add(new Song(i, plays[i])); //각 장르에 속한 음악 고유번호, 재생횟수 저장
        }
        List<Entry<String, Integer>> list=new ArrayList<>(gmap.entrySet()); //총 재생 횟수 큰 순으로 장르를 정렬
        list.sort(Entry.<String,Integer>comparingByValue().reversed());
        for (Entry<String, Integer> e : list){      //재생횟수 큰 순으로 장르를 뽑아오면서
            String genre=e.getKey();
            Collections.sort(smap.get(genre));  //해당 장르에 속한 음악들을 재생순/고유번호순으로 정렬시켜준다
            answer.add(smap.get(genre).get(0).no);      //2개씩 answer에 담는다 
            if (smap.get(genre).size()>1) answer.add(smap.get(genre).get(1).no);
        }
        return answer;
    }
}
