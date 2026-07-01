import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int x = routes.length;
        
        List<String>[] list = new ArrayList[x];
        for(int i=0;i<x;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<x;i++){
            int[] r = routes[i];
            
            //최초 0초일때 우선 기록
            int[] st = points[r[0]-1];
            int curr = st[0];
            int curc = st[1];
            list[i].add(curr+","+curc);
            
            for(int j=1;j<r.length;j++){
                int[] ne = points[r[j]-1];
                int ner = ne[0];
                int nec = ne[1];
                
                while(curr!=ner){
                    if(curr<ner) curr++;
                    else curr--;
                    list[i].add(curr+","+curc);
                }
                
                while(curc!=nec){
                    if(curc<nec) curc++;
                    else curc--;
                    list[i].add(curr+","+curc);
                }
            }
            
        }
        
        int i=0;
        while(true){
            Map<String,Integer> hm = new HashMap<>();
            int end=0;
            
            for(int j=0;j<x;j++){
                if(list[j].size()<=i){
                    end++;
                    continue;
                }
                String str = list[j].get(i);
                hm.put(str,hm.getOrDefault(str,0)+1);
            }
            
            if(end==x) break;
            for(String k:hm.keySet()){
                if(hm.get(k)>1) answer++;
            }
            
            i++;
        }

        
        return answer;
    }
    
}