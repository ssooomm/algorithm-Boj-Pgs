import java.util.*;

class Solution {
    public String solution(String my_string) {
        char[] c = my_string.toLowerCase().toCharArray();
        Arrays.sort(c);
        return new String(c);
        
        // String answer = "";
        // String[] arr = my_string.split("");
        // for(int i=0;i<arr.length;i++){
        //     arr[i] = arr[i].toLowerCase();
        // }
        // Arrays.sort(arr);
        // for(String str:arr){
        //     answer+=str;
        // }
        // return answer;
    }
}