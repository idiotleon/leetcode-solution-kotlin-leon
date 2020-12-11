/**
 * https://leetcode.com/problems/base-7/
 *
 * Time Complexity:     O(lg(`num`))
 * Space Complexity:    O(lg(`num`))
 *
 * References:
 *  https://leetcode.com/problems/base-7/discuss/98364/JavaC%2B%2BPython-Iteration-and-Recursion
 */
package com.zea7ot.leetcode.lvl2.lc0504

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ParsingString {
    fun convertToBase7(num: Int): String {
        return dfs(num)
    }

    private fun dfs(num: Int): String {
        if (num < 0) return "-" + dfs(-num)
        if (num < 7) return num.toString()
        return dfs(num / 7) + (num % 7).toString()
    }
}