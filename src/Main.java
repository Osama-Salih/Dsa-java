import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<List<Integer>> res;
    public static void main(String[] args) {
//        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(combinationSum2(new int[]{2,2,2}, 2));
//        System.out.println(combinationSum2(new int[]{2, 3, 5}, 8));
//        System.out.println(combinationSum2(new int[]{3, 5, 8}, 11));
//        System.out.println(combinationSum2(new int[]{2}, 1));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(0, new ArrayList<>(), 0, candidates, target);
        return res;
    }
    private static void dfs(int i, List<Integer> cur, int total, int[] nums, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) {
                return;
            }
            if (j > i && nums[j] == nums[j -1]) continue;
            cur.add(nums[j]);
            dfs(j + 1, cur, total + nums[j], nums,target);
            cur.remove(cur.size() - 1);
        }
    }
}