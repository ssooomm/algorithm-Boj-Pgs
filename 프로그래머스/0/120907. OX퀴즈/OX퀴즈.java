class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int i = 0;
        for(String q:quiz){
            String[] arr = q.split(" ");
            int sum = Integer.parseInt(arr[0]);
            
            if(arr[1].equals("+")){
                sum += Integer.parseInt(arr[2]);
            }else if(arr[1].equals("-")){
                sum -= Integer.parseInt(arr[2]);
            }
            if(sum==Integer.parseInt(arr[4])){
                answer[i++] = "O";
            }else{
                answer[i++] = "X";
            }
            
        }
        
        return answer;
    }
}