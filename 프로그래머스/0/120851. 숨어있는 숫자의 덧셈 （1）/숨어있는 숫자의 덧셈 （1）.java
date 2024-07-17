class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(String str:my_string.split("")){
            try{
                int tmp = Integer.parseInt(str);
                answer+=tmp;
            }catch(Exception e){
                continue;
            }
        }
    
        return answer;
    }
}