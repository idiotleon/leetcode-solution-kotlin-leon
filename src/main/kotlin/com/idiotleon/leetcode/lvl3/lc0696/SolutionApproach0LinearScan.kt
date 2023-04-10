/**
 * https://leetcode.com/problems/count-binary-substrings/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/count-binary-substrings/discuss/108600/Java-O(n)-Time-O(1)-Space/113793
 *  https://leetcode.com/problems/count-binary-substrings/discuss/108600/Java-O(n)-Time-O(1)-Space
 */
package com.idiotleon.leetcode.lvl3.lc0696

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun countBinarySubstrings(str: String): Int {
        val lenS = str.length

        var prev = 0
        var cur = 1
        var count = 0

        for (idx in 1 until lenS) {
            if (str[idx - 1] == str[idx]) ++cur
            else {
                prev = cur
                cur = 1
            }

            if (prev >= cur) ++count
        }

        return count
    }
}