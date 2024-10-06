import java.util.*;

// class Solution {
//     public String solution(String bin1, String bin2) {
//         String answer = "";
        
//         String
        
// //         int len1 = bin1.length();
// //         int len2 = bin2.length();
        
// //         int max = Math.max(len1,len2);
        
// //         int[] arr1 = new int[max];
// //         int[] arr2 = new int[max];
// //         List<Integer> ans = new ArrayList<>();
        
// //         for(int i=max-1, j=len1-1;j>=0;i--,j--){
// //             arr1[i] = bin1.charAt(j) - '0';
// //         }
// //         for(int i=max-1, j=len2-1;j>=0;i--,j--){
// //             arr2[i] = bin2.charAt(j) - '0';
// //         }
        
// //         for(int i=max-1;i>=0;i--){
// //             ans.add(arr1[i]+arr2[i]);
// //         }
// //         System.out.println(ans);
// //         int next = 0;
// //         for(int i=0;i<ans.size();i++){
// //             if(next=)
// //             if(ans.get(i)==2){
// //                 answer+="0";
// //                 next = 1;
// //             }else{
// //                 answer+="1";
// //                 next = 0;
// //             }
            
// //         }
        
//         return answer;
//     }
// }

class Solution {
    public String solution(String bin1, String bin2) {
        int num1 = Integer.parseInt(bin1, 2);
        int num2 = Integer.parseInt(bin2, 2);
        int result = num1 + num2;
        String answer = Integer.toBinaryString(result);
        
        return answer;
    }
}