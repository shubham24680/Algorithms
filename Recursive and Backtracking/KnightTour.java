// import java.util.Scanner;

// -> 2 down, 1 right
// -> 2 right, 1 down
// -> 2 right, 1 up
// -> 2 up, 1 right
// -> 2 up, 1 left
// -> 2 left, 1 down
// -> 2 left, 1 up
// -> 2 down, 1 left
// # knightTour(i)
// 1. check all above condition:
// 	if TRUE(empty)
// 	knightTour(i++)
// 	else
// 	store(i) at that place.

// public class KnightTour {
//     public static void main(String[] args) {
//         try (Scanner scan = new Scanner(System.in)) {
//             System.out.print("Enter the board size:");
//             int size = scan.nextInt();
//             int arr[][] = new int[size][size];
//             for (int w = 0; w < size; w++) {
//                 for (int v = 0; v < size; v++) {
//                     arr[w][v] = -1;
//                 }
//             }
//             board(arr, 0, 0, 0, size);
//             print(arr, size);
//         }
//     }

//     public static void board(int arr[][], int i, int j, int count, int size) {
//         arr[i][j] = count++;
//         if (check(arr, i + 2, j + 1, size))
//             board(arr, i + 2, j + 1, count, size);
//         else if (check(arr, i + 1, j + 2, size))
//             board(arr, i + 1, j + 2, count, size);
//         else if (check(arr, i - 1, j + 2, size))
//             board(arr, i - 1, j + 2, count, size);
//         else if (check(arr, i - 2, j + 1, size))
//             board(arr, i - 2, j + 1, count, size);
//         else if (check(arr, i - 2, j - 1, size))
//             board(arr, i - 2, j - 1, count, size);
//         else if (check(arr, i + 1, j - 2, size))
//             board(arr, i + 1, j - 2, count, size);
//         else if (check(arr, i - 1, j - 2, size))
//             board(arr, i - 1, j - 2, count, size);
//         else if (check(arr, i + 2, j - 1, size))
//             board(arr, i + 2, j - 1, count, size);
//     }

//     public static boolean check(int arr[][], int i, int j, int size) {
//         return (0 <= i && i < size && 0 <= j && j < size && arr[i][j] == -1) ? true : false;
//     }

//     public static void print(int arr[][], int size) {
//         for (int w = 0; w < size; w++) {
//             for (int v = 0; v < size; v++) {
//                 System.out.print(arr[w][v] + " ");
//             }
//             System.out.println();
//         }
//     }
// }

// Time Complexity: O(N^N^2)
// Auxilary Space: O(N^2)

public class KnightTour {
    static int N = 8;

    public static void main(String[] args) {
        int solve[][] = new int[N][N];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                solve[x][y] = -1;

        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        solve[0][0] = 0;

        if (!solveKTuntil(0, 0, 1, solve, xMove, yMove)) {
            System.out.println("ERROR");
            return;
        } else
            print(solve);
    }

    static boolean solveKTuntil(int x, int y, int move, int solve[][], int xMove[], int yMove[]) {
        int k, x_next, y_next;
        if (move == N * N)
            return true;

        for (k = 0; k < N; k++) {
            x_next = x + xMove[k];
            y_next = y + yMove[k];
            if (isSafe(x_next, y_next, solve)) {
                solve[x_next][y_next] = move;
                if (solveKTuntil(x_next, y_next, move + 1, solve, xMove, yMove)) {
                    return true;
                } else
                    solve[x_next][y_next] = -1;
            }
        }
        return false;
    }

    static boolean isSafe(int x, int y, int solve[][]) {
        return (0 <= x && x < N && 0 <= y && y < N && solve[x][y] == -1);
    }

    static void print(int solve[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(solve[x][y] + " ");
            System.out.println();
        }
    }
}