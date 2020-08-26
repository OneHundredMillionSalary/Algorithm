package week_14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_2217 {
    public static void main(String[] args) {
        new BJ_2217().solve();
    }

    int N;
    Integer[] arr;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            arr = new Integer[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            int curr = 0;
            int max = 0;
            for (int i = 0; i < N; i++) {
                curr = arr[i] * (i + 1);
                if (max < curr) {
                    max = curr;
                }
            }

            System.out.println(max);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
