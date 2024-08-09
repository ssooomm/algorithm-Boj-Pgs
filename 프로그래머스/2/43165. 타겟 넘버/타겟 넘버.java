class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers,target,0,0);
    }
    int dfs(int[] numbers,int target, int cur, int tmp){
        if(cur==numbers.length){
            if(target==tmp) return 1;
            else return 0;
        }
        int sum=0;
        sum+=dfs(numbers,target,cur+1,tmp+numbers[cur]);
        sum+=dfs(numbers,target,cur+1,tmp-numbers[cur]);
        return sum;
    }
}