package com.idiotleon.leetcode.lvl3.lc1760

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
 *
 * Time Complexity:     O(`nNums` * lg(`max`))
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/solutions/1064548/java-c-python-binary-search/?envType=company&envId=facebook&favoriteSlug=facebook-six-months&difficulty=MEDIUM
 */
@Suppress(UNUSED)
class Solution0BinarySearch {
    class Solution {
        fun minimumSize(nums: IntArray, maxOperations: Int): Int {
            val nNums = nums.size
            val max = nums.max()

            var lo = 1
            var hi = max

            while (lo < hi) {
                val mid = lo + (hi - lo) / 2
                val count = getCount(nums, mid)
                if (count > maxOperations) {
                    lo = 1 + mid
                } else {
                    hi = mid
                }
            }

            return lo
        }

        private fun getCount(nums: IntArray, mid: Int): Int {
            var count = 0
            for (num in nums) {
                count += (num - 1) / mid
            }
            return count
        }
    }
}