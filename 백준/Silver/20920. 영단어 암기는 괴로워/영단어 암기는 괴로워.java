import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
        while(n-->0){
            String tmp = br.readLine();
            if(tmp.length()<m) continue;
            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((o1,o2)->{
            int c1 = map.get(o1);
            int c2 = map.get(o2);
            
            if(c1==c2){ //같은 횟수 -> 길이로
                if(o1.length()==o2.length()){ //같은 길이 -> 사전순으로
                    return o1.compareTo(o2);
                }
                else
                    return o2.length()-o1.length(); //긴 길이부터 
            }else{
                return c2-c1; //큰 횟수 부터 
            }
        });
        
        for(String str:list){
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
    
}