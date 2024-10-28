import java.util.*;

class Solution {
    public int solution(int n) {
        int count = 0;
        int i = 1;
        while(count<n){
            if(i%3!=0 && !String.valueOf(i).contains("3")){
                count++;
            }
            if(count<n){
                i++;
            }
        }
        return i;
    }
}