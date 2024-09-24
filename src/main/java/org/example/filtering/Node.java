package org.example.filtering;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Node {
    private Map<Integer, Node> children = new HashMap<>();
    private Node fail;
    private Set<String> outputs = new HashSet<>();

    public Map<Integer, Node> getChildren() {
        return children;
    }

    public Node getFail() {
        return fail;
    }

    public void setFail(Node fail) {
        this.fail = fail;
    }

    public Set<String> getOutputs() {
        return outputs;
    }
}
