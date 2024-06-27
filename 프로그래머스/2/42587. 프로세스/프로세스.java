class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        int[] rank = new int[priorities.length];
        int ranking = 1;
        int max = 0, max_i = 0;
        int cnt = 0;
        int start = 0;
        while (cnt<priorities.length) {
            max = 0;
            for(int i=0;i<priorities.length;i++){
                if(max<priorities[start]){
                    max = priorities[start];
                    max_i = start;
                }
                start++;
                start %= priorities.length;
            }
            rank[max_i] = ranking++;
            priorities[max_i] = 0;
            start = max_i;
            cnt++;
        }
        
        answer = rank[location];
        return answer;
    }
}