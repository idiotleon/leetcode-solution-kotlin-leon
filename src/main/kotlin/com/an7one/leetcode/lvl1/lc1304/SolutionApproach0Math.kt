/**
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`) / O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/discuss/465585/JavaC%2B%2BPython-Find-the-Rule
 */
package com.an7one.leetcode.lvl1.lc1304

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun sumZero(n: Int): IntArray {
        val ans = IntArray(n) { 0 }
        for (idx in 0 until n) {
            ans[idx] = idx * 2 - n + 1
        }

        return ans
    }
}