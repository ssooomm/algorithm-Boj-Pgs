import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
                Queue<Integer> queue = new LinkedList<>();

        int time = 0;
        int total_w = 0;
        int i=0;
        while(i<truck_weights.length){
//            if (queue.size() < bridge_length) {
//                if (total_w + truck_weights[i] <= weight) {
//                    queue.add(truck_weights[i]);
//                    total_w += truck_weights[i];
//                    i++;
//                    time++;
//                } else {
//                    queue.add(0);
//                    time++;
//                }
//            } else {
//                int tmp = queue.poll();
//                total_w -= tmp;
//                queue.add(truck_weights[i]);
//                total_w += truck_weights[i];
//                i++;
//                time++;
//            }

            if (queue.size() >= bridge_length) {
                int tmp = queue.poll();
                total_w -= tmp;
            }
            if (total_w + truck_weights[i] <= weight) {
                queue.add(truck_weights[i]);
                total_w += truck_weights[i];
                i++;
                time++;
            } else {
                queue.add(0);
                time++;
            }

        }

        if(queue.size()>0){
            time+=bridge_length;
        }

        answer = time;
        return answer;
    }
}