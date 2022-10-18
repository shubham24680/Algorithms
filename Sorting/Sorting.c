#include <stdio.h>
#include <math.h>

void selectionSort(int a[], int n);
void bubbleSort(int a[], int n);
void insertionSort(int a[], int n);
void combSort(int a[], int n);
void bitonicSort(int a[], int l, int r, int u);
void bitonicmerge(int a[], int l, int r, int u);
void swaps(int a[], int l, int r, int u);
void pegionholeSort(int a[], int n);
void quickSortNormal(int a[], int beg, int end);
void quickSortTailOptimization(int a[], int beg, int end);
int lomutoPartitionScheme(int a[], int low, int high);
int hoarePartitionScheme(int a[], int low, int high);
void mergeSort(int a[], int beg, int end);
void all_merge(int a[], int beg, int mid, int end);
void heapSort(int arr[], int n);
void heapify(int arr[], int n, int i);
void print(int array[], int n);

int main()
{
    system("cls");
	long long int n, i, j;
    printf("SORTING ALGORITHM\n");
    printf("-----------------\n");
    printf("It is a method for reorganizing a large number of items into a specific order.\n\n");
	printf("^> Enter the length of the Array: ");
	scanf("%d", &n);

	long long int *a = malloc(sizeof(long long int)*n);
	printf("^> Enter the element of the array: \n");
	for (i = 0; i < n; i++)
		scanf("%lld", (a+i));

	selectionSort(a,n);
	// bubbleSort(a, n);
	// insertionSort(a,n);
	// combSort(a,n);
	// bitonicSort(a,0,n-1,1);
	// pegionholeSort(a,n);
	// quickSortNormal(a,0,n-1);
	// quickSortTailOptimization(a,0,n-1);
	// mergeSort(a,0,n-1);
	// heapSort(a,n);

	print(a,n);
	return 0;
}

// Time Complexity : O(n^2).
// Space Complexity : O(n).
void selectionSort(int a[], int n)
{
	for (int i = 0; i < n; i++)
	{
		for (int j = i + 1; j < n; j++)
		{
			if (a[i] > a[j])
			{
				int change = a[i];
				a[i] = a[j];
				a[j] = change;
			}
		}
	}
}

// Time Complexity : O(n^2) (worst case) to O(n) (Best case).
// Space Complexity : O(1).
/* Similar :-
* Cocktail Sort take bubble sort for both direction.
Time Complexity : O(n^2) (worst case) to O(n) (Best case). */
void bubbleSort(int a[], int n)
{
	for (int i = 0; i < n - 1; i++)
	{
		for (int j = 0; j < n - i - 1; j++)
		{
			if (a[j] > a[j + 1])
			{
				int change = a[j];
				a[j] = a[j + 1];
				a[j + 1] = change;
			}
		}
	}
}

//  Time Complexity : O(n^2).
// Space Complexity : O(1).
void insertionSort(int a[], int n)
{
	int i, j, key;
	for (i = 1; i < n; i++)
	{
		key = a[i];
		j = i - 1;
		while (j >= 0 && a[j] > key)
		{
			a[j + 1] = a[j];
			j = j - 1;
		}
		a[j + 1] = key;
	}
}

//  Time Complexity : O((n^2)/(2^p)) p = no. of increment.
// Auxilary Space : O(1).
// Improvement over Bubble Sort.
void combsort(int a[], int n)
{
    int gap = n;
    int check = 1;
    while (gap != 1 || check == 1)
    {
        gap = (gap < 1) ? 1 : gap / 1.3;
        check = 0;
        for (int i = 0; i < (n - gap); i++)
        {
            if (a[i] > a[i + gap])
            {
                int change = a[i];
                a[i] = a[i + 1];
                a[i + 1] = change;
                check = 1;
            }
        }
    }
}

void bitonicsort(int a[], int l, int r, int u)
{
    if (r > l)
    {
        int k = r / 2;
        bitonicsort(a, l, k, 1);
        bitonicsort(a, l + k, k, 0);
        bitonicmerge(a, l, r, u);
    }
}

void bitonicmerge(int a[], int l, int r, int u)
{
    if (r > l)
    {
        int k = r / 2;
        for (int i = l; i < (l + k); i++)
            swaps(a, i, i + k, u);
        bitonicmerge(a, l, k, u);
        bitonicmerge(a, l + k, k, u);
    }
}

void swaps(int a[], int l, int r, int u)

{
    if ((a[l] > a[r] && u == 1) || (a[l] < a[r] && u == 0))
    {
        int change = a[l];
        a[l] = a[r];
        a[r] = change;
    }
}

