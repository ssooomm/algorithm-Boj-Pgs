class Solution {
    public int solution(int n) {
        int answer = 0;
        //최대 공약수
        int tmp = gcd(n,6);
        return n/tmp;
    }
    
    public int gcd(int num1,int num2){
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1%num2);
    }
}