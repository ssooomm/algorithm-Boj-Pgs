import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        int n = files.length;
        String[] answer = new String[n];
        
        List<String[]> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            String f = files[i];
            StringBuilder num = new StringBuilder();
            boolean flag = false;
            for(int j=0;j<f.length();j++){
                if(f.charAt(j)-'0'<10&&f.charAt(j)-'0'>=0){
                    flag = true;
                    num.append(f.charAt(j));
                }
                else if(flag) break;
            }
            String numstr = num.toString();
            String[] arr = f.split(numstr);
            list.add(new String[]{arr[0],numstr,f});
        }
        
        list.sort((a,b)->{
            if(a[0].toUpperCase().equals(b[0].toUpperCase())){
                int aa = Integer.parseInt(a[1]);
                int bb = Integer.parseInt(b[1]);
                return Integer.compare(aa,bb);
            }else{
                return a[0].compareToIgnoreCase(b[0]);
            }
        });
        
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i)[2];
        }
        
        return answer;
    }
}