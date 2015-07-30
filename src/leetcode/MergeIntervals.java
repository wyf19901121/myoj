package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class MergeIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        Interval[] arrayIntervals = intervals.toArray(new Interval[intervals.size()]);
        Arrays.sort(arrayIntervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        ArrayList<Interval> resArrayList = new ArrayList<>();
        Interval moverInterval = arrayIntervals[0];
        for (int i = 1; i < arrayIntervals.length; i++) {
            if (moverInterval.end < arrayIntervals[i].start) {
                resArrayList.add(moverInterval);
                moverInterval = arrayIntervals[i];
            }
            else {
                moverInterval.end = Math.max(moverInterval.end, arrayIntervals[i].end);
            }
        }
        resArrayList.add(moverInterval);
        return resArrayList;
    }
}
