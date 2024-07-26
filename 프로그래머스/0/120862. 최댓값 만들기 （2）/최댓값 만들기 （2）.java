import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int plus = numbers[numbers.length-1] * numbers[numbers.length-2];
        int minus = 0;
        int i=0;
        for(;i<numbers.length;i++){
            if(numbers[i]>0) break;
        }
        if(i>1) minus = numbers[i-1] * numbers[i-2];
        else return plus;
        answer = (minus>plus)? minus:plus;
        return answer;
    }
}