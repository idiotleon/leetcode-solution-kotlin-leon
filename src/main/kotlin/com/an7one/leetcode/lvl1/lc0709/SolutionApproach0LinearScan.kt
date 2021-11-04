/**
 * @author: Leon
 * https://leetcode.com/problems/to-lower-case/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 */
package com.an7one.leetcode.lvl1.lc0709

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun toLowerCase(str: String): String {
        val chs = str.toCharArray()

        for (idx in chs.indices) {
            if (chs[idx] in 'A'..'Z')
                chs[idx] = chs[idx] + ('a' - 'A')
        }

        return String(chs)
    }
}