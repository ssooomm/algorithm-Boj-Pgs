class Solution {
    public int[] solution(long begin, long end) {
        int n = (int)(end-begin+1);
        int[] answer = new int[n];
        
        for(int i=0;i<n;i++){
            answer[i] = get((int)(begin+i));
        }

        return answer;
    }
    
    int get(int n){
        if(n==1) return 0;
        
        int ans = 1;
        
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(n/i<=10000000) return n/i;
                
                ans = i;
            }
            
        }
        
        return ans; //소수
    }
    
}