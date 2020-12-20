
// https://level.goorm.io/exam/51584/%EA%B5%AC%EB%A6%84-%EA%B2%8C%EC%9E%841-%EB%AF%B8%EC%99%84%EC%84%B1/quiz/1
// 전등 프로그래밍

import java.io.*;
import java.util.StringTokenizer;

public class Q51584 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken()), cal = Integer.parseInt(st.nextToken());
        int[][] arr = new int[row + 1][cal + 1];

        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= cal; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int N = Integer.parseInt(br.readLine());
        int[][] commands = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            commands[i][0] = Integer.parseInt(st.nextToken());
            commands[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] result = solution(row, cal, arr, N, commands);

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= cal; j++) {
                if (j != 1) sb.append(" ");
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static int[][] solution(int row, int cal, int[][] arr, int n, int[][] commands) {
        boolean[] rowCheck = new boolean[row + 1], calCheck = new boolean[cal + 1];

        for (int[] command : commands) {
            int c = command[1];
            if (command[0] == 0) rowCheck[c] = !rowCheck[c];
            else calCheck[c] = !calCheck[c];
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= cal; j++) {
                if(rowCheck[i] ^ calCheck[j]) arr[i][j] = (arr[i][j] == 1 ? 0 : 1);
            }
        }

        return arr;
    }
}
