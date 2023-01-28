public class NQueen {
    static int N = 5;
    static int q = 0;

    public static void main(String[] args) {
        int arr[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = 0;
            }
        }
        solve(arr, 0, 0);
        print(arr);
    }

    static boolean solve(int arr[][], int i, int j) {
        if (q == N)
            return true;

        for (int k = 0; k < N; k++) {
            if (check(i, j + k, arr)) {
                arr[i][j + k] = 8;
                q++;
                if (solve(arr, i + 1, j))
                    return true;
                else {
                    arr[i][j + k] = 0;
                    q--;
                }
            }
        }
        return false;
    }

    static boolean check(int i, int j, int arr[][]) {
        int w, v;
        for (w = i; w >= 0; w--) {
            if (arr[w][j] == 8)
                return false;
        }

        for (w = i, v = j; w >= 0 && v >= 0; w--, v--) {
            if (arr[w][v] == 8)
                return false;
        }

        for (w = i, v = j; w >= 0 && v < N; w--, v++) {
            if (arr[w][v] == 8)
                return false;
        }

        return true;
    }

    static void print(int arr[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
