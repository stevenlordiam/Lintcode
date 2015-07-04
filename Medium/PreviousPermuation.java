/*
Given a list of integers, which denote a permutation.

Find the previous permutation in ascending order.

Have you met this question in a real interview? Yes
Example
For [1,3,2,3], the previous permutation is [1,2,3,3]

For [1,2,3,4], the previous permutation is [4,3,2,1]

Note
The list may contains duplicate integers
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        int peakInd = nums.size()-1;
        while (peakInd > 0 && nums.get(peakInd-1) <= nums.get(peakInd)) {
            peakInd--;
        }
        peakInd--;
        if (peakInd >= 0) {
            int swapInd = peakInd+1;
            while (swapInd < nums.size() && nums.get(swapInd) < nums.get(peakInd)) {
                swapInd++;
            }
            swapInd--;
            int tmp = nums.get(swapInd);
            nums.set(swapInd, nums.get(peakInd));
            nums.set(peakInd, tmp);
        }
        int left = peakInd+1;
        int right = nums.size()-1;
        while (left < right) {
            int tmp = nums.get(left);
            nums.set(left, nums.get(right));
            nums.set(right, tmp);
            left++;
            right--;
        }
        return nums;
    }
}

/*
思路：和next permutation完全一致的思路。
从右往左扫，找到一个增长pivot，这个大的数字就是即将被换掉的。从这个数字往右必然是一个递增序列，往右扫，直到找到一个数比这个pivot小而且是所有右边数字中最大的，然后交换pivot和该数字。
从大到小sort pivot右边的数字，由于右边序列是递增的，我们只需交换左右指针来进行排序即可

http://blog.csdn.net/nicaishibiantai/article/details/43794709
http://www.cnblogs.com/EdwardLiu/p/4385825.html
http://www.cnblogs.com/lishiblog/p/4191079.html
http://www.cnphp6.com/archives/81124
http://www.shuatiblog.com/blog/2014/06/27/Previous-Permutation/
*/