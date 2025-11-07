import java.util.*;

class Solution {
    static char[] arr;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        int len = numbers.length();
        arr = new char[len];
        for(int i=0;i<len;i++){
            arr[i] = numbers.charAt(i);
        }
        
        for(int i=1;i<=len;i++){
            bt(i,new boolean[len],new ArrayList<>(),arr);
        }
        
        for(int n:set){
            if(isPrime(n)) answer++;
        }
        
        return answer;
    }
    
    void bt(int len,boolean[] v,List<Character> list,char[] arr){
        if(len==list.size()){
            String str = "";
            for(char c:list){
                str+=c;
            }
            set.add(Integer.parseInt(str));
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!v[i]){
                v[i] = true;
                list.add(arr[i]);
                bt(len,v,list,arr);
                v[i] = false;
                list.remove(list.size()-1);
            }
        }
    }

    boolean isPrime(int x){
        if(x<=1) return false;
        if(x==2) return true;
        int sq = (int)Math.sqrt(x);

        for(int i=2;i<=sq;i++){
            if(x%i==0) return false;
        }
        return true;
    }
}

