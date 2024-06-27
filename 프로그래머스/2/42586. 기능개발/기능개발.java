import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        int[] rest = new int[progresses.length];
        double[] days = new double[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            rest[i] = 100 - progresses[i];
            days[i] = Math.ceil((double) rest[i] / speeds[i]);
        }

        ArrayList<Integer> al = new ArrayList<>();
        int i = 0, j = 0;
        while (true) {
            int cnt = 1;
            for (j = i + 1; j < progresses.length; j++) {
                if (days[i] >= days[j]) {
                    cnt++;
                } else {
                    break;
                }
            }
            i = j;
            al.add(cnt);
            if (i == progresses.length) {
                break;
            }

        }
        answer = al.stream().mapToInt(x->x).toArray();
        return answer;
    }
}