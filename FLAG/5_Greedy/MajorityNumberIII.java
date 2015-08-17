/*
Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.

Find it.

Have you met this question in a real interview? Yes
Example
Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.

Note
There is only one majority number in the array.

Challenge
O(n) time and O(k) extra space
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();    // key: candicate, value: count
        
        for (Integer i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
            
            if (map.size() >= k) {
                removeKey(map);     // 删除只出现一次的元素，保持map的size
            }
        }
        if (map.size() == 0) {
            return Integer.MIN_VALUE;
        }
        int ans = 0;
        int maxKey = 0;
        int max = 0;
        Set<Integer> keySet = map.keySet();     // 再扫一次
        for (Integer i : keySet) {
            int count = 0;
            for (Integer j : nums) {
                if (i.equals(j)) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                maxKey = i;
                ans = count;
            }
        }
        
        return maxKey;
    }
    
    private void removeKey(Map<Integer, Integer> map) {
        Set<Integer> keySet = map.keySet();
        List<Integer> removeList = new ArrayList<>();
        for (Integer key : keySet) {
            if (map.get(key) == 1) {
                removeList.add(key);        // 删除只出现一次的元素
            }
            else {
                map.put(key, map.get(key) - 1);     // 位置减一
            }
        }
        for (Integer key : removeList) {
            map.remove(key);
        }
    }
}