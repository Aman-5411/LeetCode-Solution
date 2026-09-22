class Solution {
    public List<List<Integer>> ans;
    private HashSet<List<Integer>> set = new HashSet<>();
    private int n;
    private int[] nums;

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void helper(int idx){
        if(idx == n) {
            List<Integer> list = new ArrayList<>();
            for(int num : nums) {
                list.add(num);
            }
            set.add(list);
            return;
        }

        for(int i = idx; i < n; i++) {
            swap(i, idx);
            helper(idx + 1);
            swap(i, idx);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        helper(0);
        ans = new ArrayList<>(set);
        return ans;
    }
}