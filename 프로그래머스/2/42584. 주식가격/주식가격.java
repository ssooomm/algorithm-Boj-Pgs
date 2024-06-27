class Solution {
    public int[] solution(int[] prices) {
        // int[] answer = {};
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++) {
            int v = prices[i];
            for(int j=i+1; j<prices.length; j++) {
                answer[i]++;
                if(prices[j] < v) {
                    break;
                }
            }

        }
        return answer;
    }
}