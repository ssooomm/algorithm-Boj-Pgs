class Solution {
    public int[] solution(int n) {
        int len = (n%2==0)? n/2:n/2+1;
        int[] answer = new int[len];
        for(int i=1,j=0;i<=n;i+=2,j++){
            answer[j] = i;
        }
        return answer;
    }
}