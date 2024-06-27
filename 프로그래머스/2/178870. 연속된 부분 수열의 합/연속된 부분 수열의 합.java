import java.util.ArrayList;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        ArrayList<Integer[]> list = new ArrayList<>();

        int st=0;
        int end=0;
        int sum=0;
        
        while (st < sequence.length && end <sequence.length) {
            sum+=sequence[end];
            if(sum >= k){
                while(sum>k){
                    sum -= sequence[st++];
                }
                if(sum == k){
                    Integer[] seqArr = {st, end};
                    list.add(seqArr);
                    sum -= sequence[st++];
                }
            }
            if(sum < k){
                end++;
            }
        }
        
        int min = Integer.MAX_VALUE;
        Integer[] value = new Integer[2];
        for(Integer[] arr:list){
            int len = arr[1] - arr[0];
            if(min>len){
                min = len;
                value = arr;
                
            }
        }

        answer[0] = value[0];
        answer[1] = value[1];
        
        return answer;
    }
}