void pegionholeSort(int a[], int n)
{
    int min = a[0], max = a[0];
    for (int i = 1; i < n; i++)
    {
        if (a[i] > max)
            max = a[i];
            
        if (a[i] < min)
            min = a[i];
    }

    int range = (max - min + 1);
    int ph[range];
    for (int i = 0; i < range; i++)
        ph[i] = 0;

    for (int i = 0; i < n; i++)
    {
        ph[a[i] - min]++;
        // printf("%d %d\n", a[i] - min, ph[a[i] - min]);
    }

    int index = 0;
    for (int i = 0; i < range; i++)
        while (ph[i]-- > 0)
        {
            a[index++] = (i + min);
            // printf("%d %d\n", index - 1, i + min);
        }
}

// NORMAL PROCESS.
// Time Complexity : O(nlogn).
// Space Complexity : O(logn).
void quickSortNormal(int a[], int beg, int end)
{
    if (beg < end)
    {
        int p = lomutoPartitionScheme(a, beg, end);
		// int p = hoarePartitionScheme(a, beg, end);
        quickSortNormal(a, beg, p - 1);
        quickSortNormal(a, p + 1, end);
    }
}

// TAIL CALL OPTIMIZATION.
void quickSortTailOptimization(int a[], int beg, int end)
{
    while(beg < end)
    {
        // int p = lomutoPartitionScheme(a,beg,end);
		int p = hoarePartitionScheme(a,beg,end);
        if((p-beg) < (end-p))
        {
            quickSortTailOptimization(a,beg,p-1);
            beg = p + 1;
        }
        else
        {
            quickSortTailOptimization(a,p+1,end);
            end = p - 1;
        }
    }
}

// LOMUTO PARTITION SCHEME.
int lomutoPartitionScheme(int a[], int low, int high)
{
    int pivot = a[high];
    int i = low - 1;
    int j, change;

    for (j = low; j < high; j++)
    {
        if (a[j] < pivot)
        {
            i++;
            change = a[i];
            a[i] = a[j];
            a[j] = change;
        }
    }

    change = a[i + 1];
    a[i + 1] = a[high];
    a[high] = change;

    return (i + 1);
}

// HOARE'S PARTITION SCHEME.
int hoarePartitionScheme(int a[], int low, int high)
{
    int pivot = a[low];
    int i = low - 1;
    int j = high + 1;

    while (1)
    {
        do
        {
            i++;
        } while (a[i] < pivot);

        do
        {
            j--;
        } while (a[j] > pivot);

        if (i >= j)
            return j;
        int change = a[i];
        a[i] = a[j];
        a[j] = change;
    }
}

//Time Complexity : O(nlogn).
//Space Complexity : O(n).
void mergeSort(int a[], int beg, int end)
{
	if (beg < end)
	{
		int mid = beg + (end - beg) / 2;
		merge(a, beg, mid);
		merge(a, mid + 1, end);
		all_merge(a, beg, mid, end);
	}
}

void allMerge(int a[], int beg, int mid, int end)
{
	int n1 = mid - beg + 1;
	int n2 = end - mid;
	int arr1[n1], arr2[n2], i, j, k = beg;

	for (j = 0; j < n1; j++)
		arr1[j] = a[beg + j];

	for (i = 0; i < n2; i++)
		arr2[i] = a[mid + 1 + i];

	i = 0, j = 0;
	while (j < n1 && i < n2)
	{
		if (arr1[j] <= arr2[i])
		{
			a[k] = arr1[j];
			j++;
		}
		else
		{
			a[k] = arr2[i];
			i++;
		}
		k++;
	}

	while (j < n1)
	{
		a[k] = arr1[j];
		j++;
		k++;
	}

	while (i < n2)
	{
		a[k] = arr2[i];
		i++;
		k++;
	}
}

void heapSort(int arr[], int n)
{
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);

    for (int i = n - 1; i > 0; i--)
    {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        heapify(arr, i, 0);
    }
}

void heapify(int arr[], int n, int i)
{
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[l] > arr[largest])
        largest = l;

    if (r < n && arr[r] > arr[largest])
        largest = r;

    if (largest != i)
    {
        int swap = arr[i];
        arr[i] = arr[largest];
        arr[largest] = swap;

        heapify(arr, n, largest);
    }
}

void print(int array[], int n)
{
	for (int i = 0; i < n; i++)
		printf("%d\t", array[i]);
	printf("\n");
}