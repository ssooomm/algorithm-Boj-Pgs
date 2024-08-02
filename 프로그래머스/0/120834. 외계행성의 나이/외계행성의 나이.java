class Solution {
    public String solution(int age) {
        String answer = "";
        String ageStr = age+"";
        int len = ageStr.length();
        char[] arr = new char[len];
        
        for(int i=len-1;i>=0;i--){
            int rest = age%10;
            char c = (char)(rest+97);
            arr[i] = c;
            age/=10;
        }
        
        
        answer = new String(arr);
        return answer;
    }
}