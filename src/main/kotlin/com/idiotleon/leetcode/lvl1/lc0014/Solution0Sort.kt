package com.idiotleon.leetcode.lvl1.lc0014

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Time Complexity:     O(`nStrs` * lg(`nStrs`)) + O(lenS)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/longest-common-prefix/discuss/6924/Sorted-the-array-Java-solution-2-ms/8156
 * https://leetcode.com/problems/longest-common-prefix/discuss/6924/Sorted-the-array-Java-solution-2-ms
 */
@Suppress(UNUSED)
class Solution0Sort {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }

        val nStrs = strs.size
        if (nStrs == 1) {
            return strs[0]
        }

        strs.sort()
        val first = strs.first()
        val last = strs.last()

        val builder = StringBuilder()
        for (idx in first.indices) {
            if (first[idx] != last[idx]) {
                break
            }

            builder.append(first[idx])
        }

        return builder.toString()
    }
}