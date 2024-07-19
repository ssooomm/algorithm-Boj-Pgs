public class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        backtrack(0, 0, numbers, target);
        return answer;
    }

    // cur: 지금까지 더한 숫자
    void backtrack(int cur, int idx, int[] numbers, int target) {
        // basecase
        if(idx == numbers.length) { //끝까지 올 때까지
            if(target == cur){
                answer++;
            }
            return;
        }
        
        // recursive call
        backtrack(cur+numbers[idx], idx+1, numbers, target);
        backtrack(cur-numbers[idx], idx+1, numbers, target);
    }
}
