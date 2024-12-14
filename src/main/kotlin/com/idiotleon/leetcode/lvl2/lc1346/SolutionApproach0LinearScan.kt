package com.idiotleon.leetcode.lvl2.lc1346

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/discuss/503441/JavaPython-3-HashSet-w-analysis.
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun checkIfExist(nums: IntArray): Boolean {
        val nNums = nums.size
        val seen = HashSet<Int>(nNums)

        for (num in nums) {
            if (seen.contains(2 * num) || num % 2 == 0 && seen.contains(num / 2)) {
                return true
            }

            seen.add(num)
        }

        return false
    }
}