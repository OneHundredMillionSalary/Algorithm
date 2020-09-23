package week_17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1302 {

    public static void main(String[] args) {
        new BJ_1302().solve();
    }

    HashMap<String, Integer> map = new HashMap<>();
    int N;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            String key;
            for (int i = 0; i < N; i++) {
                key = br.readLine();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int fv = map.get(o1);
                    int sv = map.get(o2);

                    if (fv == sv) {
                        return o1.compareTo(o2);
                    } else {
                        return sv - fv;
                    }
                }
            });

            Iterator<String> iter = map.keySet().iterator();
            while (iter.hasNext()) {
                queue.offer(iter.next());
            }

            System.out.println(queue.poll());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
