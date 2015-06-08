package leetcode;

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a = Math.min(A, C);
        int c = Math.max(A, C);
        int b = Math.min(B, D);
        int d = Math.max(B, D);
        int e = Math.min(E, G);
        int g = Math.max(E, G);
        int f = Math.min(F, H);
        int h = Math.max(F, H);
        int all = (c - a) * (d - b) + (g - e) * (h - f);
        if (a >= g || e >= c || b >= h || f >= d) {
            return all;
        }
        int left = Math.max(a, e);
        int right = Math.min(c, g);
        int bottom = Math.max(b, f);
        int top = Math.min(d, h);
        int other = (right - left) * (top -bottom);
        return all - other;
    }
}
