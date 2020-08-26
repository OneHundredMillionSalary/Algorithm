package week_14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_9084 {
    public static void main(String[] args) {
        new BJ_9084().solve();
    }

    int T;
    Integer[] coin;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                int c = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());
                coin = new Integer[c];
                for (int j = 0; j < c; j++) {
                    coin[j] = Integer.parseInt(st.nextToken());
                }

                Arrays.sort(coin, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });

                int money = Integer.parseInt(br.readLine());
                int coinCnt = 0;

                for (int j = 0; j < c; j++) {
                    coinCnt += money / coin[j];
                    money %= coin[j];
                }

                System.out.println(coinCnt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
