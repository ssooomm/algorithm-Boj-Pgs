import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        Map<String,String> hm = new HashMap<>();
        for(String r:record){
            String[] arr = r.split(" ");
            if(arr[0].equals("Leave")) continue;
            hm.put(arr[1],arr[2]);
        }
        
        List<String> list = new ArrayList<>();
        String enter = "님이 들어왔습니다.";
        String leave = "님이 나갔습니다.";
        
        for(String r:record){
            String[] arr = r.split(" ");
            String n = hm.get(arr[1]);
            if(arr[0].equals("Enter")){
                list.add(n+enter);
            }else if(arr[0].equals("Leave")){
                list.add(n+leave);
            }
        }
        
        answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}