import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        // int r = 4, c = 3;
        // printRowOfPascalBrute(r);
        // System.out.println("Element = " + findPascalEle(r,c));
        // List<Long> li = printRowOfPascalOptimal(5);
        // for(long l : li){
        //     System.out.print(l + " ");
        // }

        List<List<Integer>> li = printPascalBrute(5);

       System.out.println(li);
    }

    public static int findPascalEle(int r, int c){
        int n = r-1;
        int m = c-1;

        int res = 1;

        // C(n,m);
        for(int i=0;i<m;i++){
            res *= (n-i);
            res /= (i+1);
        }

        return res;
    }


    public static void printRowOfPascalBrute(int row){
        for(int c=1;c<=row;c++){
            System.out.print(" " + findPascalEle(row, c));
        }
    }

    public static List<Long> printRowOfPascalOptimal(int n){
        List<Long> li = new ArrayList<>();
            
        long res = 1;
        li.add(res);

        for(int i=1;i<n;i++){
            res = res * (n-i);
            res = res / i;
            li.add(res);
        }

        return li;
        
    }

    public static List<List<Integer>> printPascalBrute(int n){
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=1;i<=n;i++){

            List<Integer> temp = new ArrayList<>();
 
            for(int j=1;j<=i;j++){
                temp.add((Integer) findPascalEle(i,j));
            }
            ans.add(temp);
        }

        return ans;
    }
}
