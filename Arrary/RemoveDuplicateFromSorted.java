
// -----------------------------BRUTE FORCE------------------------

// import java.util.HashSet;
// import java.util.Set;

// public class RemoveDuplicateFromSorted {
//     public static void main(String[] args) {
//         int[] nums = {0,0,1,1,1,2,2,3,3,4};

//         removeDuplicates(nums);

//         // System.out.println("Unique count = " + k);
//         // System.out.print("Array after removing duplicates: ");

//         // for(int i=0;i<k;i++){
//         //     System.out.println(nums[i] + " ");
//         // }
//     }

//     public static void removeDuplicates(int[] n){
//         Set<Integer> s = new HashSet<>();

//         for(int i=0;i<n.length;i++){
//             s.add(n[i]);
//         }

//         System.out.println(s);
//     }
// }

// ---------------------OPTIMAL------------------------------

public class RemoveDuplicateFromSorted {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

       int k =  removeDuplicates(nums);

        System.out.println("Unique count = " + k);
        System.out.print("Array after removing duplicates: ");

        for(int i=0;i<k;i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] n){
        
        if(n.length == 0) return 0;

        int i=0;
        for(int j=1;j<n.length;j++){
            if(n[i] != n[j]){
                i++;
                n[i] = n[j];
            }
        }

        return i+1;
    }
}