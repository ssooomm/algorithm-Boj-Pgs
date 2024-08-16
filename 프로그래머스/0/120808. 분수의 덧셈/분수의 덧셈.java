class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int d = gcd(denom1, denom2);
        int d1 = denom1/d;
        int d2 = denom2/d;
        int lcm = d*d1*d2;
        int n1 = numer1*d2;
        int n2 = numer2*d1;
        
        int numer = n1+n2;
        int denom = lcm;
        
        int lcm2 = gcd(numer,denom);
        answer[0] = numer/lcm2;
        answer[1] = denom/lcm2;
        return answer;
    }
    
    int gcd(int a, int b){
        if(a%b==0) return b;
        return gcd(b,a%b);
    }
}