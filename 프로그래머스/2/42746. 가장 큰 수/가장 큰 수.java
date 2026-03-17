import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<String> list = new ArrayList<>();
        
        for(int n:numbers){
            list.add(String.valueOf(n));
        }
        
        list.sort((a,b)->(b+a).compareTo(a+b));
        
        // 예외 [40,403] => 40403
        // list.sort((a,b)->{
        //     int ai=0,bi=0;
        //     while(ai<a.length()&&bi<b.length()){
        //         char ach = a.charAt(ai++);
        //         char bch = b.charAt(bi++);
        //         if(ach==bch){
        //             continue;
        //         }else if(ach>bch){
        //             return -1; 
        //         }else{
        //             return 1; //순서 교체 b를 a앞으로
        //         }
        //     }
        //     char ach = a.charAt(a.length()-1);
        //     char bch = b.charAt(b.length()-1);
        //     if(ach==bch) return b.length()-a.length();
        //     else return bch-ach;
        // });
        
        if (list.get(0).equals("0")) return "0"; //[0,0,0] => 0
        
        for(String str:list){
            answer+=str;
        }
        return answer;
    }
}