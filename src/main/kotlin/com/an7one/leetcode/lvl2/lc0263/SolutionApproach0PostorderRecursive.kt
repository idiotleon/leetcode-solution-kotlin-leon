/**
 * https://leetcode.com/problems/ugly-number/
 *
 * Time Complexity:     O(lg(`num`))
 * Space Complexity:    O(lg(`num`))
 *
 * References:
 *  https://leetcode.com/problems/ugly-number/
 */
package com.an7one.leetcode.lvl2.lc0263

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun isUgly(num: Int) = dfs(num)

    private fun dfs(num: Int): Boolean {
        if (num <= 0) return false
        if (num == 1) return true

        if (num % 5 == 0) return dfs(num / 5)
        if (num % 3 == 0) return dfs(num / 3)
        if (num % 2 == 0) return dfs(num / 2)

        return false
    }
}