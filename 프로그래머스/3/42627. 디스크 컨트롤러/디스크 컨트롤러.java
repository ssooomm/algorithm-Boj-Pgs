import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs,(j1,j2)->j1[0]-j2[0]);
        Queue<int[]> pq = new PriorityQueue<>((j1,j2)->j1[1]-j2[1]);
        
        int completedJob = 0;
        int curTime = 0;
        int jobIdx = 0;
        int respTime = 0;
        
        while(completedJob<jobs.length){
            while(jobIdx<jobs.length && jobs[jobIdx][0]<=curTime){
                pq.add(jobs[jobIdx++]);
            }
            
            if(!pq.isEmpty()){
                int[] cur = pq.remove();
                curTime += cur[1];
                respTime += curTime - cur[0];
                completedJob++;
            }
            else{
                curTime = jobs[jobIdx][0];
            }
             
        }
        
        return respTime/jobIdx;
    }
}