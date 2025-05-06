import java.util.*;

class Node {
    String name;
    int gCost, hCost;
    Node parent;
    Node[] neighbors;
    int[] costs;
    int neighborCount;

    public Node(String name, int hCost, int maxNeighbors) {
        this.name = name;
        this.hCost = hCost;
        this.gCost = Integer.MAX_VALUE;
        this.neighbors = new Node[maxNeighbors];
        this.costs = new int[maxNeighbors];
        this.neighborCount = 0;
    }

    public int fCost() {
        return gCost + hCost;
    }

    public void addNeighbor(Node neighbor, int cost) {
        neighbors[neighborCount] = neighbor;
        costs[neighborCount] = cost;
        neighborCount++;
    }
}

public class AStarUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Node> nodes = new HashMap<>();

        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();
        System.out.print("Enter max neighbors per node: ");
        int maxNeighbors = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter node name and heuristic cost: ");
            String name = scanner.next();
            int hCost = scanner.nextInt();
            nodes.put(name, new Node(name, hCost, maxNeighbors));
        }

        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();
        for (int i = 0; i < edges; i++) {
            System.out.print("Enter edge (start end cost): ");
            String start = scanner.next();
            String end = scanner.next();
            int cost = scanner.nextInt();
            nodes.get(start).addNeighbor(nodes.get(end), cost);
        }

        System.out.print("Enter start node: ");
        Node start = nodes.get(scanner.next());
        System.out.print("Enter goal node: ");
        Node goal = nodes.get(scanner.next());

        Node[] path = aStar(start, goal);
        
        if (path != null) {
            System.out.print("Shortest Path: ");
            for (Node node : path) {
                if (node != null) {
                    System.out.print(node.name + " ");
                }
            }
        } else {
            System.out.println("No path found");
        }
    }

    public static Node[] aStar(Node start, Node goal) {
        Node[] openSet = new Node[100];
        Node[] closedSet = new Node[100];
        int openSetSize = 0, closedSetSize = 0;
        
        start.gCost = 0;
        openSet[openSetSize++] = start;

        while (openSetSize > 0) {
            Node current = openSet[0];
            int currentIndex = 0;
            for (int i = 1; i < openSetSize; i++) {
                if (openSet[i].fCost() < current.fCost()) {
                    current = openSet[i];
                    currentIndex = i;
                }
            }
            
            openSet[currentIndex] = openSet[--openSetSize];
            
            if (current == goal) {
                return reconstructPath(current);
            }
            
            closedSet[closedSetSize++] = current;
            
            for (int i = 0; i < current.neighborCount; i++) {
                Node neighbor = current.neighbors[i];
                int cost = current.costs[i];
                
                boolean inClosedSet = false;
                for (int j = 0; j < closedSetSize; j++) {
                    if (closedSet[j] == neighbor) {
                        inClosedSet = true;
                        break;
                    }
                }
                if (inClosedSet) continue;
                
                int tentativeGCost = current.gCost + cost;
                if (tentativeGCost < neighbor.gCost) {
                    neighbor.gCost = tentativeGCost;
                    neighbor.parent = current;
                    
                    boolean inOpenSet = false;
                    for (int j = 0; j < openSetSize; j++) {
                        if (openSet[j] == neighbor) {
                            inOpenSet = true;
                            break;
                        }
                    }
                    if (!inOpenSet) {
                        openSet[openSetSize++] = neighbor;
                    }
                }
            }
        }
        return null;
    }

    private static Node[] reconstructPath(Node node) {
        Node[] path = new Node[100];
        int pathSize = 0;
        while (node != null) {
            path[pathSize++] = node;
            node = node.parent;
        }
        
        for (int i = 0; i < pathSize / 2; i++) {
            Node temp = path[i];
            path[i] = path[pathSize - 1 - i];
            path[pathSize - 1 - i] = temp;
        }
        return Arrays.copyOf(path, pathSize);
    }
}

// Enter number of nodes: 7
// Enter max neighbors per node: 3

// Enter node name and heuristic cost:
// S 14
// B 12
// C 11
// f 11
// e 4
// d 6
// G 0

// Enter number of edges: 9

// Enter edge (start end cost):
// S B 4
// S C 3
// B f 5
// B e 12
// C e 10
// C d 7
// f G 16
// e G 5
// e d 2

// Enter start node: S
// Enter goal node: G
