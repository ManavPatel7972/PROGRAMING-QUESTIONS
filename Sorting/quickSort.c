#include <stdio.h>
#include <time.h>

int a[100];

int partition(int low, int high)
{
    
    int pivot = a[low];

    int i = low + 1;
    int j = high;

    while(i <= j)
    {
        
        while(i <= high && a[i] <= pivot)
        {
            i++;
        }

        
        while(j >= low + 1 && a[j] > pivot)
        {
            j--;
        }

        
        if(i < j)
        {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    
    int temp = a[low];
    a[low] = a[j];
    a[j] = temp;

    return j;
}

void quickSort(int low, int high)
{
    if(low < high)
    {
        int pi = partition(low, high);

        quickSort(low, pi - 1);
        quickSort(pi + 1, high);
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

    
    quickSort(0, n - 1);

    
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