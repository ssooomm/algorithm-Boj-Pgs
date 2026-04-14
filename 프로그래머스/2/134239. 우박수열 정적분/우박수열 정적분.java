import java.util.*;

class Solution {
    static List<Double> list = new ArrayList<>();
    static int n=0;
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        lc(k);
        
        for(int i=0;i<ranges.length;i++){
            int a = ranges[i][0];
            int b = n+ranges[i][1];
            if(a==b) answer[i] = 0;
            else if(a>b) answer[i] = -1;
            else{
                for(int j=a;j<b;j++){
                    answer[i]+=list.get(j);
                }
            }
        }
        
        return answer;
    }
    
    public void lc(int k){
        int kk=0;
        while(k>1){
            if(k%2==0){
                kk=k/2;
            }
            else{
                kk=3*k+1;
            }
            list.add((double)(k+kk)/2);
            k=kk;
        }
        n = list.size();
        
        
    }
}