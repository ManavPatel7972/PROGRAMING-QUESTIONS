public class SetMatrixToZero {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};

        System.out.println("Before");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
        setZeroesBetter(arr);

        System.out.println("After");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0){

                    // make row to -1 except zero
                    for(int col = 0; col < m; col++){
                        if(arr[i][col] != 0){
                            arr[i][col] = -1;
                        }
                    }

                    // make col to -1 except zero
                    for(int row = 0; row < n; row++){
                        if(arr[row][j] != 0){
                            arr[row][j] = -1;
                        }
                    }

                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == -1){
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void setZeroesBetter(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        boolean[] col = new boolean[m];
        boolean[] row = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(row[i] || col[j]){
                    arr[i][j] = 0;
                }
            }
        }
    }
}
