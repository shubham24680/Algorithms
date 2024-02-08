public class ExponentialSearch {
    int iterative(int[] a, int x, int n, int element) {
        if(a[0] == element)
            return 0;

        int i = 1;
        while(i < n && a[i] <= element)
            i *= 2;

        BinarySearch search = new BinarySearch();
        return search.iterative(a, i/2, Math.min(i, n - 1), element);
    }
}
