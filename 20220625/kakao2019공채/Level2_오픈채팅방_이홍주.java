import java.util.*;
class Solution {
    public ArrayList<String> solution(String[] record) {
        StringTokenizer st  = null;
        HashMap<String, String> map = new HashMap<>();
        for(int i=0;i<record.length;i++){
            st = new StringTokenizer(record[i]," ");
             String order = st.nextToken();
             String id = st.nextToken();
            
            if(order.equals("Enter")){
                String name = st.nextToken();
                map.put(id,name);
            }else if(order.equals("Leave")){
            }else{
                String name = st.nextToken();
                map.put(id,name);
            }
        }
        ArrayList<String> list= new ArrayList<>();
        for(int i=0;i<record.length;i++){
            st = new StringTokenizer(record[i]," ");
             String order = st.nextToken();
             String id = st.nextToken();
            
            if(order.equals("Enter")){
                st.nextToken();
                String name = map.get(id);
                list.add(name+"님이 들어왔습니다.");
            }else if(order.equals("Leave")){
                 String name = map.get(id);
                 list.add(name+"님이 나갔습니다.");
            }else{
                String name = st.nextToken();
            }
        }
        return list;
    }
}
