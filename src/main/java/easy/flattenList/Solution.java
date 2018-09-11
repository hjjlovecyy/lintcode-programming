package easy.flattenList;

import java.util.ArrayList;
import java.util.List;


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}

/**
 * can not use recursion
 */
public class Solution {
    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        boolean flag = true;

        while (flag) {
            flag = false;
            List<NestedInteger> temp = new ArrayList<>();
            for (NestedInteger ni: nestedList) {
                if (ni.isInteger())
                    temp.add(ni);
                else {
                    temp.addAll(ni.getList());
                    flag = true;
                }
            }
            nestedList = temp;
        }

        for (NestedInteger ni: nestedList)
            result.add(ni.getInteger());
        return result;
    }
}
