class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int max=0, min=0;
        //Set<Integer> set = new HashSet<>();
        
        if(sides[0]>sides[1]){
            max=sides[0];
            min=sides[1];
        }else{
            max=sides[1];
            min=sides[0];
        }
        for(int i=1;i<=max;i++){
            if(i+min>max) answer++;
        }
        
        for(int i=max+1;i<min+max;i++){
            answer++;
        }
        
        return answer;
    }
}