class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        
        Map<Character, Integer> mp = new HashMap<>();
        for(char ch : s.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        for(char ch : t.toCharArray()){
              if(!mp.containsKey(ch)) return false;
              int val = mp.get(ch);
              if(val == 1) mp.remove(ch);
              else mp.put(ch, val - 1);
        }
        return true;
    }
}
