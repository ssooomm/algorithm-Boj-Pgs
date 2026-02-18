import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String,Integer> hm1 = change(str1);
        Map<String,Integer> hm2 = change(str2);
        if(hm1.size()==0&&hm2.size()==0) return 65536;
        
        int min=0;
        int max=0;
        for(String k:hm1.keySet()){
            if(hm2.containsKey(k)){
                min+=Math.min(hm1.get(k),hm2.get(k));
                max+=Math.max(hm1.get(k),hm2.get(k));
            }
            else{
                max+=hm1.get(k);
            }
        }
        for(String k:hm2.keySet()){
            if(hm1.containsKey(k)) continue;
            else max+=hm2.get(k);
        }
        
        return (int)((double)min/max*65536);
    }
    
    Map<String,Integer> change(String str){
        Map<String,Integer> hm = new HashMap<>();
        for(int i=0;i<str.length()-1;i++){
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i+1);
            if(isChar(ch1)&&isChar(ch2)){
                String k = (""+ch1+ch2).toUpperCase();
                hm.put(k,hm.getOrDefault(k,0)+1);
            }
        }
        return hm;
    }
    
    boolean isChar(char ch){
        if(ch>122||ch<65) return false;
        if(ch>90&&ch<97) return false;
        return true;
    }
}