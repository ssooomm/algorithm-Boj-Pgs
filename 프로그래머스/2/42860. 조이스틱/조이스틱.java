class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        
        for(int i=0;i<len;i++){
            char ch = name.charAt(i);
            answer+=Math.min(ch-'A','Z'-ch+1);
        }
        
        int move = len-1;
        
        for(int i=0;i<len;i++){
            //연속된 a끝점 찾기
            int ne = i+1;
            while(ne<len && name.charAt(ne)=='A'){
                ne++;
            }
            
            //오로가다가 빽해서 뒤로
            int r = i*2+(len-ne);
            //왼가다가 다시 오로
            int l = (len-ne)*2+i;
            
            move = Math.min(move,Math.min(r,l));
        }
        
        return answer+move;
    }
}