class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(0,target, numbers, 0);
    }
    
    int dfs(int curr, int target, int[] numbers, int idx){
        int cnt=0;
        if(idx==numbers.length){
            if(curr==target) return 1;
            else return 0;
        }
        cnt+=dfs(curr+numbers[idx], target, numbers, idx+1);
        cnt+=dfs(curr-numbers[idx], target, numbers, idx+1);
        return cnt;
    }
}