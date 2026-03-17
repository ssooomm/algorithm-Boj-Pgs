import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int n = truck_weights.length;
        int[] in = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        
        int sum=0;
        int time=0;
        
        for(int i=0;i<n;i++){
            while(!q.isEmpty()&&sum+truck_weights[i]>weight){
                int idx=q.poll();
                sum-=truck_weights[idx];
                time = Math.max(time,in[idx]+bridge_length);
            }
            
            q.add(i);
            in[i] = time++;
            sum+=truck_weights[i];
        }
        
        return time+bridge_length;
    }
}