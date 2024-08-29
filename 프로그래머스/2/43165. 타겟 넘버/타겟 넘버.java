class Solution {
    public int solution(int[] numbers, int target) {
        return backtrack(0,0,numbers,target);
    }
    
    public int backtrack(int cur, int idx, int[] numbers, int target){
        if(idx==numbers.length){
            if(cur==target) return 1;
            else return 0;
        }
        
        int sum = 0;
        sum += backtrack(cur+numbers[idx],idx+1,numbers,target);
        sum += backtrack(cur-numbers[idx],idx+1,numbers,target);
        return sum;
    }
}