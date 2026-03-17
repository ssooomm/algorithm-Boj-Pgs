class Solution {
    public long[] solution(long[] numbers) {
        int n = numbers.length;
        long[] answer = new long[n];
        
        for(int i=0;i<n;i++){
            long x = numbers[i];
            if(x%2==0){ //짝수는 걍 숫자+1
                answer[i] = x+1;
            }else{
                //가장 오른쪽의 01을 10으로
                String str = "0"+Long.toString(numbers[i],2);
                int last0 = str.lastIndexOf("0");
                
                StringBuilder sb = new StringBuilder(str);
                sb.setCharAt(last0,'1');
                sb.setCharAt(last0+1,'0');
                
                answer[i] = Long.parseLong(sb.toString(),2);
            }
        }

        return answer;
    }
}