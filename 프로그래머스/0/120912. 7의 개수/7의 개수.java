class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int n:array){
            String str = n+"";
            String[] arr = str.split("");
            for(String tmp:arr){
                if(tmp.equals("7")) answer++;
            }
        }
        return answer;
    }
}