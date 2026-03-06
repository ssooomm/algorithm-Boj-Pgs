import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String,Queue<String>> hm = new HashMap<>();
        for(String r:records){
            String[] arr = r.split(" ");
            if(hm.containsKey(arr[1])){
                hm.get(arr[1]).add(arr[0]);
            }else{
                hm.put(arr[1],new ArrayDeque<>());
                hm.get(arr[1]).add(arr[0]);
            }
        }
        Map<Integer,Integer> tm = new TreeMap<>();
        
        for(String k:hm.keySet()){
            Queue<String> q = hm.get(k);
            if(q.size()%2!=0) q.add("23:59");
            int kk = Integer.parseInt(k);
            
            while(q.size()>1){
                String[] in = q.poll().split(":");
                String[] out = q.poll().split(":");
                int outnum = Integer.parseInt(out[0])*60 + Integer.parseInt(out[1]);
                int innum = Integer.parseInt(in[0])*60 + Integer.parseInt(in[1]);
                int num = outnum - innum;
                tm.put(kk,tm.getOrDefault(kk,0)+num);
            }
        }
        
        int[] answer = new int[tm.size()];
        int idx=0;
        for(int k:tm.keySet()){
            int min = tm.get(k)-fees[0];
            int total = fees[1];
            if(min>0){
                total+= Math.ceil((double)min/fees[2]) * fees[3];
            }
            
            answer[idx++] = total;
        }
        return answer;
    }
}