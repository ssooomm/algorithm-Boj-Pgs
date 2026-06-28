import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Deque<Integer> stackd = new ArrayDeque<>();
        Deque<Integer> stackp = new ArrayDeque<>();
        
        boolean flagd=false,flagp=false;
        for(int i=0;i<n;i++){
            if(deliveries[i]!=0) flagd=true;
            if(pickups[i]!=0) flagp=true;
            stackd.push(i);
            stackp.push(i);
        }
        if(!flagd&&!flagp) return 0;
        
        while(!stackd.isEmpty()||!stackp.isEmpty()){
            long totalx=0,totaly=0,x=-1,y=-1;
            if(!stackd.isEmpty()){
                x = stackd.peek();
                while(!stackd.isEmpty()){
                    int tmp = stackd.peek();
                    if(totalx+deliveries[tmp]<=cap){
                        stackd.pop();
                        totalx+=deliveries[tmp];
                    }else{
                        deliveries[tmp]-=cap-totalx;
                        break;
                    }
                }
            }
            if(!stackp.isEmpty()){
                y = stackp.peek();
                while(!stackp.isEmpty()){
                    int tmp = stackp.peek();
                    if(totaly+pickups[tmp]<=cap){
                        stackp.pop();
                        totaly+=pickups[tmp];
                    }else{
                        pickups[tmp]-=cap-totaly;
                        break;
                    }
                }
            }
            
            answer+=Math.max(x,y)+1;
        }
        
        return answer*2;
    }
}