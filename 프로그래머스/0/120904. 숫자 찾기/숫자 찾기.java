class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String str = num+"";
        String[] arr = str.split("");
        String kStr = k+"";
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(kStr)){
                answer = i+1;
                break;
            }
        }
        if(answer==0) return -1;
        return answer;
    }
}