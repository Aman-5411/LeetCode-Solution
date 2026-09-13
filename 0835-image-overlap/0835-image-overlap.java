class Solution {
    private int helper(int[][] img1, int[][] img2, int r, int c) {
        int count = 0;
        int n = img1.length;
        for(int i = 0; i < img1.length; i++) {
            for(int j = 0; j < img1.length; j++) {
                if(r + i < 0 || c + j < 0 || r + i >= n || c + j >= n)    continue;

                count += img1[i][j] * img2[i + r][j + c];
            }
        }
        return count;
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int offset = (-1) * n - 1; //(-n + 1 --> n - 1)
        int ans = 0;

        //ye nested loop bata rha hai ki kitne tarah se overlap kar sakte hai like agar n = 2 hai toh {-1, 0, 1} ho tarah se row ko overlap kar sakte hai aur each overlapping me column bhi overlap kar sakte hai jo ki same rahega {-1, 0, 1} means -1 row offset ke liye col offset {-1, 0, 1} like wise for each.
        for(int i = offset; i < n; i++) {
            for(int j = offset; j < n; j++) {
                ans = Math.max(ans, helper(img1, img2, i, j));
            }
        }
        return ans;
    }
}