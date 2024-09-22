class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int n = num*(num-1)/2;
        total-=n;
        total/=num;
        for(int i=0;i<num;i++){
            answer[i] = total++;
        }
        return answer;
    }
}