class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preGraph = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            preGraph.put(i, new ArrayList<>());
        }
        for(int i = 0 ; i < prerequisites.length; i++){
            preGraph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i = 0; i< numCourses; i++){
            if(!dfs(i, preGraph, new HashSet<>())) return false;
        }
        return true;
    }

    public boolean dfs(int currNode, HashMap<Integer, List<Integer>> preGraph, HashSet<Integer> visited){
        if(preGraph.get(currNode).size() == 0) return true;
        if(!visited.add(currNode)) return false;

        for(int i : preGraph.get(currNode)){
            if(!dfs(i, preGraph, visited)) return false;
            preGraph.get(i).clear();
        }
        return true;
    }
}