package com.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private int numberOfVertex;
    private LinkedList<Integer>[] adjancentList;

    public Graph(int v){
        this.numberOfVertex = v;
        this.adjancentList = new LinkedList[v];
        //Node will be available for 0
        for(int i = 0;i < v;i++){
            adjancentList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v,int w){
        this.adjancentList[v].add(w);
    }

    public static void runGraph() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        int start_vertex = 2;
        g.dfs(start_vertex);
        g.bfs(start_vertex);
    }

    public void bfs(int v){
        System.out.printf("\nBFS: (Using Queue) \n");
        boolean[] visited = new boolean[numberOfVertex];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        while (!queue.isEmpty()){
            int curr = queue.poll();
            if(!visited[curr]){
                visited[curr] = true;
                System.out.print(curr+"\t");
            }
            for(int i : adjancentList[curr]){
                if(!visited[i]){
                    queue.add(i);
                }
            }
        }
    }

    public void dfs(int v){
        boolean[] visited = new boolean[numberOfVertex];
        System.out.printf("Graph Traversal methods:\n");
        System.out.printf("DFS:\n");
        System.out.printf("Depth First Traversal starting from vertex %d: (Using recursion call stack) \n",v);
        recursiveDfs(v,visited);
        visited = new boolean[numberOfVertex];
        System.out.printf("\nDepth First Traversal starting from vertex %d: (Using recursion explicit stack DS) \n",v);
        dfsUsingStack(v,visited);
    }

    public void recursiveDfs(int v,boolean[] visited){
        visited[v] = true;
        System.out.print(v+"\t");
        for(int i : adjancentList[v]){
            if(!visited[i]){
                recursiveDfs(i,visited);
            }
        }
    }

    public void dfsUsingStack(int v,boolean[] visited){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(v);
        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(!visited[curr]){
                visited[curr] = true;
                System.out.print(curr+"\t");
            }
            for(int i : adjancentList[curr]){
                if(!visited[i]){
                    stack.push(i);
                }
            }
        }
    }
}
