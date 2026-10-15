class Solution {
    public Map<Node, Node> containsNode = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node);
    }

    public Node dfs(Node node) {
        if (containsNode.containsKey(node)) {
            return containsNode.get(node);
        }

        Node copy = new Node();
        copy.val = node.val;
        containsNode.put(node, copy);

        for (Node temp : node.neighbors) {
            copy.neighbors.add(dfs(temp));
        }

        return copy;
    }
}
