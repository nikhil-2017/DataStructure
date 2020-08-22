package com.proglang;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;

    // iterative method
    public void add(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (root == null) {
            root = newNode;
            newNode.parent = root;
        } else {
            Node currentNode = root;
            Node parentNode;

            while (true) {
                parentNode = currentNode;
                if (data == currentNode.data) {
                    return;
                } else if (data < currentNode.data) {
                    currentNode = currentNode.left;
                    if (currentNode == null) {
                        parentNode.left = newNode;
                        newNode.parent = parentNode;
                        return;
                    }
                } else {
                    currentNode = currentNode.right;
                    if (currentNode == null) {
                        parentNode.right = newNode;
                        newNode.parent = parentNode;
                        return;
                    }
                }
            }
        }
    }

    // call from main and then call the insertRec(root, data) method to insert data using recursion.
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // recursive method
    private Node insertRec(Node root, int data) {

        // if tree is null
        if (root == null) {
            root = new Node();
            root.data = data;
            return root;
        }

        // otherwise:
        if (data < root.data) {
            root.left = insertRec(root.left, data);     // if data is less than root/parent node
            root.left.parent = root;
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);   // if data is greater than root/parent node
            root.right.parent = root;
        }

        return root;    // return un-change node pointer
    }

    // when the tree is invert we call this insert function
    public void insertInvert(int data) {
        root = insertInvertRec(root, data);
    }

    private Node insertInvertRec(Node root, int data) {

        if (root == null) {
            root = new Node();
            root.data = data;
            return root;
        }

        // otherwise:
        if (data < root.data) {
            root.right = insertInvertRec(root.right, data);
            root.right.parent = root;
        } else {
            root.left = insertInvertRec(root.left, data);
            root.left.parent = root;
        }

        return root;
    }


    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            node.nodeDisplay();
            inorder(node.right);
        }
    }

    public void showInOrder() {
        inorder(root);
        System.out.println();
    }

    private Queue<Integer> dataQueue = new LinkedList<>();

    private void Asc(Node node) {
        if (node!=null) {
            Asc(node.left);
            dataQueue.add(node.data);
            Asc(node.right);
        }
    }

    private void Desc(Node node) {
        if (node!=null) {
            Desc(node.right);
            dataQueue.add(node.data);
            Desc(node.left);
        }
    }

    public Queue<Integer> sortAsc() {
        dataQueue.clear();  // clear before queue operations
        Asc(root);
        return dataQueue;
    }

    public Queue<Integer> sortDesc() {
        dataQueue.clear();  // clear before queue operations
        Desc(root);
        return dataQueue;
    }

    private void preOrder(Node node) {
        if (node != null) {
            node.nodeDisplay();
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void showPreOrder() {
        preOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            node.nodeDisplay();
        }
    }

    public void showPostOrder() {
        postOrder(root);
        System.out.println();
    }

    public void showLevelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        if (root != null) {
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                System.out.print(node.data + " ");

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        } else {
            System.out.println("The tree is empty.");
        }
    }

    public Queue<Integer> LevelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Queue<Integer> dataQueue = new LinkedList<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            dataQueue.add(node.data);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return dataQueue;
    }

    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, int data) {

        // if the tree is empty
        if (root == null) {
            return null;
        }

        // otherwise
        if (data < root.data) {
            root.left = deleteRec(root.left, data);     // if data is less than root/parent node
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);     // if data is greater than root/parent node
        } else {    // if the root data is same as data

            // if node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = min(root.left);
            root.left = deleteRec(root.left, root.data);
        }
        return root;
    }

    private int min(Node root) {
        int minValue = root.data;
        while (root.left !=null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public void deleteInvert(int data) {
        root = deleteInvertRec(root, data);
    }

    private Node deleteInvertRec(Node root, int data) {

        if (root == null) {
            return null;
        }

        // otherwise
        if (data < root.data) {
            root.right = deleteInvertRec(root.right, data);
        } else if (data > root.data) {
            root.left = deleteInvertRec(root.left, data);
        }
        else {
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            }

            root.data = minInvert(root.right);
            root.right = deleteInvertRec(root.right, root.data);
        }

        return root;
    }

    private int minInvert(Node root) {
        int minValue = root.data;
        while (root.right != null) {
            minValue = root.right.data;
            root = root.right;
        }
        return minValue;
    }

    public int[] search(int data) {
        int[] searchData = new int[2];
        Node current = root;

        if (root != null) {
            if (root.data == data) {
                searchData[0] = 0;
                searchData[1] = root.data;
                return searchData;
            }

            while (current.data != data) {
                if (data < current.data) {
                    current = current.left;
                } else {
                    current = current.right;
                }

                if (current == null) {
                    searchData[0] = -1;
                    return searchData;
                }
            }
        } else {
            searchData[0] = -1;
            return searchData;
        }

        searchData[0] = 1;
        searchData[1] = current.parent.data;
        return searchData;
    }

    public void invert() {
        invertedBT(root);
    }

    private Node invertedBT(Node root) {
        if (root!=null) {
            Node tmpNode = root.left;
            root.left = root.right;
            root.right = tmpNode;

            invertedBT(root.left);
            invertedBT(root.right);
        }
        return root;
    }
}