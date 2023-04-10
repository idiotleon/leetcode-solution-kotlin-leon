/**
 * https://leetcode.com/problems/split-array-largest-sum/
 *
 * Time Complexity:     O(size * lg(sum(nums) - max(nums))) ~ O(size * lg(sum(nums)))
 *  size, the total amount of elements
 *  sum(nums) - max(nums), the search range
 *
 * Space Complexity:    O(1)
 *
 * The answer must be in the range:
 * Lower Bound: max value of nums
 *  this means, no matter what nums, m is, how nums is going to be split,
 *  the min value of largest sum always is bigger than the largest value in nums
 *
 * Upper Bound: sum of nums (plus 1, depending on whether the last value is exclusive or inclusive)
 *  this means, no matter what nums, m is, how nums is going to be split,
 *  the min value of largest sum always is smaller than the total sum of nums
 *
 * Given a candidate C, to compute the number groups k needed
 *
 * if k > m: C is too small
 *  lo = C + 1
 * else
 *  hi = C
 *
 * References:
 *  https://leetcode.com/problems/split-array-largest-sum/discuss/89817/Clear-Explanation:-8ms-Binary-Search-Java/512238
 *  https://leetcode.com/problems/split-array-largest-sum/discuss/89817/Clear-Explanation:-8ms-Binary-Search-Java/94310
 *  https://leetcode.com/problems/split-array-largest-sum/discuss/89817/Clear-Explanation%3A-8ms-Binary-Search-Java
 *  https://youtu.be/_k-Jb4b7b_0
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-410-split-array-largest-sum/
 *  https://leetcode.com/problems/divide-chocolate/discuss/408503/JavaC++Python-Binary-Search/494896
 *  https://leetcode.com/problems/divide-chocolate/discuss/408503/JavaC++Python-Binary-Search/380399
 *  https://leetcode.com/problems/divide-chocolate/discuss/408503/JavaC++Python-Binary-Search/394052
 *
 * #BinarySearch
 * #Greedy
 */
package com.idiotleon.leetcode.lvl4.lc0410

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun splitArray(nums: IntArray, m: Int): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        var lo = 0L
        var hi = 0L
        for (num in nums) {
            lo = maxOf(lo, num.toLong())
            hi += num
        }

        while (lo < hi) {
            val mid: Long = lo + (hi - lo) / 2

            if (minGroups(mid, nums) > m) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }

        return lo.toInt()
    }

    private fun minGroups(limit: Long, nums: IntArray): Int {
        var sum = 0
        var groups = 1
        for (num in nums) {
            if (sum + num > limit) {
                sum = num
                ++groups
            } else {
                sum += num
            }
        }

        return groups
    }
}