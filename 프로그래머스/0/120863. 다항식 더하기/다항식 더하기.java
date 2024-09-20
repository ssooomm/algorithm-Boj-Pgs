class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String[] arr = polynomial.split(" ");
        int x = 0;
        int a = 0;
        for(String str:arr){
            if(str.contains("x")){
                String num = str.replace("x","");
                if(num.equals("")) x+=1;
                else x+=Integer.parseInt(num);
            }
            else if(str.equals("+")) continue;
            else{
                a+=Integer.parseInt(str);
            }
        }
        if(x==0) answer+=a;
        else if(a==0){
            if(x==1) answer+="x";
            else answer+=x+"x";
        }
        else{
            if(x==1) answer+="x";
            else answer+=x+"x";
            answer+=" + "+a;
        }
        return answer;
    }
}