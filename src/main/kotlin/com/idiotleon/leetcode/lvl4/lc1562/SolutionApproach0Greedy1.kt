package com.idiotleon.leetcode.lvl4.lc1562

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-latest-group-of-size-m/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/find-latest-group-of-size-m/discuss/806786/JavaC++Python-Count-the-Length-of-Groups-O(N)/669065
 * https://leetcode.com/problems/find-latest-group-of-size-m/discuss/806786/JavaC%2B%2BPython-Count-the-Length-of-Groups-O(N)
 */
@Suppress(UNUSED)
class SolutionApproach0Greedy1 {
    fun findLatestStep(nums: IntArray, m: Int): Int {
        val nNums = nums.size
        var latest = -1

        val lens = IntArray(nNums + 2) { 0 }
        val counts = IntArray(nNums + 1) { 0 }

        for (idx in nums.indices) {
            val num = nums[idx]
            val lo = lens[num - 1]
            val hi = lens[num + 1]

            lens[num + hi] = lo + hi + 1
            lens[num - lo] = lens[num + hi]
            lens[num] = lens[num - lo]

            --counts[lo]
            --counts[hi]
            ++counts[lens[num]]

            if (counts[m] > 0) latest = idx + 1
        }

        return latest
    }
}