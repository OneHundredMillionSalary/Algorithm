package week_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1049 {
    public static void main(String[] args) {
        new BJ_1049().solve();
    }

    int N;
    int M;
    int packageMin;
    int pieceMin;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            packageMin = 2147483647;
            pieceMin = 2147483647;


            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                packageMin = Math.min(Integer.parseInt(st.nextToken()), packageMin);
                pieceMin = Math.min(Integer.parseInt(st.nextToken()), pieceMin);
            }

            if (packageMin > pieceMin * 6) {
                packageMin = pieceMin * 6;
            }

            int curr = 0;
            int pack = 0;

            curr += (N / 6 * packageMin);
            if (N % 6 == 0) {
                pack = curr;
            } else {
                pack = curr + packageMin;
            }
            curr += (N % 6 * pieceMin);

            System.out.println(Math.min(pack, curr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
