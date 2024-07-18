import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] answer = {};
        List<Integer> arr = new ArrayList<>();
        for(int i:numlist){
            if(i%n == 0) arr.add(i);
        }
        answer = arr.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}