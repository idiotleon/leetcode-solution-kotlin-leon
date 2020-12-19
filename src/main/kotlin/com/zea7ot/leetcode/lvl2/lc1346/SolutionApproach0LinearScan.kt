/**
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/check-if-n-and-its-double-exist/discuss/503441/JavaPython-3-HashSet-w-analysis.
 */
package com.zea7ot.leetcode.lvl2.lc1346

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun checkIfExist(nums: IntArray): Boolean {
        val seen = HashSet<Int>()

        for (num in nums) {
            if (seen.contains(2 * num) || num % 2 == 0 && seen.contains(num / 2)) return true
            seen.add(num)
        }

        return false
    }
}