// class Solution {
//     public int countComponents(int n, int[][] edges) {
//         int answer = 0;
//         int[] arr = new int[n];
//         Arrays.fill(arr, -1);


//         Arrays.sort(edges, (a, b) -> Integer.compare(a[0], b[0]));
        
//         for(int[] curr : edges){
//             if(arr[curr[0]] == -1 && arr[curr[1]] == -1){
//                 arr[curr[0]] = arr[curr[1]] = curr[0];
//             }else{
//                 if(arr[curr[0]] == -1) arr[curr[0]] = curr[0];
//                 arr[curr[1]] = arr[curr[0]];
//             }
//         }
//         Arrays.sort(arr);
//         for(int i = 0; i < n; i++){
//             if(arr[i] != -1){
//                 answer++;
//                 int curr = arr[i];
//                 while(i < n && arr[i] != curr) i++;
//             }else answer++;
//         }


//         return answer;
//     }

// }
class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, adj, visited);
            }
        }
        
        return answer;
    }


    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}