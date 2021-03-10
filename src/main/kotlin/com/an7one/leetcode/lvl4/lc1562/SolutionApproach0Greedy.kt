/**
 * https://leetcode.com/problems/find-latest-group-of-size-m/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/find-latest-group-of-size-m/discuss/806786/JavaC++Python-Count-the-Length-of-Groups-O(N)/667897
 *  https://leetcode.com/problems/find-latest-group-of-size-m/discuss/806786/JavaC++Python-Count-the-Length-of-Groups-O(N)/669065
 *  https://leetcode.com/problems/find-latest-group-of-size-m/discuss/806786/JavaC%2B%2BPython-Count-the-Length-of-Groups-O(N)
 */
package com.an7one.leetcode.lvl4.lc1562

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun findLatestStep(nums: IntArray, m: Int): Int {
        val nNums = nums.size
        var latest = -1

        val binaryString = IntArray(nNums + 2) { 0 }
        var count = 0

        for (idx in nums.indices) {
            // the index in the `binaryString`
            val idxBS = nums[idx]
            val lo = binaryString[idxBS - 1]
            val hi = binaryString[idxBS + 1]
            val total = lo + hi + 1

            if (lo == m) --count
            if (hi == m) --count

            if (total == m) ++count

            if (count > 0) latest = idx + 1

            binaryString[idxBS] = total
            binaryString[idxBS - lo] = total
            binaryString[idxBS + hi] = total
        }

        return latest
    }
}