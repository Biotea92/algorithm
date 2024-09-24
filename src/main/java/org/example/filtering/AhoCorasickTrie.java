package org.example.filtering;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class AhoCorasickTrie {
    private Node root = new Node();

    public Node getRoot() {
        return root;
    }

    // 금칙어 추가 메서드
    public void addKeyword(String originalKeyword, int[] normalizedKeyword) {
        Node node = root;
        for (int codePoint : normalizedKeyword) {
            node = node.getChildren().computeIfAbsent(codePoint, k -> new Node());
        }
        node.getOutputs().add(originalKeyword);
    }

    // 실패 링크 구축
    public void buildFailureLinks() {
        Queue<Node> queue = new LinkedList<>();
        root.setFail(root);

        for (Node child : root.getChildren().values()) {
            child.setFail(root);
            queue.add(child);
        }

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for (Map.Entry<Integer, Node> entry : currentNode.getChildren().entrySet()) {
                int codePoint = entry.getKey();
                Node childNode = entry.getValue();

                Node failNode = currentNode.getFail();
                while (failNode != root && !failNode.getChildren().containsKey(codePoint)) {
                    failNode = failNode.getFail();
                }

                if (failNode.getChildren().containsKey(codePoint)) {
                    childNode.setFail(failNode.getChildren().get(codePoint));
                } else {
                    childNode.setFail(root);
                }

                childNode.getOutputs().addAll(childNode.getFail().getOutputs());
                queue.add(childNode);
            }
        }
    }
}
