import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        char last = words[0].charAt(words[0].length()-1);
        char first = ' ';
        for(int i=1;i<words.length;i++){
            String w = words[i];
            first = w.charAt(0);
            if(set.contains(w)){
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                return answer;
            }else{
                if(last==first){
                    set.add(w);
                    last = w.charAt(w.length()-1);
                }
                else{
                    answer[0] = (i%n)+1;
                    answer[1] = (i/n)+1;
                    return answer;
                }
            }
        }

        return answer;
    }
}