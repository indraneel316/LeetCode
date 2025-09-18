import java.util.*;

class TaskManager {
    private static class Task {
        int userId, taskId, priority;
        Task(int u, int t, int p) {
            userId = u; taskId = t; priority = p;
        }
    }

    // Max-heap: highest priority first, break ties by highest taskId
    private PriorityQueue<int[]> pq;
    private Map<Integer, Task> store; // taskId -> Task

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0]; // priority desc
            return b[1] - a[1];                   // taskId desc
        });
        store = new HashMap<>();

        for (List<Integer> list : tasks) {
            int userId = list.get(0), taskId = list.get(1), priority = list.get(2);
            add(userId, taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task t = new Task(userId, taskId, priority);
        store.put(taskId, t); // overwrite if exists
        pq.offer(new int[]{priority, taskId, userId});
    }

    public void edit(int taskId, int newPriority) {
        Task t = store.get(taskId);
        if (t != null) {
            t.priority = newPriority;
            pq.offer(new int[]{newPriority, taskId, t.userId}); // push updated
        }
    }

    public void rmv(int taskId) {
        store.remove(taskId); // mark invalid
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int priority = top[0], taskId = top[1], userId = top[2];

            Task t = store.get(taskId);
            // check if still valid
            if (t != null && t.priority == priority && t.userId == userId) {
                store.remove(taskId); // execute & remove
                return userId;
            }
        }
        return -1;
    }
}
