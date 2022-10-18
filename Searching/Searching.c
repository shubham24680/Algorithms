#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int linearSearch(int *a, int beg, int end, int x);
int jumpSearch(int *a, int beg, int end, int x);
int binarySearch(int *a, int beg, int end, int x);
int interpolationSearch(int *a, int beg, int end, int x);
int exponentialSearch(int *a, int beg, int end, int x);
void array(int *a, int n);

int main()
{
    int n, x, i;
    printf("Enter the length of the array: ");
    scanf("%d", &n);

    int *a = malloc(sizeof(int) * n);
    printf("Enter the element of the array: \n");
    for (i = 0; i < n; i++)
        scanf("%d", (a + i));

    printf("Enter the number you want to Search: ");
    scanf(" %d", &x);

    printf("1. Linear Search\n");
    printf("2. Jump Search\n");
    printf("3. Binary Search\n");
    printf("4. Interpolation Search\n");
    printf("Enter a number: ");
    char choose;
    scanf(" %c", &choose);
    switch (choose)
    {
    case '1':
        printf("LINEAR SEARCH\n");
        i = linearSearch(a, 0, n - 1, x);
        break;
    case '2':
        printf("JUMP SEARCH\n");
        i = jumpSearch(a, 0, n - 1, x);
        break;
    case '3':
        printf("BINARY SEARCH\n");
        i = binarySearch(a, 0, n - 1, x);
        break;
    case '4':
        printf("INTERPOLATION SEARCH\n");
        i = interpolationSearch(a, 0, n - 1, x);
        break;
    case '5':
        printf("EXPONENTIAL SEARCH\n");
        i = exponentialSearch(a, 0, n - 1, x);
    default:
        printf("Sorry you have entered a wrong number. Please choose it carefully.");
        break;
    }

    (i != -1) ? printf("Data found.") : printf("Data not found.");
    return 0;
}

// Time Complexity: O(n).
// Auxilary Space: O(1).
// int linearSearch(int *a, int beg, int end, int x)
// {
//     for (int i = beg; i <= end; i++)
//     {
//         if (*(a + i) == x)
//             return i;
//     }
//     return -1;
// }

// Time Complexity: O(n).
// Auxilary Space: O(1).
int linearSearch(int *a, int beg, int end, int x)
{
    if (beg == end + 1)
        return -1;

    if (*(a + beg) == x)
        return beg;

    return linearSearch(a, beg + 1, end, x);
}

// Time Complexity : O(n^0.5).
// Auxilary Space : O(1).
int jumpSearch(int *a, int beg, int end, int x)
{
    int i, d = sqrt(end - beg);
    for (i = beg; i <= end; i += d)
    {
        if (x == *(a + i))
            return i;

        if (x < *(a + i))
            return linearSearch(a, i - d, i, x);
    }
    linearSearch(a, i - d, end, x);
}

// Time Complexity : O(log(n)).
// Auxilary Space : O(1) to O(log(n)).
int exponentialSearch(int *a, int beg, int end, int x)
{
    if (*(a + beg++) == x)
        return 0;

    while (beg <= end && *(a + beg) <= x)
        beg *= 2;

    int min = (beg > end) ? end : beg;
    return binarySearch(a, beg / 2, min, x);
}

// Time Complexity : O(log(n)).
//  Auxilary Space : O(log(n)).
// int binarySearch(int *a, int beg, int end, int x)
// {
//     if (beg <= end)
//     {
//         int mid = beg + (end - beg) / 2;
//         if (*(a + mid) == x)
//             return mid;

//         if (*(a + mid) > x)
//             return binarySearch(a, beg, mid - 1, x);
//         else
//             return binarySearch(a, mid + 1, end, x);
//     }
//     return -1;
// }

// Time Complexity : O(logn).
//  Auxilary Space : O(1).
int binarySearch(int *a, int beg, int end, int x)
{
    while (beg <= end)
    {
        int mid = beg + (end - beg) / 2;
        if (*(a + mid) == x)
            return mid;
        else if (*(a + mid) < x)
            beg = mid + 1;
        else
            end = mid - 1;
    }
    return -1;
}

// Advance version of binary search.
/* General eqn. : y = m*x + c
a[end] = m*end + c  --- (1)
a[begin] = m*begin + c --- (2)
X = m*position + c --- (3)
subtract (2) from (3)
X - a[begin] = m*position - m*begin
position = begin + (X - a[begin])*(end - begin) / (a[end] - a[begin]) */
int interpolationSearch(int *a, int beg, int end, int x)
{
    if (beg <= end && x >= *(a + beg) && x <= *(a + end))
    {
        int pos = beg + (x - *(a + beg)) * (end - beg) / (*(a + end) - *(a + beg));
        if (*(a + pos) == x)
            return pos;

        if (*(a + pos) > x)
            return interpolationSearch(a, beg, pos - 1, x);
        else
            return interpolationSearch(a, pos + 1, end, x);
    }
    return -1;
}

void array(int *a, int n)
{
    printf("\n# List:- ");
    for (int i = 0; i < n; i++)
        printf("%d ", *(a + i));
    printf("\n");
}