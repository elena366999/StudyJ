package Task4.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void printLeafNodes(TreeNode node) {

        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            System.out.printf("%d ", node.data);
        }
        printLeafNodes(node.left);
        printLeafNodes(node.right);
    }

    public static void printLevel(TreeNode node, int level) {
        if (node == null)
            return;
        if (level == 0) {
            System.out.print(node.data + " ");
        } else {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }

    static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    static int getCAL(TreeNode node, int curr, int desired) {
        if (node == null) return 0;
        if (curr == desired) {
            System.out.print(node.data + " ");
            return 1;
        }
        return getCAL(node.left, curr + 1, desired) +
                getCAL(node.right, curr + 1, desired);
    }

    public static void printLevels(TreeNode node, int height) {
        if (node == null) return;
        if (height == 1) System.out.print(" " + node.data);
        else {
            printLevels(node.left, height - 1);
            printLevels(node.right, height - 1);
        }
    }

    public static void getLevels(TreeNode node) {
        for (int i = 0; i < height(node); i++) {
            printLevel(node, i);
            System.out.println();
        }
    }

    public static ArrayList<Integer> path;

    public static Boolean printPath(TreeNode node, TreeNode dest) {
        if (node == null) return false;
        if (node.data == dest.data || printPath(node.left, dest) || printPath(node.right, dest)) {
            //System.out.print("  " + root.data);
            path.add(node.data);
            return true;
        }
        return false;
    }

    public static TreeNode traverseBinaryTree(TreeNode root, int value) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) continue;

            if (node.data == value)
                return node;

            queue.offer(node.right);
            queue.offer(node.left);

        }return null;
    }


    public static void main(String[] args){

        TreeNode rootNode=createBinaryTree();
        System.out.println("Leaf nodes in binary tree: ");
        printLeafNodes(rootNode);
        System.out.println();
        System.out.print("Elements on selected level are ");
        System.out.println("\nNumber of branches on selected level is " + getCAL(rootNode,0,2));
        System.out.println("Level-wise representation of tree levels:");
        getLevels(rootNode);
        path = new ArrayList<>();
        printPath(rootNode,traverseBinaryTree(rootNode, 5));
        Collections.reverse(path);
        System.out.println("Path to given node:  " + path);
        System.out.println("Number of branches leading to given node is " + (path.size()-1));
    }


    public static TreeNode createBinaryTree()
    {

        TreeNode rootNode =new TreeNode(40);
        TreeNode node20=new TreeNode(20);
        TreeNode node10=new TreeNode(10);
        TreeNode node30=new TreeNode(30);
        TreeNode node60=new TreeNode(60);
        TreeNode node50=new TreeNode(50);
        TreeNode node70=new TreeNode(70);

        TreeNode node5=new TreeNode(5);
        TreeNode node55=new TreeNode(55);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;

        node10.left=node5;
        node50.right=node55;
        return rootNode;
    }
}
