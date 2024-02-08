public class JumpSearch {

  int iterative(int a[], int x, int n, int element) {
    int steps = (int) Math.sqrt(n);
    int root = steps;
    while(root < n && a[root - 1] < element)
        root += steps;

    LinearSearch search = new LinearSearch();
    // System.out.println(root - (int)Math.sqrt(n) + " " + root);
    return search.iterative(a, root - (int)Math.sqrt(n), Math.min(root, n), element);
  }
}
