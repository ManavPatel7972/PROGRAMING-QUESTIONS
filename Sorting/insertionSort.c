#include <stdio.h>
#include <time.h>

int main()
{
    int n;
    int a[100];

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter %d elements:\n", n);

    for(int i = 0; i < n; i++) 
    {
        scanf("%d", &a[i]);
    }

    
    clock_t start = clock();

    
    for(int i = 1; i < n; i++)
    {
        int key = a[i];
        int j = i - 1;

        while(j >= 0 && a[j] > key)
        {
            a[j + 1] = a[j];
            j--;
        }

        a[j + 1] = key;
    }

    
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