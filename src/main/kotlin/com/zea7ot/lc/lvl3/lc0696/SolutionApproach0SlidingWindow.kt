/**
 * https://leetcode.com/problems/count-binary-substrings/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/count-binary-substrings/discuss/108600/Java-O(n)-Time-O(1)-Space/113793
 *  https://leetcode.com/problems/count-binary-substrings/discuss/108600/Java-O(n)-Time-O(1)-Space/221785
 */
package com.zea7ot.lc.lvl3.lc0696

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun countBinarySubstrings(s: String): Int {
        // sanity check
        if (s.isEmpty()) return 0

        var ones = 0
        var zeros = 0
        var prev = -1
        var count = 0

        for (ch in s) {
            if (ch == '0') {
                if (prev == 1) zeros = 0
                ++zeros
                prev = 0
            } else {
                if (prev == 0) ones = 0
                ++ones
                prev = 1
            }

            if ((prev == 1 && zeros >= ones) || (prev == 0 && ones >= zeros)) ++count
        }

        return count
    }
}