class Solution {
    public String solution(String s) {
        String answer = "";
        String[] word = s.split("");
        boolean flag = true;
        for(int i=0;i<word.length;i++){
            if(flag){
                answer+=word[i].toUpperCase();
                flag = false;
            }else{
                answer+=word[i].toLowerCase();
            }
            if(word[i].equals(" ")){
                flag = true;
            }
        }
        return answer;
    }
}