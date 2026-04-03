import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        
        List<String> list = new ArrayList<>();
        
        String tmp="";
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(ch-'0'>=0){
                tmp+=ch;
            }else{
                list.add(tmp);
                list.add(String.valueOf(ch));
                tmp = "";
            }
        }
        list.add(tmp);
        
        String[][] pri = {
            {"*","+","-"},{"*","-","+"},
            {"+","*","-"},{"+","-","*"},
            {"-","*","+"},{"-","+","*"}
        };
        
        for(String[] p:pri){
            List<String> copy = new ArrayList<>(list);
            for(String op:p){
                copy = calc(copy,op);
            }
            
            answer = Math.max(Math.abs(Long.parseLong(copy.get(0))),answer);
        }
        
        return answer;
    }
    
    public List<String> calc(List<String> list,String op){
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(op)){
                long a = Long.parseLong(list.get(i-1));
                long b = Long.parseLong(list.get(i+1));
                
                long res = 0;
                if (op.equals("*")) res = a * b;
                else if (op.equals("+")) res = a + b;
                else if (op.equals("-")) res = a - b;
                
                //뒤에서 부터 삭제해야 안전
                list.remove(i + 1); 
                list.remove(i);    
                list.remove(i - 1);
                list.add(i - 1, String.valueOf(res));
                
                i--;
            }
        }
        return list;
    }
    
}