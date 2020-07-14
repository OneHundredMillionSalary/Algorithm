package week_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2110 {
    public static void main(String[] args) {
        new BJ_2110().solve();
    }

    int N;
    int M;
    int[] arr;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N];

            int max = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                max = Math.max(max, arr[i]);
            }
            Arrays.sort(arr);

            int low = 1;
            int high = max;
            int mid;
            int curr;
            int cnt;
            int result = 0;

            while (low <= high) {
                mid = (low + high) / 2;
                curr = arr[0];
                cnt = 0;

                for (int i = 1; i < N; i++) {
                    if (arr[i] - curr >= mid) {
                        curr = arr[i];
                        cnt++;
                    }
                }

                if (cnt >= M - 1) {
                    result = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
