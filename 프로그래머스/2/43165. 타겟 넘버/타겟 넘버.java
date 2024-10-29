class Solution {
    static int count;
    static int N;
    public int solution(int[] numbers, int target) {
        count = 0;
        N = numbers.length;
        
        dfs(0,0,numbers,target);
        return count;
    }
    public void dfs(int depth, int tot, int[] numbers, int target){
        if(depth==N){
            //로직
            if(tot==target){
                count++;
            }
            return;
        }
        dfs(depth+1,tot+numbers[depth],numbers,target);
        dfs(depth+1,tot-numbers[depth],numbers,target);
        
    }
    
}