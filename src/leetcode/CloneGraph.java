package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CloneGraph {
    public HashSet<Integer> ergodicSet = new HashSet<Integer> ();
    public HashMap<Integer, UndirectedGraphNode> constructMap = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        if (ergodicSet.contains(node.label)) {
            return constructMap.get(node.label);
        }
        if (!constructMap.containsKey(node.label)) {
            UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
            constructMap.put(node.label, copyNode);
        }
        
        UndirectedGraphNode copy = constructMap.get(node.label);
        for (UndirectedGraphNode neighborNode : node.neighbors) {
            if (!constructMap.containsKey(neighborNode.label)) {
                UndirectedGraphNode copyNode = new UndirectedGraphNode(neighborNode.label);
                constructMap.put(neighborNode.label, copyNode);
            }
            copy.neighbors.add(constructMap.get(neighborNode.label));
        }
        ergodicSet.add(node.label);
        for (UndirectedGraphNode neighborNode : node.neighbors) {
            cloneGraph(neighborNode);
        }
        return copy;
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
