import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        int[] answer = {};
        List<Integer> intArr = new ArrayList<>();
        String[] arr = my_string.split("");
        for(String ch:arr){
            if(ch.matches("-?\\d+(\\.\\d+)?")){
                intArr.add(Integer.parseInt(ch));
            }
        }
        answer = intArr.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        return answer;
    }
}