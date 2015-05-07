package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    class Node {
        int in = 0;
        ArrayList<Integer> req = new ArrayList<>();
        public Node() {
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length <= 1) {
            return true;
        }
        ArrayList<Node> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            res.add(new Node());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            res.get(prerequisites[i][0]).req.add(prerequisites[i][1]);
            res.get(prerequisites[i][1]).in++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (res.get(i).in == 0 && res.get(i).req.size() != 0) {
                queue.add(i);
            }
        }
        while (queue.size() != 0) {
            int first = queue.poll();
            res.get(first).in = -1;
            for (int i = 0; i < res.get(first).req.size(); i++) {
                if (--res.get(res.get(first).req.get(i)).in == 0) {
                    queue.add(res.get(first).req.get(i));
                }
            }
        }
        for (int i = 0; i <numCourses ; i++) {
            if (res.get(i).in > 0 && res.get(i).req.size() != 0) {
                return false;
            }
        }
        return true;
    }
}
