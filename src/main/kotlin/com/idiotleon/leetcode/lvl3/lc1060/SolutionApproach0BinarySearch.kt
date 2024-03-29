/**
 * https://leetcode.com/problems/missing-element-in-sorted-array/
 *
 * Time Complexity:     O(lg(maxOf(`nNums`, `k`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/missing-element-in-sorted-array/discuss/303444/Java-O(logN)-solution-Binary-Search/609578
 *  https://leetcode.com/problems/missing-element-in-sorted-array/discuss/303444/Java-O(logN)-solution-Binary-Search
 */
package com.idiotleon.leetcode.lvl3.lc1060

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun missingElement(nums: IntArray, k: Int): Int {
        val nNums = nums.size
        val base = nums[0]

        var lo = 0
        var hi = nNums

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            val missingNum = nums[mid] - (base + mid)

            if (missingNum >= k) {
                hi = mid
            } else {
                lo = mid + 1
            }
        }

        return nums[lo - 1] + (k - nums[lo - 1]) + (base + lo - 1)
    }
}