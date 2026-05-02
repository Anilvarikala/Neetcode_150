class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int idx = 0;
        for(int ele : nums){
            mp.put(ele, idx);
            idx++;
        }
        for(int i = 0;i < nums.length; i++){
            int req = target - nums[i];
            if(mp.containsKey(req) && mp.get(req) != i){
                int ans[] = new int[2];
                ans[0] = mp.get(req);
                ans[1] = i;
                Arrays.sort(ans);
                return ans;
            }
        }
        return new int[] { -1, -1};
        }
}
