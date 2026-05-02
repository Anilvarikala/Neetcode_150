/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    boolean isConflict(Interval i, Interval j){
        return i.end > j.start;
    }
    public int minMeetingRooms(List<Interval> intervals) {
        int count = 0;
        Collections.sort(intervals, (x,y) -> {
           if(x.start != y.start) return x.start - y.start;
           return x.end - y.end;
        });

        Set<Integer> set = new HashSet<>();

        for(int i = 0;i < intervals.size(); i++){
            Interval ii = intervals.get(i);
            if(set.contains(i)) continue;
            count++;
            for(int j = i + 1; j < intervals.size(); j++){
                Interval ij = intervals.get(j);
                if(!set.contains(j)){
                    boolean ans = isConflict(ii, ij);
                    if(!ans){
                        set.add(j);
                        ii = ij;
                    }
                }
            }
        }
        return count;
        
    }
}
