class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private int n;
    private int[] nums;

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void helper(int start) {
        
        if(start == n) {
            List<Integer> list = new ArrayList<>();
            for(int num : nums) {
                list.add(num);
            }
            ans.add(list);
            return;
        }

        for(int i = start; i < n; i++) {
            swap(start, i);
            helper(start + 1);
            swap(start, i);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        helper(0);
        return ans;
    }
}