import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        List<List<Integer>> arr = new ArrayList<>();
        
        int idx=1;
        while(idx<s.length()){
            if(s.charAt(idx)=='{'){
                List<Integer> list = new ArrayList<>();
                String str="";
                for(int i=idx+1;i<s.length();i++){
                    if(s.charAt(i)==','){
                        list.add(Integer.parseInt(str));
                        str="";
                    }
                    else if(s.charAt(i)=='}'){
                        list.add(Integer.parseInt(str));
                        idx=i+1;
                        break;
                    }
                    else str+=s.charAt(i);
                }
                arr.add(list);
            }
            idx++;
        }
        
        Collections.sort(arr,(a,b)->a.size()-b.size());
        int[] answer = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            List<Integer> tmp = arr.get(i);
            for(int t:tmp){
                boolean flag = true;
                for(int j=0;j<i;j++){
                    if(t==answer[j]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    answer[i] = t;
                    break;
                }
                
            }
        }
        
        return answer;
    }
}