class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] arr = my_string.split("");
        String num = "";
        for(String s: arr){
             try{
                 int n = Integer.parseInt(s);
                 num += n;
            }catch(Exception ex){
                 if(!num.equals("")){
                     answer+=Integer.parseInt(num);
                    num="";
                 }
                 
            }
        }
        if(!num.equals("")){
                     answer+=Integer.parseInt(num);
                    num="";
                 }
        return answer;
    }
}