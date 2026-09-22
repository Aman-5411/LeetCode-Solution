class Solution {
    public List<List<Integer>> ans = new ArrayList<>();
    public HashSet<ArrayList<Integer>> set = new HashSet<>();
    public int n;

    private void helper(int[] nums, ArrayList<Integer> list, int idx) {
        if(idx == n){
            set.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        helper(nums, list, idx + 1);

        list.remove(list.size() - 1);
        helper(nums, list, idx + 1);
    } 

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.n = nums.length;
        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>();
        helper(nums, list, idx);
        ans = new ArrayList<>(set);
        ans.sort((list1, list2) -> {
            int minSize = Math.min(list1.size(), list2.size());
            for (int i = 0; i < minSize; i++) {
                int cmp = list1.get(i).compareTo(list2.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(list1.size(), list2.size());
        });
        return ans;

    }
}