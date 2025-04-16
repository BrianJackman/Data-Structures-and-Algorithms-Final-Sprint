package com.keyin.util;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root;

    // Inner class to represent a node in the tree
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    // Method to insert a value into the tree
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    // Method to perform in-order traversal
    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderTraversalRecursive(root, result);
        return result;
    }

    private void inOrderTraversalRecursive(Node node, List<Integer> result) {
        if (node != null) {
            inOrderTraversalRecursive(node.left, result);
            result.add(node.value);
            inOrderTraversalRecursive(node.right, result);
        }
    }

    // Method to serialize the tree structure as a string
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        serializeRecursive(root, sb);
        return sb.toString();
    }

    private void serializeRecursive(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
        } else {
            sb.append(node.value).append(",");
            serializeRecursive(node.left, sb);
            serializeRecursive(node.right, sb);
        }
    }
}