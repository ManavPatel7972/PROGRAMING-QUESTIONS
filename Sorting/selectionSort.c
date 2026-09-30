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

    
    for(int i = 0; i < n - 1; i++)
    {
        int min = i;

        for(int j = i + 1; j < n; j++)
        {
            if(a[j] < a[min])
            {
                min = j;
            }
        }

        
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
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