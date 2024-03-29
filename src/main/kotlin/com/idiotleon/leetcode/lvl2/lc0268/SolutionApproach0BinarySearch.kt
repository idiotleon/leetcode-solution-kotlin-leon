package com.idiotleon.leetcode.lvl2.lc0268

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/missing-number/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination/282752
 */
@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun missingNumber(nums: IntArray): Int {
        val nNums = nums.size

        nums.sort()

        var lo = 0
        var hi = nNums

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid] == mid)
                lo = mid + 1
            else
                hi = mid
        }

        return lo
    }
}