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
    public boolean canAttendMeetings(List<Interval> intervals) {
        // they should not merge.
        if(intervals.size()==0)return true;
        Collections.sort(intervals, (x,y) -> {
            if(x.start != y.start) return x.start - y.start;
            return x.end - y.end;
        });
        Interval curr = new Interval(-1,-1);
        curr.start = intervals.get(0).start;
        curr.end = intervals.get(0).end;
        for(int i = 1;i < intervals.size(); i++){
            if(intervals.get(i).start < curr.end){
                return false;
            }   
            curr.start = intervals.get(i).start;
            curr.end = intervals.get(i).end;
        }
        return true;
        
    }
}
