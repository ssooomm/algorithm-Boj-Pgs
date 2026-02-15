class Solution {
    static int cnt=0;
    public int solution(int[] numbers, int target) {
        bt(0,numbers[0],target,numbers);
        bt(0,-numbers[0],target,numbers);
        return cnt;
    }
    
    static void bt(int i,int sum,int target,int[] numbers){
        if(i==numbers.length-1){
            if(sum==target)
                cnt++;
            return;
        }

        bt(i+1,sum+numbers[i+1],target,numbers);
        bt(i+1,sum-numbers[i+1],target,numbers);
    }
}