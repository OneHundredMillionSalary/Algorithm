package week_18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1026 {
    public static void main(String[] args) {
        new BJ_1026().solve();
    }

    int N;
    int[] aArr;
    Integer[] bArr;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            aArr = new int[N];
            bArr = new Integer[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                aArr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                bArr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(aArr);
            Arrays.sort(bArr, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            int result = 0;
            for (int i = 0; i < N; i++) {
                result += (aArr[i] * bArr[i]);
            }

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
