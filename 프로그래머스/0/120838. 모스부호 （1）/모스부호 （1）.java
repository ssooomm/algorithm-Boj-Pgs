import java.util.*;

class Solution {
    public String solution(String letter) {
        String answer = "";
        
        String[] mos = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] arr = letter.split(" ");
        
        for(String s:arr){
            for(int i=0;i<mos.length;i++){
                if(s.equals(mos[i])){
                    answer+=(char)(97+i);
                }
            }
        }
        return answer;
    }
}