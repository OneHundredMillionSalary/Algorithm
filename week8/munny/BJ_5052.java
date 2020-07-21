package week_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_5052 {
    public static void main(String[] args) {
        new BJ_5052().solve();
    }

    int T;
    int N;
    String[] arr;

    class Trie {
        Trie[] child;
        boolean isTerminate;

        Trie() {
            child = new Trie[10];
        }
    }

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            T = Integer.parseInt(br.readLine());

            home:
            for (int t = 0; t < T; t++) {
                N = Integer.parseInt(br.readLine());
                arr = new String[N];

                Trie trie = new Trie();
                String num;
                Trie node;

                for (int n = 0; n < N; n++) {
                    arr[n] = br.readLine();
                }

                Arrays.sort(arr);

                for (int n = 0; n < N; n++) {
                    num = arr[n];
                    node = trie;
                    for (int i = 0; i < num.length(); i++) {
                        if (node.child[num.charAt(i) - '0'] == null) {
                            node.child[num.charAt(i) - '0'] = new Trie();
                        }
                        node = node.child[num.charAt(i) - '0'];

                        if (node.isTerminate) {
                            System.out.println("NO");
                            continue home;
                        }

                        if (i == num.length() - 1) {
                            node.isTerminate = true;
                        }
                    }
                }
                System.out.println("YES");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
