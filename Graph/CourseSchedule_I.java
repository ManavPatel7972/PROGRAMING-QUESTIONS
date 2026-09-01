import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_I {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return true;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];

            adj.get(preReq).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            cnt++;

            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return cnt == numCourses;

    }
}
