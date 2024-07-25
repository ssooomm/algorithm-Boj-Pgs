import java.util.*;

class Solution {
    public int solution(int n) {
        int res = (int)Math.sqrt(n);
        int answer = (res*res==n)? 1:2;
        return answer;
    }
}