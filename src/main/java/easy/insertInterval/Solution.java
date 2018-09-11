package easy.insertInterval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hejiajun
 * On 2018/9/11
 */
class Interval {
    int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(5, 9));

        Interval newInterval = new Interval(2, 5);

        new Solution().insert(intervals, newInterval).forEach(System.out::println);
    }

    /**
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        List<Interval> result = new ArrayList<>();

        if (newInterval == null) {
            return intervals;
        }

        if (intervals.size() == 0 && newInterval != null) {
            result.add(newInterval);
            return result;
        }

        int length = intervals.size();
        int current = 0;

        // In front of newInterval, and non-overlapping.
        while (current < length && intervals.get(current).end < newInterval.start) {
            result.add(intervals.get(current));
            current++;
        }

        // Overlapping.
        while (current < length && intervals.get(current).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(current).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(current).end, newInterval.end);
            current++;
        }
        result.add(newInterval);

        // After newInterval, and non-overlapping.
        while (current < length) {
            result.add(intervals.get(current++));
        }

        return result;
    }
}
