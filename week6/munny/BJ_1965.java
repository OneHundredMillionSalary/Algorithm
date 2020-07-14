package week_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1965 {
    public static void main(String[] args) {
        new BJ_1965().solve();
    }

    int N;
    int[] arr;
    ArrayList<Integer> list = new ArrayList<>();

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            list.add(arr[0]);

            int idx;
            for (int i = 1; i < N; i++) {
                idx = find(arr[i]);
                if (idx == -1) {
                    list.add(arr[i]);
                } else {
                    list.set(idx, arr[i]);
                }
            }

            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int find(int num) {
        int low = 0;
        int high = list.size() - 1;
        int mid;
        int result = -1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (num <= list.get(mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}
