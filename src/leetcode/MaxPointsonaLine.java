package leetcode;

import java.util.HashMap;

public class MaxPointsonaLine {
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    public int maxPoints(Point[] points) {
        if (points.length < 3) {
            return points.length;
        }
        int max = 0;
        HashMap<Double, Integer> pointHashMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointHashMap.clear();
            int duplicate = 1;
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                double k = 0.0;
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    duplicate++;
                }
                else { 
                    if (points[i].x == points[j].x) {
                        k = Integer.MAX_VALUE;
                    }
                    else {
                        k = 1.0 * (points[i].x - points[j].x) / (points[i].y - points[j].y);
                    }
                    pointHashMap.put(k, pointHashMap.containsKey(k) ? pointHashMap.get(k) + 1 : 1);
                }
                if (pointHashMap.isEmpty()) {
                    max = Math.max(max, duplicate);
                }
                else {
                    for (double key : pointHashMap.keySet()) {
                        max = Math.max(duplicate + pointHashMap.get(key), max);
                    }
                }
            }
        }
        return max;
    }
}
