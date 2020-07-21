package week_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_9934 {
    public static void main(String[] args) {
        new BJ_9934().solve();
    }

    int D;
    int N;
    int idx;

    int[] arr;

    ArrayList<Integer>[] list;

    class BTree {
        int value = -1;
        BTree[] child;

        BTree() {
            child = new BTree[2];
        }
    }

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            D = Integer.parseInt(br.readLine());
            N = (int)Math.pow(2, D) - 1;
            arr = new int[N];
            list = new ArrayList[D];
            for (int i = 0; i < D; i++) {
                list[i] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            BTree root = new BTree();
            makeChild(root, 0);
            preSearch(root, 0);

            for (int i = 0; i < D; i++) {
                for (int v : list[i]) {
                    System.out.print(v + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void makeChild(BTree node, int depth) {
        if (depth == D - 1) {
            return;
        }

        node.child[0] = new BTree();
        node.child[1] = new BTree();

        makeChild(node.child[0], depth + 1);
        makeChild(node.child[1], depth + 1);
    }

    void preSearch(BTree node, int depth) {
        if (node != null) {
            BTree left = node.child[0];
            BTree right = node.child[1];

            preSearch(left, depth + 1);
            node.value = arr[idx++];
            list[depth].add(node.value);

            preSearch(right, depth + 1);
        }
    }
}
