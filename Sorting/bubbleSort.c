#include<stdio.h>
#include<time.h>

int main(){
    
    int n;

    int a[100];

    printf("Enter a number of ele:");
    scanf("%d",&n);

    printf("Enter %d ele : \n",n);

    for(int i=0;i<n;i++){
        scanf("%d",&a[i]);
    }

    
    clock_t start = clock();
    
    
    for(int i=0;i<n-1;i++){
        for(int j=0;j<n-i-1;j++){
            if(a[j] > a[j+1]){
                
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }
        }
    }

    
    clock_t end = clock();

    
    printf("\nSorted Array:\n");

    for(int i = 0; i < n; i++)
    {
        printf("%d ", a[i]);
    }

    
    double time_taken = (double) (end-start)/CLOCKS_PER_SEC;

    printf("\n\nExecution Time = %f seconds\n",time_taken);

    return 0;
    
}