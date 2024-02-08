public class LinearSearch {

  int iterative(int[] a, int x, int n, int element) {
    for (int i = x; i < n; i++) if (a[i] == element) return i;
    return -1;
  }

  int recursive(int[] a, int x, int n, int element) {
    if (x == n) return -1;
    if (a[x] == element) return x;
    return recursive(a, x + 1, n, element);
  }
}
