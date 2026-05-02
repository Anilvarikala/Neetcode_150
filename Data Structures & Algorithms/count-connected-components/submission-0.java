class Solution {
    Set<Integer> visited = new HashSet<>();

    public void dfs(int src, Map<Integer,List<Integer>> adj){
        if(visited.contains(src)) return;
         visited.add(src);
        for(int v : adj.get(src)){
            if(!visited.contains(v)){
                dfs(v,adj);
            }
        } 

    }
    public int countComponents(int n, int[][] edges) {
        //create a graph
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int i = 0;i <= n-1;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int []edge : edges){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //run bfs
        int connected = 0;
        for(int i = 0; i < n;i++){
            if(!visited.contains(i)){
              dfs(i,adj);
              connected++;
            }
        }
        return connected;
    }
}
