class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, graph, visited)) return false;

        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(node)) return false;
        visited.add(node);

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue; 
            if (!dfs(neighbor, node, graph, visited)) return false;
        }

        return true;
    }
}
