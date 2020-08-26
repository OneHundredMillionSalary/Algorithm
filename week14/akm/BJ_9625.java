package week_14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9625 {
    public static void main(String[] args) {
        new BJ_9625().solve();
    }

    int N;

    int a = 1;
    int b = 0;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            int orgA;
            int orgB;

            for (int i = 0; i < N; i++) {
                orgA = a;
                orgB = b;

                a = 0;
                b += orgA;

                a += orgB;
            }

            System.out.println(a);
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
