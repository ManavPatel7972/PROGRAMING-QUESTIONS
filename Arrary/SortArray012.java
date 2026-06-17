public class SortArray012 {

    public static void main(String[] args) {
        int[] arr = {0,1,2,1};
        threePointer(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sort(int[] arr) {

    int[] temp = new int[arr.length];
    int c = 0;

    for (int i = 0; i < arr.length; i++) {

        boolean alreadyProcessed = false;

        for (int k = 0; k < i; k++) {
            if (arr[k] == arr[i]) {
                alreadyProcessed = true;
                break;
            }
        }

        if (alreadyProcessed) {
            continue;
        }

        for (int j = i; j < arr.length; j++) {
            if (arr[j] == arr[i]) {
                temp[c++] = arr[j];
            }
        }
    }

    for (int i = 0; i < arr.length; i++) {
        arr[i] = temp[i];
    }
}

public static void sort2(int[] arr) {

    int c0 = 0, c1 = 0, c2 = 0;

    for (int num : arr) {
        if (num == 0) c0++;
        else if (num == 1) c1++;
        else c2++;
    }

    int i = 0;

    while (c0-- > 0) arr[i++] = 0;
    while (c1-- > 0) arr[i++] = 1;
    while (c2-- > 0) arr[i++] = 2;
}

public static void threePointer(int[] arr){

    int low = 0;
    int mid = 0;
    int high =  arr.length-1;

    while (mid<=high) {
        
        if(arr[mid] == 0){
            int temp = arr[low];
            arr[low] = arr[mid];
            arr[mid] = temp;

            low++;
            mid++;

        }
        else if(arr[mid] == 1){
            mid++;
        }
        else{
            int temp = arr[mid];
            arr[mid] = arr[high];
            arr[high] = temp;

            high--;
        }
    }
}
}