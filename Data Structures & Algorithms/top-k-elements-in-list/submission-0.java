class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new LinkedHashMap<>();
        for(int i : nums){
            mp.put(i, mp.getOrDefault(i, 0)+1);
        }
        int []ans = new int[k];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            return  y[1] - x[1];
        });
        for(int key : mp.keySet()){
            pq.add(new int[] { key, mp.get(key)});
        }
        int idx = 0;
        int cnt= 0;
        while(!pq.isEmpty()){
              ans[idx++] = pq.remove()[0];
              cnt++;
              if(cnt==k)break;
        }
        return ans;


    }
}
