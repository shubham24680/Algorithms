class Prim {
    // No. of vertices
    static final int vertices = 5;

    int min_weight(int weight[], Boolean visited[]) {
        int mini = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < vertices; i++) {
            if (visited[i] == false && weight[i] < mini) {
                mini = weight[i];
                index = i;
            }
        }
        // Index of the minimum weight element.
        return index;
    }

    void MST(int graph[][]) {
        // Array to store constructed MST(Minimum spanning tree)
        int parent[] = new int[vertices];
        // Minimum weight of the edge
        int weight[] = new int[vertices];
        // Visited vertices
        Boolean visited[] = new Boolean[vertices];
        // All key are infinite at first
        for (int i = 0; i < vertices; i++) {
            weight[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        // Including first vertex in MST and make it distance '0'(Souce)
        weight[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < vertices - 1; count++) {
            // Pick minimum weight
            int index = min_weight(weight, visited);
            visited[index] = true;

            for (int j = 0; j < vertices; j++) {
                if (graph[index][j] != 0 && visited[j] == false && graph[index][j] < weight[j]) {
                    parent[j] = index;
                    weight[j] = graph[index][j];
                }
            }
        }

        print(parent, graph);
    }

    void print(int parent[], int graph[][]) {
        System.out.println("Edge\tWeight");
        for (int i = 1; i < vertices; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    public static void main(String[] args) {
        Prim tree = new Prim();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        tree.MST(graph);
    }
}