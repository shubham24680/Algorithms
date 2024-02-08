public class FibonacciSearch {
    int iterative(int a[], int x, int n, int element) {
        int i = x, j = 1, s;
        while(i < n && a[i] <= element) {
            s = i + j;
            i = j;
            j = s;
        }

        BinarySearch search = new BinarySearch();
        return search.iterative(a, j - i, Math.min(i, n), element);
    }
}