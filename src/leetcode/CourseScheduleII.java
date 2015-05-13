package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
    class Node {
    	int in = 0;
    	ArrayList<Integer> out = new ArrayList<Integer>();
    	public Node() {
		}
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	int order[] = new int [numCourses];
    	int index = 0;
    	if (numCourses == 0 ) {
			return order;
		}
    	if (numCourses == 1) {
			order[0] = 0;
			return order;
		}
    	ArrayList<Node> nodes = new ArrayList<Node>();
    	for (int i = 0; i < order.length; i++) {
			nodes.add(new Node());
		}
    	for (int i = 0; i < prerequisites.length; i++) {
			nodes.get(prerequisites[i][0]).in++;
			nodes.get(prerequisites[i][1]).out.add(prerequisites[i][0]);
		}
    	Queue<Integer> queue = new LinkedList<Integer>();
    	for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).in == 0) {
				queue.offer(i);
			}
		}
    	while (!queue.isEmpty()) {
			int first = queue.poll();
			order[index++] = first;
			nodes.get(first).in = -1;
			for (int i = 0; i < nodes.get(first).out.size(); i++) {
				if(--nodes.get(nodes.get(first).out.get(i)).in == 0) {
					queue.offer(nodes.get(first).out.get(i));
				}
			}
		}
    	if (index != numCourses) {
			int[] array = new int [0];
			return array;
		}
    	return order;
    }
}
