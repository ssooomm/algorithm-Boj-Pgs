class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        String[] arr = my_string.split("");
        for(String s: arr){
            if(letter.equals(s)) continue;
            else answer+=s;
        }
        return answer;
    }
}