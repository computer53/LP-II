import java.util.*;
// 0
// / \
// 1   2
// / \   \
// 3   4   4

class Graph {
    private int[][] adjMatrix;
    private int vertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // Undirected Graph
    }

    public void dfsRecursive(int node, boolean[] visited) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[node][i] == 1 && !visited[i]) {
                dfsRecursive(i, visited);
            }
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int vertices = scanner.nextInt();
        Graph graph = new Graph(vertices);

        System.out.println("Enter number of edges:");
        int edges = scanner.nextInt();

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        System.out.println("Enter starting node for DFS:");
        int startDFS = scanner.nextInt();
        System.out.println("DFS Recursive:");
        graph.dfsRecursive(startDFS, new boolean[vertices]);

        System.out.println("\nEnter starting node for BFS:");
        int startBFS = scanner.nextInt();
        System.out.println("BFS:");
        graph.bfs(startBFS);

        scanner.close();
    }
}
// Enter number of vertices:
// 5
// Enter number of edges:
// 5
// Enter edges (u v):
// 0 1
// 0 2
// 1 3
// 1 4
// 2 4
// Enter starting node for DFS:
// 0
// DFS Recursive:
// 0 1 3 4 2
// Enter starting node for BFS:
// 0
// BFS:
// 0 1 2 3 4
