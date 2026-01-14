class Solution {
    public int solution(int[] arr) {
        int bef = arr[0];
        for(int i=1;i<arr.length;i++){
            int tmp = fun(bef,arr[i]);
            int x = bef/tmp;
            int y = arr[i]/tmp;
            bef = tmp*x*y;
        }
        
        
        return bef;
    }
    
    public int fun(int a, int b){
        if(a%b==0) return b;
        else{
            return fun(b,a%b);
        }
    }
}