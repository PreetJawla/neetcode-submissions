class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Fix: Reverse the direction
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]); // b → a
        }

        int[] visited = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited, result)) {
                return new int[0]; // cycle detected
            }
        }

        // Reverse post-order for topological sort
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = result.get(numCourses - 1 - i);
        }
        return order;
    }

    private boolean dfs(int node, List<Integer>[] graph, int[] visited, List<Integer> result) {
        if (visited[node] == 1) return false; // cycle
        if (visited[node] == 2) return true;  // already processed

        visited[node] = 1;

        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, graph, visited, result)) return false;
        }

        visited[node] = 2;
        result.add(node); // post-order
        return true;
    }
}
//Not by Me CHAT GPT