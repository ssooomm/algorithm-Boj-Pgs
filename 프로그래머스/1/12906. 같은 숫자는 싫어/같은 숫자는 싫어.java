import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> al = new ArrayList<>();
        
        int tmp = arr[0];
        al.add(tmp);
        for(int i=1;i<arr.length;i++){
            if(tmp!=arr[i]){
                al.add(arr[i]);
                tmp = arr[i];
            }
        }
        // Arraylist를 int[]로 반환하는 방법은 이렇게 밖에 없나?
        // answer = al.toArray();
        Integer[] iarr = al.toArray(new Integer[0]);
        int[] answer = new int[iarr.length];
        
        for(int i=0;i<iarr.length;i++){
            answer[i] = iarr[i];
        }
        return answer;
    }
}