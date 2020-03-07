import java.util.Scanner;

public class PathFind {
    static int count = 0;
    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.adjMatrix[1][2] = 1;
        g.adjMatrix[2][3] = 1;
        g.adjMatrix[2][4] = 1;
        g.adjMatrix[4][5] = 1;
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int d = in.nextInt();
        findPath(g, s, d);
        if (g.visited[d]) {
            System.out.println("There is a path");
        } else {
            System.out.println("There is no path");
        }
        System.out.println("Simple path count : "+ count);
    }

    private static void findPath(Graph g, int s, int d) {
        g.visited[s] = true;
        if (s == d) {
            count++;
            return;
        }
        for (int tmp = 0; tmp < g.vertices; tmp++) {
            if (g.adjMatrix[s][tmp] == 1 && !g.visited[tmp]) {
                findPath(g, tmp , d);
            }
        }
    }
}
class Graph {
    int vertices;
    int[][] adjMatrix;
    boolean[] visited;
    Graph(int v) {
        vertices = v;
        adjMatrix = new int[v][v];
        visited = new boolean[v];
    }
}

