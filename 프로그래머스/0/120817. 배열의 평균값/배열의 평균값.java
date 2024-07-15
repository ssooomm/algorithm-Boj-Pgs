class Solution {
    public double solution(int[] numbers) {
        double sum = 0;
        int len = numbers.length;
        for(int n:numbers){
            sum+=n;
        }
        double answer = sum/len;
        
        return answer;
    }
}