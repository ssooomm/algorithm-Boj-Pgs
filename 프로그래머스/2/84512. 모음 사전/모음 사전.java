class Solution {
    static char[] arr = {'A','E','I','O','U'};
    static int ans=0;
    static int cnt=0;
    public int solution(String word) {
        bt("",word);
        return ans;
    }
    
    void bt(String str, String word){
        if(str.equals(word)){
            ans=cnt;
            return;
        }
        
        if(str.length()==5) return;
        
        for(int i=0;i<5;i++){
            cnt++;
            bt(str+arr[i],word);
        }
    }
}