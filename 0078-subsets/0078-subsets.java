class Solution {
    public List<List<Integer>> ans = new ArrayList<>();
    public int n;

    private void helper(int[] nums, ArrayList<Integer> list, int idx) {
        if(idx == n){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        helper(nums, list, idx + 1);

        list.remove(list.size() - 1);
        helper(nums, list, idx + 1);
    } 

    public List<List<Integer>> subsets(int[] nums) {
        this.n = nums.length;
        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>();
        helper(nums, list, idx);
        return ans;

    }
}