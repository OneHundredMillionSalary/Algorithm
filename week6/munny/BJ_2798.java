package week_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2798 {
    public static void main(String[] args) {
        new BJ_2798().solve();
    }

    int N;
    int T;
    int[] arr;
    boolean[] visit;
    int result = 0;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            arr = new int[N];
            visit = new boolean[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int c1;
            int c2;
            int c3;

            int curr;

            for (int i = 0; i < N; i++) {
                c1 = arr[i];
                for (int j = 0; j < N; j++) {
                    if (j == i) {
                        continue;
                    }
                    c2 = arr[j];
                    for (int k = 0; k < N; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        c3 = arr[k];

                        curr = c1 + c2 + c3;
                        if (curr <= T) {
                            result = Math.max(result, curr);
                        }
                    }
                }
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
