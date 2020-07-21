package week_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1759 {
    public static void main(String[] args) {
        new BJ_1759().solve();
    }

    int L;
    int N;
    String[] arr;
    boolean[] visit;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            arr = new String[N];
            visit = new boolean[N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = st.nextToken();
            }

            Arrays.sort(arr);
            dfs("", 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void dfs(String s, int depth) {
        if (depth == L) {
            int vowelCnt = 0;
            int consonantCnt = 0;

            for (char c : s.toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowelCnt++;
                } else {
                    consonantCnt++;
                }
            }

            if (vowelCnt >= 1 && consonantCnt >= 2) {
                System.out.println(s);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                String newS = s + arr[i];

                char[] cArr = newS.toCharArray();
                Arrays.sort(cArr);
                if (Arrays.equals(cArr, newS.toCharArray())) {
                    dfs(newS, depth + 1);
                }

                visit[i] = false;
            }
        }

    }
}
