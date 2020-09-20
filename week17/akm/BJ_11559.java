package week_17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BJ_11559 {
    public static void main(String[] args) {
        new BJ_11559().solve();
    }

    int Y = 12;
    int X = 6;

    String[][] board = new String[Y][X];
    boolean[][] visit;


    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    int cnt;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] splits;
            for (int y = 0; y < Y; y++) {
                splits = br.readLine().split("");
                for (int x = 0; x < X; x++) {
                    board[y][x] = splits[x];
                }
            }
            while (true) {
                ArrayList<ArrayList<Node>> list = new ArrayList<>();
                visit = new boolean[Y][X];
                for (int y = 0; y < Y; y++) {
                    for (int x = 0; x < X; x++) {
                        ArrayList<Node> result = bfs(y, x, board[y][x]);
                        if (!result.isEmpty()) {
                            list.add(result);
                        }
                    }
                }

                if (!list.isEmpty()) {
                    cnt++;
                    for (ArrayList<Node> al : list) {
                        removePuyo(al);
                    }
                } else {
                    break;
                }
            }

            System.out.println(cnt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    ArrayList<Node> bfs(int y, int x, String color) {
        if (color.equals(".")) {
            return new ArrayList<>();
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(y, x));
        visit[y][x] = true;

        ArrayList<Node> list = new ArrayList<>();
        list.add(queue.peek());

        while (!queue.isEmpty()) {
            Node item = queue.poll();
            int newY;
            int newX;

            for (int k = 0; k < 4; k++) {
                newY = item.y + direction[k][0];
                newX = item.x + direction[k][1];

                if (newY >= Y || newY < 0 || newX >= X || newX < 0 ||
                        visit[newY][newX] || !board[newY][newX].equals(color)) {
                    continue;
                }

                visit[newY][newX] = true;
                Node node = new Node(newY, newX);
                queue.offer(node);
                list.add(node);
            }
        }

        if (list.size() >= 4) {
            return list;
        }

        return new ArrayList<>();
    }

    void removePuyo(ArrayList<Node> list) {
        for (Node n : list) {
            board[n.y][n.x] = ".";
        }

        ArrayList<Integer> yList;

        for (int x = 0; x < X; x++) {
            yList = new ArrayList<>();
            for (int y = Y - 1; y >= 0; y--) {
                if (!board[y][x].equals(".")) {
                    yList.add(y);
                }
            }

            for (int i : yList) {
                for (int y = i; y < Y - 1; y++) {
                    if (board[y + 1][x].equals(".")) {
                        board[y + 1][x] = board[y][x];
                        board[y][x] = ".";
                    }
                }
            }
        }
    }
}
