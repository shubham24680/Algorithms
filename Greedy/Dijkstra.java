public class Dijkstra {
    static final int vertices = 9;

    int minDistance(int dist[], Boolean visited[]) {
        int mini = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < vertices; i++) {
            if (visited[i] == false && dist[i] <= mini) {
                mini = dist[i];
                index = i;
            }
        }
        return index;
    }

    void path(int graph[][], int source) {
        // Array hold's minimum distances.
        int dist[] = new int[vertices];
        // visited element must be marked
        Boolean visited[] = new Boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        dist[source] = 0;
        for (int i = 0; i < vertices - 1; i++) {
            // Minimum distances between nodes.
            int index = minDistance(dist, visited);
            visited[index] = true;
            for (int j = 0; j < vertices; j++) {
                if (graph[index][j] != 0 && dist[index] != Integer.MAX_VALUE
                        && dist[j] > (dist[index] + graph[index][j]))
                    dist[j] = dist[index] + graph[index][j];
            }
        }
        print(dist);
    }

    void print(int dist[]) {
        System.out.println("Vertix\t\tDistance from source");
        for (int i = 0; i < vertices; i++)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        Dijkstra shortest_path = new Dijkstra();
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        shortest_path.path(graph, 0);
    }
}
