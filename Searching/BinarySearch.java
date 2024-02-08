public class BinarySearch {

  int iterative(int[] a, int x, int n, int element) {
    int mid;
    while (x <= n) {
      mid = x + (n - x) / 2;
      if (a[mid] == element) return mid;

      if (a[mid] < element) x = mid + 1; else n = mid - 1;
    }

    return -1;
  }

  int recursive(int[] a, int x, int n, int element) {
    int mid;
    if (x <= n) {
      mid = x + (n - x) / 2;
      if (a[mid] == element) return mid;

      if (a[mid] < element) return recursive(a, mid + 1, n, element);
      return recursive(a, x, mid - 1, element);
    }

    return -1;
  }
}
