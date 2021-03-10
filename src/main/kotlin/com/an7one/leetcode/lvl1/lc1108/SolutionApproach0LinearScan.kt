/**
 * @author: Leon
 * https://leetcode.com/problems/defanging-an-ip-address/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`) / O(1)
 */
package com.an7one.leetcode.lvl1.lc1108

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    private companion object {
        private const val PERIOD = '.'
        private const val REPLACE = "[.]"
    }

    fun defangIPaddr(address: String): String {
        val builder = StringBuilder()

        for (ch in address) {
            when (ch) {
                PERIOD -> builder.append(REPLACE)
                else -> builder.append(ch)
            }
        }

        return builder.toString()
    }
}