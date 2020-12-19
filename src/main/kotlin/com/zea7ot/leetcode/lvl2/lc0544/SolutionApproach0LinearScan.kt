/**
 * https://leetcode.com/problems/output-contest-matches/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/output-contest-matches/discuss/101274/C%2B%2B-Java-Clean-Code
 */
package com.zea7ot.leetcode.lvl2.lc0544

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun findContestMatch(n: Int): String {
        val strs = Array(n) { "" }
        for (idx in 0 until n) {
            strs[idx] = (idx + 1).toString()
        }

        var num = n
        while (num > 1) {
            for (idx in 0 until num / 2) {
                strs[idx] = "(${strs[idx]},${strs[num - 1 - idx]})"
            }

            num /= 2
        }

        return strs[0]
    }
}