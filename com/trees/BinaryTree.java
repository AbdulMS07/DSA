package com.trees;

import java.util.*;

class TreeNode {
    public int data;
    TreeNode right,left;
    TreeNode(int data){
        this.data = data;
        right = left = null;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(h) where h is height of the tree  If is balance tree , it will take O(log n)
public class BinaryTree {

    TreeNode root;

    public void  printPreorder(TreeNode root){
        if (root == null) return;
        System.out.print(root.data+"\t");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public void  printInorder(TreeNode root){
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data+"\t");
        printInorder(root.right);
    }

    public void  printPostorder(TreeNode root){
        if (root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data+"\t");
    }

    public void stackBasedTraversals(TreeNode root){
        printPreOrderStack(root);
        printInOrderStack(root);
        printPostOrderStack(root);
    }

    public void printPreOrderStack(TreeNode root){
        System.out.println("\nStack based Preorder traversal of binary tree is ");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null)return;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            System.out.print(curr.data+"\t");
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }
    }

    public void printInOrderStack(TreeNode root){
        System.out.println("\nStack based Inorder traversal of binary tree is ");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            //traversing to the left most node
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            //curr reached now null
            curr = stack.pop();
            System.out.print(curr.data+"\t");
            curr = curr.right;
        }
    }

    public void printPostOrderStack(TreeNode root){
        System.out.println("\nStack based Postorder traversal of binary tree is ");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();
        if(root==null)return;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            output.push(curr);
            if(curr.left != null){
                stack.push(curr.left);
            }
            if(curr.right != null){
                stack.push(curr.right);
            }
        }
        while (!output.isEmpty()){
            System.out.print(output.pop().data+"\t");
        }
    }

    public void dfs(){
        System.out.println("\nRecursive Preorder traversal of binary tree is ");
        printPreorder(root);

        System.out.println("\nRecursive Inorder traversal of binary tree is ");
        printInorder(root);

        System.out.println("\nRecursive Postorder traversal of binary tree is ");
        printPostorder(root);

        stackBasedTraversals(root);
    }

    public void bfs(){
        System.out.printf("\nBFS a.k.a Level Order Traversal : (Using Queue) \n");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            System.out.print(curr.data+"\t");
            if(curr.left != null){
                queue.add(curr.left);
            }
            if (curr.right != null){
                queue.add(curr.right);
            }
        }
        bfsMultiLevelGraphOrTrees();
    }

    public void bfsMultiLevelGraphOrTrees(){
        System.out.printf("\nBFS - print node with level  : (Using Queue) \n");
        Queue<Map.Entry<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(root,0));
        while (!queue.isEmpty()){
            Map.Entry<TreeNode,Integer> curr = queue.poll();
            TreeNode actual_node = curr.getKey();
            int level = curr.getValue();
            System.out.println(actual_node.data+"\t Level - "+level);
            if(actual_node.left != null){
                queue.add(new AbstractMap.SimpleEntry<>(actual_node.left,level+1));
            }
            if (actual_node.right != null){
                queue.add(new AbstractMap.SimpleEntry<>(actual_node.right,level+1));
            }
        }
    }

    public static void runTree() {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.right.left = new TreeNode(6);
        tree.root.left.right.right = new TreeNode(7);
        tree.root.right.right = new TreeNode(8);
        tree.root.right.right.left = new TreeNode(9);
        System.out.printf("\n\n\nTree Traversal methods:\nDFS:");
        tree.dfs();
        tree.bfs();
    }
}

