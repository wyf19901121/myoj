package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheSkylineProblem {
    public ArrayList<int[]> getSkyline(int[][] buildings) {
    	ArrayList<int[]> result = new ArrayList<int[]>();
    	PriorityQueue<Integer> heightHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
    		public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
    	ArrayList<int[]> indexHeight = new ArrayList<int[]>();
    	for (int i = 0; i < buildings.length; i++) {
			int[] b = buildings[i];
			indexHeight.add(new int[]{b[0], b[2]});
			indexHeight.add(new int[]{b[1], -b[2]});
		}
    	Collections.sort(indexHeight, new Comparator<int[]>() {
    		public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0];
				}
				return b[1] - a[1];
			}
		});
    	int pre = 0, cur = 0;
    	for (int i = 0; i < indexHeight.size(); i++) {
			int[] b = indexHeight.get(i);
			if (b[1] >= 0) {
				heightHeap.add(b[1]);
				cur = heightHeap.peek();
			}
			else {
				heightHeap.remove(-b[1]);
				cur = (heightHeap.isEmpty()) ? 0 : heightHeap.peek();
			}
			if (pre != cur) {
				result.add(new int[]{b[0], cur});
				pre = cur;
			}
		}
    	return result;
    }
}
