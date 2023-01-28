// Time Complexity: O(2^(N^2))
// Auxilary Complexity: O(N^2)

public class RatInAMaze {
    static int N = 4;
    static int xMove[] = { 1, 0 };
    static int yMove[] = { 0, 1 };

    public static void main(String[] args) {
        int arr[][] = { { 1, 1, 1, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 } };
        arr[0][0] = 2;
        arr[3][3] = 2;
        solve(arr, 0, 0);
        print(arr);
    }

    static boolean solve(int arr[][], int i, int j) {
        int k;
        for (k = 0; k < 2; k++) {
            if ((i + xMove[k]) == (N - 1) && (j + yMove[k]) == (N - 1))
                return true;

            if (check(arr, i + xMove[k], j + yMove[k])) {
                arr[i + xMove[k]][j + yMove[k]] = 2;
                if (solve(arr, i + xMove[k], j + yMove[k]))
                    return true;
            }
        }
        return false;
    }

    static boolean check(int arr[][], int i, int j) {
        return (0 <= i && i < N && 0 <= j && j < N && arr[i][j] == 1);
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
