import java.io.*;

public class Main {
    static String[] star;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
       
        int n = Integer.parseInt(br.readLine());
        star = new String[n];
        // 별 기본 규칙
        star[0] = "  *  ";
        star[1] = " * * ";
        star[2] = "*****";
        
        //별 찍기 - 거듭제곱
        for(int i=1; 3 * Math.pow(2, i) <= n;i++)
            printStar(i); // n=24 -> i= 1~3
            
        //별 찍기 결과 저장
        for(int i=0;i<n;i++)
            sb.append(star[i] + "\n");

        System.out.println(sb);
       
    }
    
    //별 찍기
    static void printStar(int i) {
        int bottom = (int) (3 * Math.pow(2, i));	//아래 최대 행
        int middle = bottom/2;	//위와 아래를 구분하는 행
        
        //아래 부분 대응하는 별 점화식 적용
        for(int j=middle;j<bottom;j++)
            star[j] = star[j-middle] + " " + star[j-middle];
        String blank = " ".repeat(middle);

        //위 부분 대응하는 별에 빈 칸 추가
        for(int j=0;j<middle;j++)
            star[j] = blank + star[j] + blank;
    }
}