class Solution {
    public int solution(int hp) {
        int answer = 0;
        int five = hp/5;
        hp %= 5;
        int three = hp/3;
        int one = hp%3;
        return five+three+one;
    }
}