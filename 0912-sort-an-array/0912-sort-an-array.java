class Solution {
    public int[] sortArray(int[] nums) {
        int l = 0, r = nums.length - 1;
        mergeSort(nums, l, r);
        return nums;
    }

    public void mergeSort(int[] nums, int l , int r) {
        if(l >= r)
            return;
        
        int m  = l + (r - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        merge(nums, l , m , r);
    }

    public void merge(int[] nums, int l , int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0; i < n1; i++) {
            left[i] = nums[l + i];
        }

        for(int i = 0; i < n2; i++) {
            right[i] = nums[m + i + 1];
        }

        int i = 0, j = 0;
        int k = l;
        
        
        while(i < n1 && j < n2) {
            if(left[i] <= right[j]){
                nums[k] = left[i];
                i++;
            }

            else{
                nums[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            nums[k] = left[i];
            i++;
            k++;
        }

        while(j < n2){
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    
}