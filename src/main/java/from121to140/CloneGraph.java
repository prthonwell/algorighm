package from121to140;

import ob.Node;

import java.util.HashMap;
import java.util.HashSet;

class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Integer, Node> visited = new HashMap<>();
        return dfs(visited, node);

    }

    private Node dfs(HashMap<Integer, Node> visited, Node node) {
        Node newNode = new Node(node.val);
        visited.put(node.val, newNode);
        for (Node n : node.neighbors) {
            if (visited.containsKey(n.val)) {
                newNode.neighbors.add(visited.get(n.val));
            } else {
                Node newNeighbor = dfs(visited, n);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return newNode;
    }
}