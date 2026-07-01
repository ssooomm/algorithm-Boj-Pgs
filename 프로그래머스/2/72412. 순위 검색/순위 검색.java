import java.util.*;

class Solution {
    class Node{
        String lang;
        String pos;
        String career;
        String food;
        int score;
        
        public Node(String lang, String pos, String career, String food, int score) {
            this.lang = lang;
            this.pos = pos;
            this.career = career;
            this.food = food;
            this.score = score;
        }
    }
    
    public int[] solution(String[] info, String[] query) {
        int in = info.length;
        int qn = query.length;
        int[] answer = new int[qn];
        
        List<Node> list = new ArrayList<>();

        for(String i:info){
            String[] arr = i.split(" ");
            list.add(new Node(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4])));
        }
        
        for(int i=0;i<qn;i++){
            int cnt=0;
            String[] arr = query[i].split(" ");
            for(int j=0;j<in;j++){
                
                Node n = list.get(j);
                
                if(!arr[0].equals(n.lang)&&!arr[0].equals("-")) continue;
                if(!arr[2].equals(n.pos)&&!arr[2].equals("-")) continue;
                if(!arr[4].equals(n.career)&&!arr[4].equals("-")) continue;
                if(!arr[6].equals(n.food)&&!arr[6].equals("-")) continue;
                if(Integer.parseInt(arr[7])>n.score) continue;
                
                cnt++;       
            }
            
            answer[i] = cnt;
        }
        return answer;
    }
}