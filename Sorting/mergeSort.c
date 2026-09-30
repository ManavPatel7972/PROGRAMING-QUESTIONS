#include <stdio.h>
#include <time.h>

int a[100];

void merge(int low, int mid, int high)
{
    int i = low;
    int j = mid + 1;
    int k = 0;

    int temp[100];

    while(i <= mid && j <= high)
    {
        if(a[i] < a[j])
        {
            temp[k] = a[i];
            i++;
        }
        else
        {
            temp[k] = a[j];
            j++;
        }

        k++;
    }

    while(i <= mid)
    {
        temp[k] = a[i];
        i++;
        k++;
    }

    while(j <= high)
    {
        temp[k] = a[j];
        j++;
        k++;
    }

    k=0;
    for(i = low; i <= high; i++)
    {
        a[i] = temp[k++];
    }
}

void mergeSort(int low, int high)
{
    if(low < high)
    {
        int mid = (low + high) / 2;

        mergeSort(low, mid);
        mergeSort(mid + 1, high);

        merge(low, mid, high);
    }
}

int main()
{
    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter %d elements:\n", n);

    for(int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }

    
    clock_t start = clock();

    
    mergeSort(0, n - 1);

    
    clock_t end = clock();

    printf("\nSorted Array:\n");

    for(int i = 0; i < n; i++)
    {
        printf("%d ", a[i]);
    }

    double time_taken = (double)(end - start) / CLOCKS_PER_SEC;

    printf("\n\nExecution Time = %f seconds\n", time_taken);

    return 0;
}