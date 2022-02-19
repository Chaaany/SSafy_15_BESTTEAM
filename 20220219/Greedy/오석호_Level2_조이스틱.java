class Solution {
    public int solution(String name) {
//         // 1. A 넣기
//         StringBuilder aString = new StringBuilder("");
//         for (int i = 0; i < name.length(); ++i) aString.append("A");
//         System.out.println(aString);
        
//         // 2. 글자 바꾸기 (굳이 아스키코드 안써도 20글자 이하이므로 완탐해도 될듯)
//         int idx = 0;
//         int cnt = 0;
//         // A = 65, Z = 90
//         // 78까지는 정방향, 90까지는 역방향
//         while(name != aString){
//             if (name.charAt(idx) != aString.charAt(idx)){
//                 if (name.charAt(idx) > 78) cnt += 91-name.charAt(idx);
//                 else cnt += name.charAt(idx) - 65;
//                 aString.setCharAt(idx) = name.charAt(idx);
//             }
//             idx++;
//         }
        // 아.. 진짜 자바는 답이없네
        
        // 1. 글자바꾸기
        int cnt = 0;
        int cursor = name.length() - 1;
        for (int i = 0; i < name.length(); ++i) cnt += name.charAt(i) > 78 ? 91-name.charAt(i) : name.charAt(i) - 65;
        
        // 2. 좌우이동 (완탐)
        for(int i = 0; i <name.length(); i++) {
            int next = i + 1; // 다음 좌표
            while(next != name.length() && name.charAt(next) == 'A') next++;
            
            int As = next - i - 1; // 연속된 A
            int move = name.length() - As - 1; // 전체에서 A를 제외하고 움직이는 횟수
            int min = Math.min(i, name.length() - next); // i까지 무지성 전진 vs next 바로 앞까지 무지성 후진 중 짧은거
            cursor = Math.min(cursor, move + min); // 처음부터 오른쪽만 vs 위에서 짧은거 + 다시 돌아오는거 비교해서 짧은거
        }
        // 각 자리수를 만들기위해서 필요한 조작 횟수 + 좌우를 최소한으로 조작하는 수
        cnt += cursor;
        
        return cnt;
    }
}
