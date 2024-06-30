import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int s:scoville){
            minHeap.add(s);
        }
        while(true){
            if(minHeap.peek()>=K){
                break;
            }
            else if(minHeap.size()==1){
                answer = -1;
                break;
            }
            else{
                Integer newS = minHeap.poll() + minHeap.poll()*2;
                minHeap.add(newS);
                answer++;
            }
        }
        return answer;
    }
}