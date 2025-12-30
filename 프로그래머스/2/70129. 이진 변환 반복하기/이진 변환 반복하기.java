import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(s.length()>1){
            int cnt = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0'){
                    answer[1]++;
                }else{
                    cnt++;
                }
            }
            s = binary(cnt);
            answer[0]++;
        }
        
        return answer;
    }
    
    String binary(int cnt){
        List<String> list = new ArrayList<>();
        while(cnt!=1){
            if(cnt%2==0){
                list.add("0");
            }else{
                list.add("1");
            }
            cnt/=2;
        }
        list.add("1");
        list.sort(Comparator.reverseOrder());
        return String.join("",list);
    }
}