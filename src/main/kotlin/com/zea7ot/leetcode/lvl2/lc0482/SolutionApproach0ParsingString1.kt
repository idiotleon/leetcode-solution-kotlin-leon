/**
 * https://leetcode.com/problems/license-key-formatting/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/license-key-formatting/discuss/96512/Java-5-lines-clean-solution
 */
package com.zea7ot.leetcode.lvl2.lc0482

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ParsingString1 {
    fun licenseKeyFormatting(str: String, k: Int): String {
        // not used
        // val lenS = str.length

        val builder = StringBuilder()
        for (idx in str.indices.reversed()) {
            if (str[idx] != '-') {
                builder.append(if (builder.length % (k + 1) == k) '-' else "").append(str[idx])
            }
        }

        return builder.reverse().toString().toUpperCase()
    }
}