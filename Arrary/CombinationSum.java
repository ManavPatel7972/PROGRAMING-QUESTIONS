import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        // candidates, target, start, current, res
        backtrack(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    public void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        // explore all paths
        for (int i = start; i < candidates.length; i++) {

            current.add(candidates[i]);

            // here i not i+1 bcz -> multiple time candidates selection allow
            backtrack(candidates, target - candidates[i], i, current, res);

            // remove last chosen
            current.remove(current.size() - 1);
        }
    }
}