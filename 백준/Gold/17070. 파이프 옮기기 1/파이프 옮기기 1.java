import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0, 1, 0); // 처음은 (0,0)-(0,1) 가로 방향

        System.out.println(count);
    }

    static void dfs(int r, int c, int dir) {
        if (r == n - 1 && c == n - 1) {
            count++;
            return;
        }

        // 가로 방향
        if (dir == 0) {
            // → 이동
            if (c + 1 < n && map[r][c + 1] == 0)
                dfs(r, c + 1, 0);
            // ↘ 이동
            if (r + 1 < n && c + 1 < n && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0)
                dfs(r + 1, c + 1, 2);
        }

        // 세로 방향
        else if (dir == 1) {
            // ↓ 이동
            if (r + 1 < n && map[r + 1][c] == 0)
                dfs(r + 1, c, 1);
            // ↘ 이동
            if (r + 1 < n && c + 1 < n && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0)
                dfs(r + 1, c + 1, 2);
        }

        // 대각선 방향
        else {
            // → 이동
            if (c + 1 < n && map[r][c + 1] == 0)
                dfs(r, c + 1, 0);
            // ↓ 이동
            if (r + 1 < n && map[r + 1][c] == 0)
                dfs(r + 1, c, 1);
            // ↘ 이동
            if (r + 1 < n && c + 1 < n && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0)
                dfs(r + 1, c + 1, 2);
        }
    }
}