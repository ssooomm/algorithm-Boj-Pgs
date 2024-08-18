class Solution {
    public int solution(int balls, int share) {
        int answer = 0;
        double n=1, nm=1;
        for(int i=balls;i>=share+1;i--){
            n*=i;
        }
        // System.out.println("n"+n);
        for(int i=balls-share;i>=2;i--){
            nm*=i;
        }
        System.out.println("nm"+nm);
        
        answer = (int)(n/nm);
        return answer;
    }
}