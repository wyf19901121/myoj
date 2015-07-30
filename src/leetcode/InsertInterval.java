package leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	if (intervals == null) {
			ArrayList<Interval> res = new ArrayList<Interval>();
			res.add(newInterval);
			return res;
		}
    	for (int i = 0; i < intervals.size(); i++) {
    		Interval curInterval = intervals.get(i);
			if (curInterval.start > newInterval.end) {
				intervals.add(i, newInterval);
				return intervals;
			}
			if (curInterval.end >= newInterval.start) {
				newInterval.start = Math.min(curInterval.start, newInterval.start);
				newInterval.end = Math.max(curInterval.end, newInterval.end);
				intervals.remove(i);
				i--;
			}
			if (i + 1 == intervals.size()) {
				intervals.add(newInterval);
				return intervals;
			}
		}
    	if (intervals.isEmpty()) {
			intervals.add(newInterval);
		}
    	return intervals;
    }
}
