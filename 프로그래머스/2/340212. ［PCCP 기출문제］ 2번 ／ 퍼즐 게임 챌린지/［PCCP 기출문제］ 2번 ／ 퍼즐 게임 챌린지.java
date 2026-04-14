class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int d:diffs){
            min = Math.min(min,d);
            max = Math.max(max,d);
        }
        int n = diffs.length;
        
        while(min<=max){
            int mid = (min+max)/2;
            long sum=0;
            boolean flag = true;
            for(int i=0;i<n;i++){
                if(diffs[i]<=mid){
                    sum+=times[i];
                }else{
                    int tmp = diffs[i]-mid;
                    int prev = 0;
                    if(i!=0){
                        prev = times[i-1];
                    }
                    sum+=(tmp*(prev+times[i])+times[i]);
                }
                if(sum>limit){
                    flag= false;
                    break;
                }
            }
            if(flag) max = mid-1;
            else min = mid+1;
        }
        
        return min;
    }
}