class Solution {
    public int[] solution(long begin, long end) {
        int n = (int)(end - begin + 1);
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++){
            answer[i] = get((int)(begin + i));
        }

        return answer;
    }
    
    int get(int n){
        if(n == 1) return 0;
        
        int ans = 1; // 약수를 못 찾으면 기본값은 1 (소수 케이스)
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){ // 나누어 떨어지는 '진짜 약수'일 때만!
                if(n / i <= 10000000) {
                    return n / i; 
                }
                ans = i; // n/i가 1000만을 넘어가면 짝꿍인 i를 정답 후보로 백업
            }
        }
        
        return ans; 
    }
}