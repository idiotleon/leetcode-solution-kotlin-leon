package com.an7one.leetcode.lvl2.lc0482

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/license-key-formatting/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/license-key-formatting/discuss/96512/Java-5-lines-clean-solution/101107
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    private companion object {
        private const val DASH = '-'
    }

    fun licenseKeyFormatting(str: String, k: Int): String {
        // not used
        // val lenS = str.length
        val builder = StringBuilder()
        var len = 0

        for (idx in str.indices.reversed()) {
            if (str[idx] != DASH) {
                if (len > 0 && len % k == 0) {
                    builder.append(DASH)
                }

                builder.append(str[idx].uppercaseChar())
                ++len
            }
        }

        return builder.reverse().toString()
    }
}