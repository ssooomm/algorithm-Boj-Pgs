import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        int n = number.length();
        int len = n-k;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char cur = number.charAt(i);
            
            // 스택 비어있지 않고, 더 지울 수 있고, 마지막에 넣은 숫자가 현재 숫자보다 작을 때
            while(sb.length()>0 && k >0 && sb.charAt(sb.length()-1)<cur){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            sb.append(cur);
        }
        
        //뒤에서부터
        return sb.substring(0,len);
    }
}