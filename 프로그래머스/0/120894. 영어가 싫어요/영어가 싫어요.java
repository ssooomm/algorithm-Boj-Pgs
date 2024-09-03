class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String tmp = "", res = "";
    
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0;i<numbers.length();i++){
            tmp+=numbers.charAt(i);
            for(int j=0;j<10;j++){
                if(words[j].equals(tmp)){
                    res+=j+"";
                    tmp = "";
                }
            }
        }
        
        return Long.parseLong(res);
    }
}