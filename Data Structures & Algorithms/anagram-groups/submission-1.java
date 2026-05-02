class Pair{
    String name;
    int idx;
    Pair(String n, int i){
        name = n;
        idx = i;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<Pair> l = new ArrayList<>();
        for(int i = 0;i < strs.length; i++){
            char temp[] = strs[i].toCharArray();
            Arrays.sort(temp);
            String st = new String(temp);
            l.add(new Pair(st, i));
           // System.out.println(st);
        }

        Map<String, List<Integer>> mp = new HashMap<>();
        for(int i = 0;i < l.size(); i++){
           Pair p = l.get(i);
           String curr = p.name;
           int id = p.idx;
           if(mp.containsKey(curr)) mp.get(curr).add(id);
           else{
            List<Integer> al = new ArrayList<>();
            al.add(id);
            mp.put(curr, al);
           }
        }

        List<List<String>> ans = new ArrayList<>();
        for(String key : mp.keySet()){
            List<Integer> ids = mp.get(key);
            List<String> tans = new ArrayList<>();
            for(int i : ids){
                tans.add(strs[i]);
            }
            ans.add(new ArrayList<>(tans));
        }

        return ans;

    }
}
