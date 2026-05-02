class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int ans[] = new int[2 * n];
        int idx = 0;
        for(idx = 0; idx < n; idx++){
            ans[idx] = nums[idx];
            ans[idx+n] = nums[idx];
        }
        return ans;
    }
}