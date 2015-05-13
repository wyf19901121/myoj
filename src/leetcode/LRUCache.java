package leetcode;
import java.util.HashMap;

public class LRUCache {
    class Node {
        int m_key;
        int m_value;
        Node preNode;
        Node nextNode;
        public Node(int key, int value) {
            m_key = key;
            m_value = value;
        }
    }
    public int m_capacity;
    Node head;
    Node tail;
    public HashMap<Integer, Node> m_memoryMap;
    public LRUCache(int capacity) {
        m_capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(1, 1);
        m_memoryMap = new HashMap<>(capacity);
        head.nextNode = tail;
        tail.preNode = head;
    }
    
    public int get(int key) {
        if (m_memoryMap.containsKey(key)) {
            Node tempNode = m_memoryMap.get(key);
            putToHead(tempNode);
            return tempNode.m_value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (m_memoryMap.containsKey(key)) {
            Node tempNode = m_memoryMap.get(key);
            tempNode.m_value = value;
            putToHead(tempNode);
        }
        else {
            if (m_memoryMap.size() == m_capacity) {
                int tmp = removeEnd();
                m_memoryMap.remove(tmp);
            }
            Node tempNode = new Node(key, value);
            putToHead(tempNode);
            m_memoryMap.put(key, tempNode);
        }
    }
    public int removeEnd() {
        Node pNode = tail.preNode;
        tail.preNode.preNode.nextNode = tail;
        tail.preNode = pNode.preNode;
        pNode.preNode = null;
        pNode.nextNode = null;
        return pNode.m_key;
    }
    public void putToHead(Node insetNode) {
        if (insetNode.nextNode != null && insetNode.preNode != null) {
            insetNode.preNode.nextNode = insetNode.nextNode;
            insetNode.nextNode.preNode = insetNode.preNode;
        }
        head.nextNode.preNode = insetNode;
        insetNode.nextNode = head.nextNode;
        head.nextNode = insetNode;
        insetNode.preNode = head;
    }
}
