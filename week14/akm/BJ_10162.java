package week_14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10162 {
    public static void main(String[] args) {
        new BJ_10162().solve();
    }

    int T;
    int A = 60 * 5;
    int B = 60;
    int C = 10;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            T = Integer.parseInt(br.readLine());

            int a = 0;
            int b = 0;
            int c = 0;

            a = T / A;
            T = T % A;

            b = T / B;
            T = T % B;

            c = T / C;
            T = T % C;

            if (T != 0) {
                System.out.println(-1);
                return;
            }

            System.out.println(a + " " + b + " " + c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
