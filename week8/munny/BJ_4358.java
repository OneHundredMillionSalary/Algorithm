package week_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class BJ_4358 {
    public static void main(String[] args) {
        new BJ_4358().solve();
    }

    HashMap<String, Double> map;
    int cnt;

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            map = new HashMap<>();
            for(String name = br.readLine(); name != null && !name.isEmpty(); name = br.readLine()) {
                cnt++;
                map.put(name, map.getOrDefault(name, 0.0) + 1);
            }

            Iterator<String> iter = map.keySet().iterator();
            ArrayList<String> list = new ArrayList<>();

            while (iter.hasNext()) {
                list.add(iter.next());
            }

            Collections.sort(list);

            for (String s : list) {
                System.out.println(s + " " + String.format("%.4f", getPerc(s)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    double getPerc(String s) {
        return Math.round(map.get(s) / cnt * 1000000) / 10000.0;
    }
}
